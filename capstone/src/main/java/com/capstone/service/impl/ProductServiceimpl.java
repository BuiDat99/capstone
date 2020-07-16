package com.capstone.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dao.ProductDAO;
import com.capstone.entity.Product;
import com.capstone.entity.ProductResource;
import com.capstone.entity.Resource;
import com.capstone.model.ProductDTO;
import com.capstone.model.ResourceCategoryDTO;
import com.capstone.model.ResourceDTO;
import com.capstone.service.ProductService;

@Service
@Transactional
public class ProductServiceimpl implements ProductService {

	@Autowired
	private ProductDAO productDao;
	
	@Override
	public void addProduct(ProductDTO product) {
		Product p = new Product();
		p.setImage(product.getImage());
		p.setProductName(product.getProductName());
		productDao.addProduct(p);		
		//tao moi 1 product
		product.setId(p.getId());
		// lay duoc id cua product
		
		ResourceDTO resource = new ResourceDTO();
		Resource r = new Resource();
		resource.setId(r.getId());		
		// lay duoc id cua resource
		
		ProductResource productResource = new ProductResource();
		
		
		
		
		
	}

	@Override
	public void updateProduct(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductDTO> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO getProductbyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
