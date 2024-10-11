package com.blogging_apllication.blog.security;

import lombok.Data;

@Data
public class AuthModel {
	private String email;
	private String password;
	
	
	public AuthModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AuthModel [email=" + email + ", password=" + password + "]";
	}

	public AuthModel(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	


	
}
