package com.canteenmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canteenmanagement.dao.CustomerDao;
import com.canteenmanagement.pojos.Customer;
import com.canteenmanagement.pojos.Order;

@Service
@Transactional
public class CustomerServiceImplementation implements CustomerService {

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

	@Override
	public List<Order> getOrders(Customer customer) {
		return customerDao.getOrders(customer);
	}

	@Override
	public List<Order> getOrders(Integer customerId) {
		return customerDao.getOrders(customerId);
	}

	@Override
	public boolean isUniqueEmail(String email) {
		return customerDao.isUniqueEmail(email);
	}

	@Override
	public boolean isUniquePhoneNo(String phoneNo) {
		return customerDao.isUniquePhoneNo(phoneNo);
	}
}
