package com.blogging.application.blog.model;

//import java.io.Serializable;

public class BlogApiResponse<T>{
	//private static final long serialVersionUID = 1L;
	private String message;
	private T data;
	//private HttpStatus statusCode;
	private Integer statusCode;
	

	
	
	
	public BlogApiResponse(String message, Integer status,T data) {
		super();
		this.message = message;
		this.statusCode = status;
		this.data = data;
	}

	public BlogApiResponse() {
		super();
	}
	/*
	 * public static long getSerialversionuid() { return serialVersionUID; }
	 */

	

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "TBankResponse [message=" + message + ", data=" + data + ", statusCode=" + statusCode + "]";
	}
	
	
}

