package com.capstone.model;

public class AppUserDTO {

	private long userId;
	private String username;
	private String password;
	private String email;	
	private byte enable;
	
	public AppUserDTO() {
		// TODO Auto-generated constructor stub
	}

	public AppUserDTO(long userId, String username, String password, String email, byte enable) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.enable = enable;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getEnable() {
		return enable;
	}

	public void setEnable(byte enable) {
		this.enable = enable;
	}
	
	
	
}