package com.canteenmanagement.services;

import java.util.List;

import com.canteenmanagement.pojos.Category;
import com.canteenmanagement.pojos.Product;

public interface ProductService extends CanteenService<Product> {
	List<Product> getProductsByCategory(Category category);
	List<Product> getProductsByCategory(String category);
}
