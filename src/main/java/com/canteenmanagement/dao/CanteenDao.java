package com.canteenmanagement.dao;

import java.util.List;

public interface CanteenDao<T> {
	void add(T t);
	void update(T t);
	void delete(T t);
	void delete(Integer id);
	List<T> get();
	T get(Integer id);
}
