package com.canteenmanagement.services;

import java.util.List;

import com.canteenmanagement.pojos.Customer;
import com.canteenmanagement.pojos.Order;

public interface CustomerService extends CanteenService<Customer> {
	List<Order> getAllOrders(Customer customer);
	List<Order> getAllOrders(Integer customerId);
}
