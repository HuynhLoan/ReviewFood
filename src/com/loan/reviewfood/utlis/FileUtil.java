package com.loan.reviewfood.utlis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class FileUtil {
	
	private final static String IMAGE_STORE_LOCATION = "D:images/";
	
	public static FileInputStream readImage(String imageName) {
		String filePath = IMAGE_STORE_LOCATION + imageName;
		FileInputStream fis;
		try {
			fis = new FileInputStream(filePath);
			return fis;
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String writeFile(HttpServletRequest request) {
		try {
			Part filePart = request.getPart("image");
			
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
			fileName = UUID.randomUUID().toString() + fileName;
			String filePath = IMAGE_STORE_LOCATION + fileName;
			InputStream inputStream = null;
			OutputStream outputStream = null;
			
			File outputFilePath = new File(filePath);
			inputStream = filePart.getInputStream();
			outputStream = new FileOutputStream(outputFilePath);
			int read = 0;
			final byte[] bytes = new byte[1024];
			while((read = inputStream.read(bytes)) != -1){
			outputStream.write(bytes, 0, read);
			}
			return fileName;
			}catch (Exception e) {
			e.printStackTrace();
			}
			return null;
			
	}
}
