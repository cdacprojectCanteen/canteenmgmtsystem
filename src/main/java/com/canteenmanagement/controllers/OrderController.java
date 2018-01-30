package com.canteenmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canteenmanagement.pojos.Order;
import com.canteenmanagement.services.OrderService;
import com.canteenmanagement.utils.OrderStatus;
import com.canteenmanagement.utils.TokenGenerator;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/Order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/")
	public List<Order> getOrders(){
		return orderService.get();
	}
	
	@GetMapping("/{orderId}")
	public Order getOrder(@PathVariable Integer orderId) {
		return orderService.get(orderId);
	}
	
	@PostMapping(path="/",produces="text/plain")
	public String addOrder(@RequestBody Order order) {
		order.setOrderStatus(OrderStatus.NEW);
		String couponCode;
		while(true) {
			TokenGenerator couponGenerator = new TokenGenerator(6);
			couponCode = couponGenerator.generateToken();
			Order o = orderService.getOrderByCoupon(couponCode);
			if(o==null)
				break;
		}
		order.setCouponCode(couponCode);
		orderService.add(order);
		return couponCode;
	}
	
	@PutMapping("/")
	public Order updateOrder(@RequestBody Order order) {
		return orderService.update(order);
	}
	
	@DeleteMapping("/{orderId}")
	public Order deleteOrder(@PathVariable Integer orderId) {
		return orderService.delete(orderId);
	}
	
	@GetMapping("/GetOrderByCoupon/{coupon}")
	public Order getOrderByCoupon(@PathVariable String coupon) {
		Order order = orderService.getOrderByCoupon(coupon);
		if(order!=null)
			return order;
		order = new Order();
		order.setOrderId(-1);
		return order;
	}
}
