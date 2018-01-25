package com.canteenmanagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.canteenmanagement.pojos.Category;

@Repository
public class CategoryDaoImplementation implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Integer add(Category category) {
		return (Integer) sessionFactory.getCurrentSession().save(category);
	}

	@Override
	public Category update(Category category) {
		sessionFactory.getCurrentSession().update(category);
		return category;
	}

	@Override
	public Category delete(Category category) {
		sessionFactory.getCurrentSession().delete(category);
		return category;
	}

	@Override
	public Category delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Category category = session.get(Category.class, id);
		session.delete(category);	
		return category;
	}

	@Override
	public List<Category> get() {
		String jpql = "SELECT c from Category c";
		Session session = sessionFactory.getCurrentSession();
		List<Category> list = session.createQuery(jpql, Category.class).getResultList();
		return list;
	}

	@Override
	public Category get(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Category category = session.get(Category.class, id);
		return category;
	}

}
