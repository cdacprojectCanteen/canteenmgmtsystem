package com.canteenmanagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.canteenmanagement.pojos.Product;

public abstract class Canteen<T> implements CanteenDao<T> {
	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public void add(T t) {
		sessionFactory.getCurrentSession().save(t);
	}

	@Override
	public void update(T t) {
		sessionFactory.getCurrentSession().update(t);
	}

	@Override
	public void delete(T t) {
		sessionFactory.getCurrentSession().delete(t);
	}

	@Override
	public void delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		T t = (T) session.get(this.getClass(), id); //TODO VERIFY
		System.out.println("this.getClass() gives: "+this.getClass());
		session.delete(t);		
	}
	
	@Override
	public List<T> get() {
		String jpql = "SELECT t from T";
		Session session = sessionFactory.getCurrentSession();
		List<T> list = (List<T>) session.createQuery(jpql, this.getClass()).getResultList();
		return list;
	}

	@Override
	public T get(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		T t = (T) session.get(this.getClass(), id); //TODO VERIFY
		System.out.println("this.getClass() gives: "+this.getClass());
		return t;
	}
	
}
