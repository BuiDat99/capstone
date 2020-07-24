package com.capstone.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capstone.dao.ProductResourceDAO;
import com.capstone.entity.ProductResource;

@Transactional
@Repository
public class ProductResourceDAOImpl implements ProductResourceDAO {

	@PersistenceContext
	
	EntityManager entityManager;
	@Override
	public void addProductResource(ProductResource productResource) {
		entityManager.persist(productResource);
		
	}

	@Override
	public void updateProductResourc(ProductResource productResource) {
		entityManager.merge(productResource);
		
	}

	@Override
	public void deleteProductResourc(ProductResource productResource) {
		entityManager.remove(productResource);
		
	}

	@Override
	public List<ProductResource> getAllProductResource() {
		String jql = "select pr from ProductResource pr";
		return entityManager.createQuery(jql,ProductResource.class).getResultList();
	}

	@Override
	public ProductResource getProductResourcebyId(int id) {
		return entityManager.find(ProductResource.class, id);
	}

}
