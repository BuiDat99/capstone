package com.capstone.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.capstone.model.ProductDTO;
import com.capstone.model.ProductResourceDTO;
import com.capstone.model.ResourceDTO;
import com.capstone.service.ProductResourceService;
import com.capstone.service.ProductService;
import com.capstone.service.ResourceService;

@Controller
public class AdminProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	private ProductResourceService prService;
	
	@GetMapping(value = "/admin/product/search")
	public String searchProduct(HttpServletRequest request) {
		
		List<ProductDTO> listProduct = productService.getAllProducts();
		request.setAttribute("listProduct", listProduct);
		
		List<ProductResourceDTO> listPr = prService.getAllProductResource();
		request.setAttribute("listPr", listPr);
		return "admin/product/manage-product";
	}
	

	
	
}
