package com.canteenmanagement.services;

import java.util.List;

import com.canteenmanagement.pojos.Category;
import com.canteenmanagement.pojos.OrderedProduct;

public interface OrderedProductService extends CanteenService<OrderedProduct> {
	List<OrderedProduct> get(Category category);
	List<OrderedProduct> get(String category);
}
