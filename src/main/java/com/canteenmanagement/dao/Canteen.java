package com.canteenmanagement.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.canteenmanagement.pojos.Product;

public abstract class Canteen<T> {
	@Autowired
	private SessionFactory sessionFactory;

	public void add(T t) {
		sessionFactory.getCurrentSession().save(t);
	}

	public void update(T t) {
		sessionFactory.getCurrentSession().update(t);
	}

	public void delete(T t) {
		sessionFactory.getCurrentSession().delete(t);
	}

	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		T t = (T) session.get(this.getClass(), id); //TODO VERIFY
		System.out.println("this.getClass() gives: "+this.getClass());
		session.delete(t);		
	}
}
