package com.capstone.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dao.AppUserDAO;
import com.capstone.entity.AppUser;
import com.capstone.model.AppUserDTO;
import com.capstone.service.AppUserService;

@Transactional
@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	private AppUserDAO userDao;
	@Override
	public void insert(AppUserDTO userDTO) {
		AppUser user = new AppUser();	
		if(user != null) {
		user.setUserName(userDTO.getUsername());
		user.setEncrytedPassword(userDTO.getPassword());
		user.setEmail(userDTO.getEmail());
		userDao.insert(user);
		}
	}

	@Override
	public AppUserDTO get(Long id) {
		AppUser user = userDao.get(id);
		AppUserDTO dto = new AppUserDTO();
		dto.setUserId(user.getUserId());
		dto.setUsername(user.getUserName());
		dto.setPassword(user.getEncrytedPassword());
		dto.setEmail(user.getEmail());
		
		return dto;
	}
	
	@Override
	public void update(AppUserDTO userDTO) {
		AppUser user = userDao.get(userDTO.getUserId());
		if(user != null) {
			user.setUserName(userDTO.getUsername());
			user.setEncrytedPassword(userDTO.getPassword());
			user.setEmail(userDTO.getEmail());
			userDao.update(user);
		}
		
	}

	@Override
	public void delete(Long id) {
		AppUser user = userDao.get(id);
		if(user != null) {
			userDao.delete(user);
		}
		
	}

	@Override
	public List<AppUserDTO> search(String name, int start, int length) {
		List<AppUser> users = userDao.search(name, start, length);
		List<AppUserDTO> dtos = new ArrayList<AppUserDTO>();
		for(AppUser u : users) {
			AppUserDTO dto = new AppUserDTO();
			dto.setUserId(u.getUserId());
			dto.setUsername(u.getUserName());
			dto.setPassword(u.getEncrytedPassword());
			dto.setEmail(u.getEmail());
			dtos.add(dto);
		}
		return dtos;
	}
	
	@Override  //them dong nay`
	public boolean checkExistUser(String name) {
		AppUser user = userDao.findUserAccount(name);
		boolean check = false;
		if(user != null) {
			check = true;
		}
		return check;
	}

	@Override   //them dong nay`
	public boolean checkExistUserEmail(String email) {
		AppUser user = userDao.findUserAccountEmail(email);
		boolean check = false;
		if(user != null) {
			check = true;
		}
		return check;
	}

}
