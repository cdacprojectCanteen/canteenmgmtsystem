package com.canteenmanagement.services;

import com.canteenmanagement.pojos.Order;

public interface OrderService extends CanteenService<Order> {
	double getBill(Order order);
}
