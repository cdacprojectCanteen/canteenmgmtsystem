package com.canteenmanagement.controllers;

import java.util.List;

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

import com.canteenmanagement.pojos.Category;
import com.canteenmanagement.services.CategoryService;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/Category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/")
	public List<Category> getCategorys(){
		return categoryService.get();
	}
	
	@GetMapping("/{categoryId}")
	public Category getCategory(@PathVariable Integer categoryId) {
		return categoryService.get(categoryId);
	}
	
	@PostMapping
	public Integer addCategory(@RequestBody Category category) {
		if(category != null)
			return categoryService.add(category);
		return -1;
	}
	
	@PutMapping("/")
	public Category updateCategory(@RequestBody Category category) {
		if(category != null)
			return categoryService.update(category);
		return null;
	}
	
	@DeleteMapping("/{categoryId}")
	public Category deleteCategory(@PathVariable Integer categoryId) {
		return categoryService.delete(categoryId);
	}
	
}
