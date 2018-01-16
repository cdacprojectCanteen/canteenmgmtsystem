package com.canteenmanagement.dao;

public interface CanteenDao<T> {
	void add(T t);
	void update(T t);
	void delete(T t);
	void delete(Integer id);
}
