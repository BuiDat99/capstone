package com.capstone.dao;

import java.util.List;

import com.capstone.entity.Product;

public interface ProductDAO {

	public List<String> getProductNameContainResource(int resourceId );

	public void addProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void deleteProduct(Product product);
	
	public List<Product> getAllProduct();
	
	public Product getProductbyId(int id);
}
