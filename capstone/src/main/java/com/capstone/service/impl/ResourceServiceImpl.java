package com.capstone.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dao.ResourceDAO;
import com.capstone.entity.Resource;
import com.capstone.model.ResourceDTO;
import com.capstone.service.ResourceService;

@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private ResourceDAO resourceDao;
	@Override
	public void addResource(ResourceDTO resource) {
		Resource r = new Resource();
		r.setResourceName(r.getResourceName());
		r.setImage(r.getImage());
		r.setKcal1g(r.getKcal1g());
		r.setResourceDescrption(r.getResourceDescrption());
		resourceDao.addResource(r);
		
	}

	@Override
	public void updateResource(ResourceDTO resourceDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteResource(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ResourceDTO> getAllResources() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResourceDTO getResourcebyId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResourceDTO> search(String findName, int start, int length) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countResourceWhensearch(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

}
