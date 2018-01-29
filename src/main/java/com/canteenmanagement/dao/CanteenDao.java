package com.canteenmanagement.dao;

import java.util.List;

import com.canteenmanagement.pojos.Product;

public interface CanteenDao<T> {
	Integer add(T t);
	T update(T t);
	T delete(T t);
	T delete(Integer id);
	List<T> get();
	T get(Integer id);
}
