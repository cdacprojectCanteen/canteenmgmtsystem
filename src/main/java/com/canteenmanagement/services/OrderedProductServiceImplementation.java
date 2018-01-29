package com.canteenmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canteenmanagement.dao.OrderedProductDao;
import com.canteenmanagement.pojos.Category;
import com.canteenmanagement.pojos.OrderedProduct;

@Service
@Transactional
public class OrderedProductServiceImplementation implements OrderedProductService {
	
	@Autowired
	private OrderedProductDao productDao;

	@Override
	public Integer add(OrderedProduct product) {
		return productDao.add(product);
	}

	@Override
	public OrderedProduct update(OrderedProduct product) {
		productDao.update(product);
		return product;
	}

	@Override
	public OrderedProduct delete(OrderedProduct product) {
		return productDao.delete(product);
	}

	@Override
	public OrderedProduct delete(Integer id) {
		return productDao.delete(id);
	}

	@Override
	public OrderedProduct get(Integer id) {
		return productDao.get(id);
	}

	@Override
	public List<OrderedProduct> get() {
		return productDao.get();
	}

	@Override
	public List<OrderedProduct> get(Category category) {
		return productDao.get(category);
	}

	@Override
	public List<OrderedProduct> get(String category) {
		return productDao.get(category);
	}


}
