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

import com.canteenmanagement.pojos.Employee;
import com.canteenmanagement.services.EmployeeService;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public List<Employee> getEmployees(){
		return employeeService.get();
	}
	
	@GetMapping("/{empId}")
	public Employee getEmployee(@PathVariable Integer empId) {
		return employeeService.get(empId);
	}
	
	@PostMapping
	public Integer addEmployee(@RequestBody Employee employee) {
		return employeeService.add(employee);
	}
	
	@PutMapping("/{empId}")
	public Employee updateEmployee(@PathVariable Integer empId, @RequestBody Employee employee) {
		return employeeService.update(employee);
	}
	
	@DeleteMapping("/{empId}")
	public Employee deleteEmployee(@PathVariable Integer empId) {
		return employeeService.delete(empId);
	}
}
