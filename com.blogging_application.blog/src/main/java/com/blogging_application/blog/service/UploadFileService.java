package com.blogging_application.blog.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService{
	
	public boolean uploadFile(String pathToBeUploaded, MultipartFile file) throws IOException;

}
