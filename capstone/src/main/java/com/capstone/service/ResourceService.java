package com.capstone.service;

import java.util.List;

import com.capstone.model.ResourceDTO;

public interface ResourceService {
	
	public List<ResourceDTO> getResourceOfProduct(int productId);
	
	public void addResource(ResourceDTO resource);
	
	public void updateResource(ResourceDTO resourceDTO);
	
	public void deleteResource(int id);
	
	public List<ResourceDTO> getAllResources();
	
	public List<ResourceDTO> getResourceByCategory(String catName);
	
	public ResourceDTO getResourcebyId(int id);
	
	public List<ResourceDTO> search(String findName, int start, int length);
	
	public int countResourceWhensearch(String name);

	public List<ResourceDTO> getResourceFromWithResouceCatId(int id);
}
