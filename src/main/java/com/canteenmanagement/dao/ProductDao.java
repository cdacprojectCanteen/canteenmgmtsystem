package com.canteenmanagement.dao;

import java.util.List;

import com.canteenmanagement.pojos.Category;
import com.canteenmanagement.pojos.Product;

public interface ProductDao extends CanteenDao<Product> {
	List<Product> get(Category category);
	List<Product> get(String category);
}
