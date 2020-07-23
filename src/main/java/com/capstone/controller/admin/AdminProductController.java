package com.capstone.controller.admin;

import java.beans.PropertyEditor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.capstone.entity.Product;
import com.capstone.model.ProductDTO;
import com.capstone.model.ProductResourceDTO;
import com.capstone.model.ResourceCategoryDTO;
import com.capstone.repository.ProductRepository;
import com.capstone.service.ProductResourceService;
import com.capstone.service.ProductService;
import com.capstone.service.ResourceCategoryService;
import com.capstone.utils.DuplicateParameterReducingPropertyEditor;

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

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		PropertyEditor stringEditor = new DuplicateParameterReducingPropertyEditor();
		binder.registerCustomEditor(String.class, stringEditor);
	}

	@GetMapping(value = "/admin/product/search")
	public String searchProduct(HttpServletRequest request) {

		List<ProductDTO> listProduct = productService.getAllProducts();
		request.setAttribute("listProduct", listProduct);

		List<ProductResourceDTO> listPr = prService.getAllProductResource();
		request.setAttribute("listPr", listPr);
		return "admin/product/manage-product";
	}

	@GetMapping(value = "/admin/product/add-product")
	public String addProduct(HttpServletRequest request) {
		List<ResourceCategoryDTO> categoryList = categoryService.getAllCategories();
		request.setAttribute("categoryList", categoryList);
		return "admin/product/add-product";
	}

	@PostMapping(value = "/admin/product/add-product")
	public String addProductPost(HttpServletRequest request,
			@RequestParam(value = "resource", required = false) String[] resourceIds,
			@RequestParam(value = "productName", required = false) String productName,
			@RequestParam(value = "image", required = false) MultipartFile file) {
		List<ProductDTO> listProduct = productService.getAllProducts();
		request.setAttribute("listProduct", listProduct);
		List<ProductResourceDTO> listPr = prService.getAllProductResource();
		request.setAttribute("listPr", listPr);

		Product p = new Product();
		p.setProductName(productName);
		p.setImage(storeFile(file));
		p = productRepository.save(p);

		for (String r : resourceIds) {
			prService.addProductResourceWithId(p.getId(), Integer.parseInt(r));
		}

		return "admin/product/manage-product";
	}

	public String storeFile(MultipartFile file) {
		try {
			Path directoryPath = Paths.get(System.getProperty("user.dir")).toAbsolutePath().normalize();
			try {
				Files.createDirectories(directoryPath);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Path targetLocation = directoryPath.resolve(file.getOriginalFilename());
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			System.out.println(targetLocation.toString());
			return targetLocation.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
