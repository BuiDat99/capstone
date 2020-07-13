package com.capstone.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.capstone.dao.ResourceDAO;
import com.capstone.entity.Resource;

@Transactional
@Repository
public class ResourceDAOImpl implements ResourceDAO {

	@PersistenceContext
	
	EntityManager entityManager;
	@Override
	public void addResource(Resource resource) {
		entityManager.persist(resource);
		
	}

	@Override
	public void updateResource(Resource resource) {
		entityManager.merge(resource);
		
	}

	@Override
	public void deleteResource(Resource resource) {
		entityManager.remove(resource);
		
	}

	@Override
	public List<Resource> getAllResources() {
		String jql = "select r from Resource r";
		return entityManager.createQuery(jql,Resource.class).getResultList();
	}

	@Override
	public Resource getResourcebyId(int id) {
		return entityManager.find(Resource.class, id);
	}

	@Override
	public List<Resource> search(String findName, int start, int length) {
		String jql = "select r from Resource r where resourceName like :resourceName";
		Query query = entityManager.createQuery(jql,Resource.class);
		query.setParameter("resourceName", "%" + findName + "%");
		query.setFirstResult(start).setMaxResults(length);
		return query.getResultList();
	}

	@Override
	public int countResourceWhensearch(String name) {
		String jql="select r from Resource r where resourceName like :resourceName";
		Query query = entityManager.createQuery(jql,Resource.class);
		query.setParameter("resourceName", "%" + name + "%");
		return (int) query.getResultList().size();
	}

}