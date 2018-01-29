package com.canteenmanagement.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.canteenmanagement.pojos.Product;
import com.canteenmanagement.services.ProductService;
import com.canteenmanagement.utils.FileUtils;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/Product")
@MultipartConfig(location="/temp",
fileSizeThreshold=0,    
maxFileSize=5242880,       // 5 MB
maxRequestSize=20971520)
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public List<Product> getProducts(HttpServletResponse response){
		return productService.get();
	}
	
	@GetMapping("/{productId}")
	public Product getProduct(@PathVariable Integer productId) {
		return productService.get(productId);
	}
	
	
	@PostMapping("/")
	public Integer addProduct(
			@RequestPart("json") Product product,
			@RequestPart("file") MultipartFile productImage, HttpServletResponse response, HttpServletRequest request) throws IOException {
		System.out.println(productImage.getName()+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+productImage.getOriginalFilename());
		
		
		if(product != null) {
			Integer id;
			if(product.getProductImageUrl() != null && product.getProductImageUrl().trim().length()>=3 && productImage.getOriginalFilename().lastIndexOf('.') != -1) {
				String origFileName = productImage.getOriginalFilename().substring(0, productImage.getOriginalFilename().lastIndexOf('.'));
				String ext = productImage.getOriginalFilename().substring(productImage.getOriginalFilename().lastIndexOf('.'));
				Date date = new Date();
				String fileName = origFileName+date.getTime()+ext; //TODO VERIFY THIS STRATEGY FROM SIR
	//			String filePath = "/Assets/Image/"+fileName;
				product.setProductImageUrl(fileName);
				id = productService.add(product);
				
				FileUtils.saveUploadedFiles(request, productImage, fileName);
			}
			else {
				id = productService.add(product);
			}
			return id;
		}
		return -1;
	}
	
	@PutMapping("/")
	public Product updateProduct(
			@RequestPart("json") Product product,
			@RequestPart(name="file",required=false) MultipartFile productImage, HttpServletResponse response, HttpServletRequest request) throws IOException {
		System.out.println(productImage.getName()+"<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+productImage.getOriginalFilename());
		System.out.println(product);
		
		if(product != null) {
			Product updatedProduct;
			if(product.getProductImageUrl() != null && product.getProductImageUrl().trim().length()>=3 && productImage.getOriginalFilename().lastIndexOf('.') != -1) {
				String origFileName = productImage.getOriginalFilename().substring(0, productImage.getOriginalFilename().lastIndexOf('.'));
				String ext = productImage.getOriginalFilename().substring(productImage.getOriginalFilename().lastIndexOf('.'));
				Date date = new Date();
				String fileName = origFileName+date.getTime()+ext; //TODO VERIFY THIS STRATEGY FROM SIR
	//			String filePath = "/Assets/Image/"+fileName;
				product.setProductImageUrl(fileName);
				
				updatedProduct = productService.update(product);
				
				FileUtils.saveUploadedFiles(request, productImage, fileName);
			}
			else {
				product.setProductImageUrl(productService.get(product.getProductId()).getProductImageUrl());
				updatedProduct = productService.update(product);
			}
			
			return updatedProduct;
		}
		return null;
	}
	
	
	@DeleteMapping("/{productId}")
	public Product deleteProduct(@PathVariable Integer productId) {
		return productService.delete(productId);
	}
	
}
