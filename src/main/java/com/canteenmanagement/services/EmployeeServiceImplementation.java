package com.canteenmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canteenmanagement.dao.EmployeeDao;
import com.canteenmanagement.pojos.Employee;

@Service
@Transactional
public class EmployeeServiceImplementation implements CanteenService<Employee> {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public Integer add(Employee employee) {
		return employeeDao.add(employee);
	}

	@Override
	public Employee update(Employee employee) {
		employeeDao.update(employee);
		return employee;
	}

	@Override
	public Employee delete(Employee employee) {
		return employeeDao.delete(employee);
	}

	@Override
	public Employee delete(Integer id) {
		return employeeDao.delete(id);
	}

	@Override
	public Employee get(Integer id) {
		return employeeDao.get(id);
	}

	@Override
	public List<Employee> get() {
		return employeeDao.get();
	}

}
