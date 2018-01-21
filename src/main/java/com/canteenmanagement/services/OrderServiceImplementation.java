package com.canteenmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.canteenmanagement.dao.OrderDao;
import com.canteenmanagement.pojos.Order;

public class OrderServiceImplementation implements CanteenService<Order> {

	@Autowired
	private OrderDao orderDao;
	
	@Override
	public Integer add(Order order) {
		return orderDao.add(order);
	}

	@Override
	public Order update(Order order) {
		orderDao.update(order);
		return order;
	}

	@Override
	public Order delete(Order order) {
		return orderDao.delete(order);
	}

	@Override
	public Order delete(Integer id) {
		return orderDao.delete(id);
	}

	@Override
	public Order get(Integer id) {
		return orderDao.get(id);
	}

	@Override
	public List<Order> get() {
		return orderDao.get();
	}

}
