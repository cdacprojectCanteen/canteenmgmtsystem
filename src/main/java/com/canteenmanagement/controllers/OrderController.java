package com.canteenmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@PostMapping
	public Integer addOrder(@RequestBody Order order) {
		return orderService.add(order);
	}
	
	@PutMapping("/{orderId}")
	public Order updateOrder(@PathVariable Integer orderId, @RequestBody Order order) {
		return orderService.update(order);
	}
	
	@DeleteMapping("/{orderId}")
	public Order deleteOrder(@PathVariable Integer orderId) {
		return orderService.delete(orderId);
	}
}
