package com.canteenmanagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.canteenmanagement.pojos.Category;
import com.canteenmanagement.pojos.Product;

@Repository
public class ProductDaoImplementation extends CanteenDaoImplementation<Product> implements ProductDao {

	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public Integer add(Product product) {
		return (Integer) sessionFactory.getCurrentSession().save(product);
	}

	@Override
	public Product update(Product product) {
		sessionFactory.getCurrentSession().update(product);
		return product;
	}

	@Override
	public Product delete(Product product) {
		sessionFactory.getCurrentSession().delete(product);
		return product;
	}

	@Override
	public Product delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = session.get(Product.class, id);
		session.delete(product);	
		return product;
	}
	
	@Override
	public List<Product> get() {
		String jpql = "SELECT p from Product p";
		Session session = sessionFactory.getCurrentSession();
		List<Product> list = session.createQuery(jpql, Product.class).getResultList();
		return list;
	}

	@Override
	public Product get(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = session.get(Product.class, id);
		return product;
	}
	
	@Override
	public List<Product> get(Category category) {
		String jpql = "select p from Product p where p.category=:category";
		return sessionFactory.getCurrentSession()
				.createQuery(jpql, Product.class)
				.setParameter("category", category.getName())
				.getResultList();
	}

	@Override
	public List<Product> get(String category) {
		String jpql = "select p from Product p where p.category=:category";
		return sessionFactory.getCurrentSession()
				.createQuery(jpql, Product.class)
				.setParameter("category", category)
				.getResultList();
	}
	
}
