package com.canteenmanagement.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canteenmanagement.utils.FileUtils;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/Assets")
public class StaticFilesController {
	
	@GetMapping(path="/Image/{fileName:.*}", produces="image/*")
	public byte[] getImage(@PathVariable String fileName, HttpServletRequest request) throws IOException {
		System.out.println("Request received");
		return FileUtils.getUploadedFiles(request, fileName);
	}
}
