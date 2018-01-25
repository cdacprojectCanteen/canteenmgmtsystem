package com.canteenmanagement.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.canteenmanagement.pojos.Product;
import com.canteenmanagement.services.ProductService;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/Product")
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
	public Integer addProduct(@RequestBody Product product, HttpServletResponse  response) {
//		System.out.println("<<<<<<<<<<-----------Adding products--------->>>>>>>>>>"+product.toString());
		if(product != null)
			return productService.add(product);
		return -1;
	}
	
	@PutMapping("/")
	public Product updateProduct(@RequestBody Product product) {
		if(product != null)
			return productService.update(product);
		return null;
	}
	
	@DeleteMapping("/{productId}")
	public Product deleteProduct(@PathVariable Integer productId) {
		return productService.delete(productId);
	}
	
}
