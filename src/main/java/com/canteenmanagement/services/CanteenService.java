package com.canteenmanagement.services;

import com.canteenmanagement.pojos.Person;

public interface CanteenService {
	void add(Person person);
	void update(Person person);
	void delete(Person person);
	void delete(String id);
}
