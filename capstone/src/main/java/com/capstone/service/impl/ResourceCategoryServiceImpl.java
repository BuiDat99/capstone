package com.capstone.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dao.ResourceCategoryDAO;
import com.capstone.entity.ResourceCategory;
import com.capstone.model.ResourceCategoryDTO;
import com.capstone.service.ResourceCategoryService;

@Service
@Transactional
public class ResourceCategoryServiceImpl implements ResourceCategoryService {

	@Autowired
	private ResourceCategoryDAO categoryDao;
	@Override
	public void addCategory(ResourceCategoryDTO category) {
		ResourceCategory rc = new ResourceCategory();
		rc.setCategoryName(rc.getCategoryName());
		categoryDao.addCategory(rc);
		
	}

	@Override
	public void updateCategory(ResourceCategoryDTO categoryDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ResourceCategoryDTO> getAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResourceCategoryDTO getCategorybyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResourceCategoryDTO> search(String findName, int start, int length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countCategoryWhensearch(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

}
