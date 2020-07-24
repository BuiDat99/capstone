package com.capstone.dao;

import java.util.List;

import com.capstone.entity.NewCategory;

public interface NewCategoryDAO {

	public void addCategory(NewCategory category);
	
	public void updateCategory(NewCategory category);
	
	public void deleteCategory(NewCategory category);
	
	public List<NewCategory> getAllCategories();
	
	public NewCategory getCategorybyId(int id);
	
	public List<NewCategory> search(String findName, int start, int length);
	
	public int countCategoryWhensearch(String name);
}
