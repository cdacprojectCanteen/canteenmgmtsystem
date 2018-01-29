package com.canteenmanagement.dao;

import com.canteenmanagement.pojos.Order;

public interface OrderDao extends CanteenDao<Order> {
	Order getOrderByCoupon(String couponCode);
}
