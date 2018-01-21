package com.canteenmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canteenmanagement.dao.ProductDao;
import com.canteenmanagement.pojos.Category;
import com.canteenmanagement.pojos.Product;

@Service
@Transactional
public class ProductServiceImplementation implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public Integer add(Product product) {
		return productDao.add(product);
	}

	@Override
	public Product update(Product product) {
		productDao.update(product);
		return product;
	}

	@Override
	public Product delete(Product product) {
		return productDao.delete(product);
	}

	@Override
	public Product delete(Integer id) {
		return productDao.delete(id);
	}

	@Override
	public Product get(Integer id) {
		return productDao.get(id);
	}

	@Override
	public List<Product> get() {
		return productDao.get();
	}

	@Override
	public List<Product> get(Category category) {
		return productDao.get(category);
	}

	@Override
	public List<Product> get(String category) {
		return productDao.get(category);
	}


}
