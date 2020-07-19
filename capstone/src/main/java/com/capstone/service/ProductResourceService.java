package com.capstone.service;

import java.util.List;

import com.capstone.model.ProductResourceDTO;

public interface ProductResourceService {

	public void addProductResource(ProductResourceDTO productResource);
	
	public void updateProductResource(ProductResourceDTO productResource);
	
	public void deleteProductResource(int id);
	
	public List<ProductResourceDTO> getAllProductResource();
	
	public ProductResourceDTO getProductResourcebyId(int id);
}
