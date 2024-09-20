package utils;
import java.io.File;
import java.util.Optional;


public class CommonMethods {

	// Getting the extension using the StreamAPIS concept
	public static Optional<String> getExtensionByStringHandling(String filename) {
		return Optional.ofNullable(filename).filter(f -> f.contains("."))
				.map(f -> f.substring(filename.lastIndexOf(".") + 1));

	}
	public static boolean isFileExist(String fileName, File fileList) {
		for (File fileNameExist : fileList.listFiles()) {
			if (fileNameExist.getName().toLowerCase().contains(fileName.toLowerCase())) {
				return true;
			}
		}
		return false;

	}

	public static String getDuplicateName(String fileName, File fileList) {
		int i = 0;
		var name = fileName;
		do {
			//name = i == 0 ? "#{fileName}_Edited" : "#{fileName}_Edited($i)";
			name = i == 0 ? fileName + "_Edited" : fileName +"_Edited("+i+")";

			i = i + 1;

		} while (isFileExist(name, fileList));
		return name;
	}


	public static String actualFilePathToBeUploaded(String path,String fileName) {
		String filePathToBeUploaded = "";
		if(path != null  && !path.isEmpty() || fileName != null && fileName.isEmpty()) {
			filePathToBeUploaded = path + fileName;
			
		}
		return filePathToBeUploaded;
	}


}
