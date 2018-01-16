package com.canteenmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canteenmanagement.pojos.Product;
import com.canteenmanagement.services.ProductService;

@RestController
@RequestMapping("/Product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("")
	private List<Product> productRoot() {
		return getAllProducts();
	}
	
	@GetMapping("/")
	public List<Product> getAllProducts() {
		return productService.getAll();
	}
	
	
}
