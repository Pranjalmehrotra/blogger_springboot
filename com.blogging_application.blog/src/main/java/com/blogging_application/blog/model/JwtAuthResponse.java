package com.blogging_application.blog.security;


public class JwtAuthResponse {
	
	public String getToken() {
		return token;
	}

	@Override
	public String toString() {
		return "JwtAuthResponse [token=" + token + "]";
	}

	public JwtAuthResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JwtAuthResponse(String token) {
		super();
		this.token = token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	private String token;
	

}
