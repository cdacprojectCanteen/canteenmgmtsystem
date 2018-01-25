package com.canteenmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canteenmanagement.dao.CategoryDao;
import com.canteenmanagement.pojos.Category;

@Service
@Transactional
public class CategoryServiceImplementation implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public Integer add(Category category) {
		return categoryDao.add(category);
	}

	@Override
	public Category update(Category category) {
		categoryDao.update(category);
		return category;
	}

	@Override
	public Category delete(Category category) {
		return categoryDao.delete(category);
	}

	@Override
	public Category delete(Integer id) {
		return categoryDao.delete(id);
	}

	@Override
	public Category get(Integer id) {
		return categoryDao.get(id);
	}

	@Override
	public List<Category> get() {
		return categoryDao.get();
	}



}
