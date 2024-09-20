package com.blogging_application.blog.controller;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blogging_application.blog.service.UploadFileService;




@RestController
//@RequestMapping("/file-apis")
public class FileController {
	
	private UploadFileService uploadFileService;
	
	@Value("${project.images}")
	private String filePath;
	
	public FileController(UploadFileService uploadFileService) {
		this.uploadFileService = uploadFileService;
	}

	
	//Method1 -->Using the FileResponse as an Error Message
	/*
	 * @PostMapping("/file-upload")
	 * ResponseEntity<FileResponse>fileUpload(@RequestParam("fileUpload")
	 * MultipartFile fileUpload){
	 * 
	 * String fileName = null; try {
	 * System.out.println("Inside try of fileUpload controller ");
	 * 
	 * fileName = this.uploadFile.uploadFile(filePath, fileUpload);
	 * 
	 * }catch(Exception e) { e.printStackTrace(); return new
	 * ResponseEntity<FileResponse>(new
	 * FileResponse(fileName,"File Not Uploaded Successfully.Error is ::" + e
	 * ,500),HttpStatus.INTERNAL_SERVER_ERROR);
	 * 
	 * 
	 * }
	 * 
	 * return new ResponseEntity<FileResponse>(new
	 * FileResponse(fileName,"File Successfully uploaded,",200),HttpStatus.OK);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	
	@PostMapping("/file-upload")
	public Map<String,Object> fileUpload(@RequestParam("fileUpload")MultipartFile fileUpload){
		
	Map<String,Object> fileMapValue = new HashMap<>();
		try {
			System.out.println("Inside try of fileUpload controller ");
			
			boolean isFileUploaded = this.uploadFileService.uploadFile(filePath, fileUpload);
			
			if(isFileUploaded) {
				fileMapValue.put("message","file Successfully uploaded");
				fileMapValue.put("status", 200);
				
			}
			else {
				fileMapValue.put("message","File not uploaded!!Please upload proper format of the file");
				fileMapValue.put("status", 300);

			}
			
		}catch(Exception e) {
			e.printStackTrace();
			fileMapValue.put("message","Error in uploading the file " + e);
			fileMapValue.put("status", 500);
			//fileMapValue.put("fileName", fileNameUploaded);

			
		}
		return fileMapValue;
	}

}
