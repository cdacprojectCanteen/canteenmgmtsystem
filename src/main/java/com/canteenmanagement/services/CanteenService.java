package com.canteenmanagement.services;

import java.util.List;

public interface CanteenService<T> {
	Integer add(T t);
	T update(T t);
	T delete(T t);
	T delete(Integer id);
	T get(Integer id);
	List<T> get();
}
