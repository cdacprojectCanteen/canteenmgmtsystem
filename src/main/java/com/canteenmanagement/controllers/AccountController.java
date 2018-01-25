package com.canteenmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canteenmanagement.pojos.Account;
import com.canteenmanagement.pojos.Customer;
import com.canteenmanagement.pojos.Employee;
import com.canteenmanagement.services.AccountService;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/Account")
public class AccountController {
	@Autowired
	private AccountService loginService;
	
	@PostMapping("/Employee")
	public Employee employeeLogin(Account account) {
		Employee employee = loginService.employeeLogin(account.getUsername(), account.getPassword());
		if(employee != null)
			return employee;
		employee = new Employee();
		employee.setId(-1);
		return employee;
	}
	
	@PostMapping("/Customer")
	public Customer customerLogin(Account account) {
		System.out.println("Username: "+account.getUsername()+":::::::::::::Password: "+account.getPassword());
		Customer customer = loginService.customerLogin(account.getUsername(), account.getPassword());
		if(customer != null)
			return customer;
		customer = new Customer();
		customer.setId(-1);
		return customer;
	}
}
