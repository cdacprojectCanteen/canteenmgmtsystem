package com.canteenmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canteenmanagement.pojos.Customer;
import com.canteenmanagement.pojos.Employee;
import com.canteenmanagement.services.LoginService;

@RestController
@RequestMapping("/Login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@PostMapping("/Employee")
	public Employee employeeLogin(@RequestBody String username, @RequestBody String password) {
		return loginService.employeeLogin(username, password);
	}
	
	@PostMapping("/Customer")
	public Customer customerLogin(@RequestBody String username, @RequestBody String password) {
		return loginService.customerLogin(username, password);
	}
}
