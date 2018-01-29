package com.canteenmanagement.dao;

import java.util.List;

import com.canteenmanagement.pojos.Category;
import com.canteenmanagement.pojos.OrderedProduct;

public interface OrderedProductDao extends CanteenDao<OrderedProduct> {
	List<OrderedProduct> get(Category category);
	List<OrderedProduct> get(String category);
}
