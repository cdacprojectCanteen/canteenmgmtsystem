package com.canteenmanagement.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public interface FileUtils {
//	String UPLOAD_FOLDER="D:/Programming/_Projects/CDAC_Project/canteenmanagement/Uploads/";
	String UPLOAD_FOLDER="/WEB-INF/Uploads/";
	//save file
    static void saveUploadedFiles(final HttpServletRequest request, final MultipartFile file, final String fileName) throws IOException {

    	String folder = request.getSession().getServletContext().getRealPath(UPLOAD_FOLDER);
    	File directory = new File(folder);
        if (! directory.exists()){
            directory.mkdirs();
            // If you require it to make the entire directory path including parents,
            // use directory.mkdirs(); here instead.
        }

            if (file.isEmpty()) {
                return; //next pls
            }

            byte[] bytes = file.getBytes();
            Path path = Paths.get(folder + fileName);//file.getOriginalFilename());
            Files.write(path, bytes);


    }
    
    static byte[] getUploadedFiles(final HttpServletRequest request, final String fileName) throws IOException {

    	String folder = request.getSession().getServletContext().getRealPath(UPLOAD_FOLDER);
    	System.out.println("Path is:"+folder+fileName);
    	Path path = Paths.get(folder + fileName);
    	return Files.readAllBytes(path);
    }
}
