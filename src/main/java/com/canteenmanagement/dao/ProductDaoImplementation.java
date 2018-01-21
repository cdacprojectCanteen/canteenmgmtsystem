package com.canteenmanagement.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.canteenmanagement.pojos.Category;
import com.canteenmanagement.pojos.Product;

@Repository
public class ProductDaoImplementation extends CanteenDaoImplementation<Product> implements ProductDao {

	@Override
	public List<Product> get(Category category) {
		String jpql = "select p from Product where p.category=:category";
		return sessionFactory.getCurrentSession()
				.createQuery(jpql, Product.class)
				.setParameter("category", category.getName())
				.getResultList();
	}

	@Override
	public List<Product> get(String category) {
		String jpql = "select p from Product where p.category=:category";
		return sessionFactory.getCurrentSession()
				.createQuery(jpql, Product.class)
				.setParameter("category", category)
				.getResultList();
	}
	
}
