package com.canteenmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.canteenmanagement.dao.CustomerDao;
import com.canteenmanagement.pojos.Customer;

public class CustomerServiceImplementation implements CanteenService<Customer> {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public Integer add(Customer customer) {
		return customerDao.add(customer);
	}

	@Override
	public Customer update(Customer customer) {
		customerDao.update(customer);
		return customer;
	}

	@Override
	public Customer delete(Customer customer) {
		return customerDao.delete(customer);
	}

	@Override
	public Customer delete(Integer id) {
		return customerDao.delete(id);
	}

	@Override
	public Customer get(Integer id) {
		return customerDao.get(id);
	}

	@Override
	public List<Customer> get() {
		return customerDao.get();
	}

}
