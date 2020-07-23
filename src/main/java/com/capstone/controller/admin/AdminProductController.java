package com.capstone.controller.admin;

import java.beans.PropertyEditor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.capstone.entity.Product;
import com.capstone.entity.ProductResource;
import com.capstone.entity.Resource;
import com.capstone.model.ProductDTO;
import com.capstone.model.ProductResource2Dto;
import com.capstone.model.ProductResourceDTO;
import com.capstone.model.Resource2Dto;
import com.capstone.model.ResourceCategoryDTO;
import com.capstone.repository.ProductRepository;
import com.capstone.repository.ProductResourceRepository;
import com.capstone.repository.ResourceRepository;
import com.capstone.service.ProductResourceService;
import com.capstone.service.ProductService;
import com.capstone.service.ResourceCategoryService;
import com.capstone.utils.DuplicateParameterReducingPropertyEditor;
import com.capstone.utils.ImgurUtil;

@Controller
public class AdminProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductResourceService prService;

	@Autowired
	private ResourceCategoryService categoryService;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ImgurUtil imgurUtil;

	@Autowired
	private ProductResourceRepository productResourceRepository;

	@Autowired
	private ResourceRepository resourceRepository;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		PropertyEditor stringEditor = new DuplicateParameterReducingPropertyEditor();
		binder.registerCustomEditor(String.class, stringEditor);
	}

	@GetMapping(value = "/admin/product/search")
	public String searchProduct(HttpServletRequest request) {

		List<ProductDTO> listProduct = productService.getAllProducts();
		// for (ProductDTO pdto : listProduct) {
		// 	Product p = productRepository.findById(pdto.getId()).get();
		// 	List<Resource> rlist = productResourceRepository.findByProduct(p);
		// 	List<String> resources = new ArrayList<>();
		// 	for (Resource r : rlist) {
		// 		resources.add(r.getResourceName);
		// 	}
		// 	pdto.setResources(resources);
		// }
		request.setAttribute("listProduct", listProduct);
		return "admin/product/manage-product";
	}

	@GetMapping(value = "/admin/product/add-product")
	public String addProduct(HttpServletRequest request) {
		List<ResourceCategoryDTO> categoryList = categoryService.getAllCategories();
		request.setAttribute("categoryList", categoryList);
		return "admin/product/add-product";
	}

	@PostMapping(value = "/admin/product/add-product")
	public @ResponseBody int addProductPost(HttpServletRequest request,
			@RequestParam(value = "productName", required = false) String productName,
			@RequestParam(value = "productDescription", required = false) String productDescription,
			@RequestParam(value = "image", required = false) MultipartFile file) {
		Product p = new Product();
		p.setProductName(productName);
		p.setProductDescription(productDescription);
		p.setImage(imgurUtil.uploadImage(file));
		p = productRepository.save(p);

		return p.getId();
	}

	@PostMapping(value = "/admin/product/add-resources-to-product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "text/plain;charset=UTF-8")
	public String addResourceToProduct(HttpServletRequest request,
			@RequestBody ProductResource2Dto productResourceDto) {
		List<ProductDTO> listProduct = productService.getAllProducts();
		request.setAttribute("listProduct", listProduct);
		List<ProductResourceDTO> listPr = prService.getAllProductResource();
		request.setAttribute("listPr", listPr);

		Product p = productRepository.findById(productResourceDto.getProductId()).get();
		for (Resource2Dto r : productResourceDto.getResources()) {
			Resource res = resourceRepository.findById(r.getId()).get();
			ProductResource prodResource = new ProductResource();
			prodResource.setResource(res);
			prodResource.setProduct(p);
			prodResource.setKcal1g(r.getGram());
			productResourceRepository.save(prodResource);
		}

		return "admin/product/manage-product";
	}
}
