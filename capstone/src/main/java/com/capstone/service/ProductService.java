package com.capstone.service;

import java.util.List;

import com.capstone.model.ProductDTO;

public interface ProductService {

	public void addProduct(ProductDTO product);
	
	public void updateProduct(ProductDTO productDTO);
	
	public void deleteProduct(int id);
	
	public List<ProductDTO> getAllProducts();
	
	public ProductDTO getProductbyId(int id);
}
