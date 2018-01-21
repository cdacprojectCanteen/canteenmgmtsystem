package com.canteenmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canteenmanagement.pojos.Product;
import com.canteenmanagement.services.ProductService;

@RestController
@RequestMapping("/Product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public List<Product> getProducts(){
		return productService.get();
	}
	
	@GetMapping("/{productId}")
	public Product getProduct(@PathVariable Integer productId) {
		return productService.get(productId);
	}
	
	@PostMapping
	public Integer addProduct(@RequestBody Product product) {
		return productService.add(product);
	}
	
	@PutMapping("/{productId}")
	public Product updateProduct(@PathVariable Integer productId, @RequestBody Product product) {
		return productService.update(product);
	}
	
	@DeleteMapping("/{productId}")
	public Product deleteProduct(@PathVariable Integer productId) {
		return productService.delete(productId);
	}
	
}
