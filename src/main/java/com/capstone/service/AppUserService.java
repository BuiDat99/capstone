package com.capstone.service;

import java.util.List;

import com.capstone.model.AppUserDTO;

public interface AppUserService {

	void insert(AppUserDTO userDTO);

	void update(AppUserDTO userDTO);

	void delete(Long id);

	AppUserDTO get(Long id);
	
	List<AppUserDTO> search(String name, int start, int length);

	boolean checkExistUser(String name);

	boolean checkExistUserEmail(String name);
	

}
