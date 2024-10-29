package com.blogging_application.blog.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blogging_application.blog.utils.CommonMethods;

@Service
public class UploadFileServiceImpl implements UploadFileService {

	@Override
	public boolean uploadFile(String folderPathInputByUser, MultipartFile file) throws IOException {
		List<String> fileExtensionList = List.of("jpg", "png", "jpeg");
		List<String> fileExtensionsAllowed = new ArrayList<String>(fileExtensionList);
		// First way of splitting on the basis of "." character
		// String[] listOfFileWithExtension = getActualFileName.split("\\.");

		String getActualFileName = file.getOriginalFilename();

		// Another way of splitting is::
		String[] listOfFileContents = getActualFileName.split("[.]");
		String fileName = listOfFileContents[0];
		String fileExtension = listOfFileContents[1];

		// TODO Auto-generated method stub

		String getFileExtension = CommonMethods.getExtensionByStringHandling(file.getOriginalFilename()).get();
		System.out.println("Extension of file to be uploaded is ::" + getFileExtension);

		if (!fileExtensionsAllowed.contains(getFileExtension)) {

			return false;

		}

		System.out.println("Actual file name is ::" + getActualFileName);

		File folderForUploadingFilesByUser = new File(folderPathInputByUser);

		if (!folderForUploadingFilesByUser.exists()) {

			folderForUploadingFilesByUser.mkdir();

		}

		String actualFilePathToBeUploaded = folderPathInputByUser + file.getOriginalFilename();

		boolean isFileExist = CommonMethods.isFileExist(fileName, folderForUploadingFilesByUser);
		if (isFileExist) {
			System.out.println("Image already exist");
			String updatedFileName = CommonMethods.getDuplicateName(fileName, folderForUploadingFilesByUser);
			System.out.println("updated file name::" + updatedFileName);
			String updatedActualFilePathToBeUploaded = CommonMethods.actualFilePathToBeUploaded(folderPathInputByUser,
					updatedFileName + "." + fileExtension);
			System.out.println("updated path to be uploaded::" + updatedActualFilePathToBeUploaded);
//***************************************************************************************************************************************
			// METHOD1--->Using the Copy method of Files operation.
			// Files.copy(file.getInputStream(),Paths.get(updatedFilePathToBeUploaded));
//***************************************************************************************************************************************
			// METHOD2--->Using the Write method of File operation
			FileOutputStream fout = new FileOutputStream(updatedActualFilePathToBeUploaded);
			fout.write(file.getBytes());
			fout.close();

		} else {

			// METHOD1--->Using the Copy method of Files operation.
			// Files.copy(file.getInputStream(),Paths.get(actualFilePathToBeUploaded));
//***********************************************************************************************************************************

			// METHOD2--->Using the Write method of File operation
			FileOutputStream fout = new FileOutputStream(actualFilePathToBeUploaded);
			fout.write(file.getBytes());
			fout.close();

		}
		return true;

	}

}
