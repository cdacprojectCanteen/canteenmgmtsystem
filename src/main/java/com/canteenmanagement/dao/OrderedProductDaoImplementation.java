package com.canteenmanagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.canteenmanagement.pojos.Category;
import com.canteenmanagement.pojos.OrderedProduct;

@Repository
public class OrderedProductDaoImplementation extends CanteenDaoImplementation<OrderedProduct> implements OrderedProductDao {

	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public Integer add(OrderedProduct product) {
		return (Integer) sessionFactory.getCurrentSession().save(product);
	}

	@Override
	public OrderedProduct update(OrderedProduct product) {
		sessionFactory.getCurrentSession().update(product);
		return product;
	}

	@Override
	public OrderedProduct delete(OrderedProduct product) {
		sessionFactory.getCurrentSession().delete(product);
		return product;
	}

	@Override
	public OrderedProduct delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		OrderedProduct product = session.get(OrderedProduct.class, id);
		session.delete(product);	
		return product;
	}
	
	@Override
	public List<OrderedProduct> get() {
		String jpql = "SELECT p from OrderedProduct p";
		Session session = sessionFactory.getCurrentSession();
		List<OrderedProduct> list = session.createQuery(jpql, OrderedProduct.class).getResultList();
		return list;
	}

	@Override
	public OrderedProduct get(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		OrderedProduct product = session.get(OrderedProduct.class, id);
		return product;
	}
	
	@Override
	public List<OrderedProduct> get(Category category) {
		String jpql = "select p from OrderedProduct p where p.category=:category";
		return sessionFactory.getCurrentSession()
				.createQuery(jpql, OrderedProduct.class)
				.setParameter("category", category.getName())
				.getResultList();
	}

	@Override
	public List<OrderedProduct> get(String category) {
		String jpql = "select p from OrderedProduct p where p.category=:category";
		return sessionFactory.getCurrentSession()
				.createQuery(jpql, OrderedProduct.class)
				.setParameter("category", category)
				.getResultList();
	}
	
}
