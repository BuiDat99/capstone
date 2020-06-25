package com.capstone.model;

public class AppUserDTO {

	private long userId;
	private String username;
	private String password;
	private String email;
	private String role;
	
	public AppUserDTO() {
		// TODO Auto-generated constructor stub
	}

	public AppUserDTO(long userId, String username, String password, String email, String encrytedPassword,
			String role) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;		
		this.role = role;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
}
