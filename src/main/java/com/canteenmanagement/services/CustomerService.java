package com.canteenmanagement.services;

import java.util.List;

import com.canteenmanagement.pojos.Customer;
import com.canteenmanagement.pojos.Order;

public interface CustomerService extends CanteenService<Customer> {
	List<Order> getOrders(Customer customer);
	List<Order> getOrders(Integer customerId);
	boolean isUniqueEmail(String email);
	boolean isUniquePhoneNo(String phoneNo);
}
