package com.canteenmanagement.dao;

import java.util.List;

import com.canteenmanagement.pojos.Customer;
import com.canteenmanagement.pojos.Order;

public interface CustomerDao extends CanteenDao<Customer> {
	List<Order> getOrders(Customer customer);
	List<Order> getOrders(Integer customerId);
	boolean isUniqueEmail(String email);
	boolean isUniquePhoneNo(String phoneNo);
}
