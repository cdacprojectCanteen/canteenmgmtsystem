package com.canteenmanagement.services;

import java.util.List;

public interface CanteenService<T> {
	void add(T t);
	void update(T t);
	void delete(T t);
	void delete(Integer id);
	T get(Integer id);
	List<T> getAll();
}
