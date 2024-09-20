package com.blogging.application.blog.model;

public class FileResponse {
	
	private String fileName;
	private String fileMessage;
	private Integer statusCode;

	public String getFileName() {
		return fileName;
	}

	public FileResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileMessage() {
		return fileMessage;
	}

	public void setFileMessage(String fileMessage) {
		this.fileMessage = fileMessage;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public FileResponse(String fileName, String fileMessage, Integer statusCode) {
		super();
		this.fileName = fileName;
		this.fileMessage = fileMessage;
		this.statusCode = statusCode;
	}

	

}
