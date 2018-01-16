package com.canteenmanagement.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.canteenmanagement.pojos.Product;

@Repository
public class ProductDaoImplementation implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void add(Product product) {
		sessionFactory.getCurrentSession().save(product);
	}

	@Override
	public void update(Product product) {
		sessionFactory.getCurrentSession().update(product);
	}

	@Override
	public void delete(Product product) {
		sessionFactory.getCurrentSession().delete(product);
	}

	@Override
	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = session.get(Product.class, id);
		session.delete(product);		
	}

	
}
