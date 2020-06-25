package com.capstone.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capstone.dao.AppUserDAO;
import com.capstone.entity.AppUser;

@Repository
@Transactional
public class AppUserDAOImpl implements AppUserDAO {
	
	@PersistenceContext	
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	// find account to login this website
	@Override
	 public AppUser findUserAccount(String userName) {
	        try {
	            String sql = "Select e from " + AppUser.class.getName() + " e " //
	                    + " Where e.userName = :userName ";
	 
	            Query query = entityManager.createQuery(sql, AppUser.class);
	            query.setParameter("userName", userName);
	 
	            return (AppUser) query.getSingleResult();
	        } catch (NoResultException e) {
	            return null;
	        }
	    }
	 
	 // search account exist or no
	@Override
	 public AppUser findAppUserbyUserName(String username) {
		 
		 String sql = "";
		 Query query = entityManager.createQuery(sql,AppUser.class);
		 query.setParameter("username", username);		 
		 return null;
	 }

	@Override
	public void insert(AppUser user) {
		entityManager.persist(user);
		
	}

	@Override
	public void update(AppUser user) {
		entityManager.merge(user);
		
	}

	@Override
	public void delete(AppUser user) {
		entityManager.remove(user);
		
	}

	@Override
	public AppUser get(long id) {
		return entityManager.find(AppUser.class, id);
	}

	@Override
	public List<AppUser> search(String findName, int start, int length) {
		String jql = "select u from AppUser u where User_Name like :name";
		Query query = entityManager.createQuery(jql, AppUser.class);
		query.setParameter("name", "%" + findName + "%");
		query.setFirstResult(start).setMaxResults(length);
		return query.getResultList();
	}
}
