package com.canteenmanagement.services;

import java.util.List;

import com.canteenmanagement.pojos.Category;
import com.canteenmanagement.pojos.Product;

public interface ProductService extends CanteenService<Product> {
	List<Product> get(Category category);
	List<Product> get(String category);
}
