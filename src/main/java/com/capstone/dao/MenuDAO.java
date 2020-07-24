package com.capstone.dao;

import java.util.List;

import com.capstone.entity.Menu;

public interface MenuDAO {

	public void addMenu(Menu menu);
	
	public void updateMenu(Menu menu);
	
	public void deleteMenu(Menu menu);
	
	public List<Menu> getAllMenu();
	
	public Menu getMenubyId(int id);
}
