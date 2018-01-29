package com.canteenmanagement.services;

import com.canteenmanagement.pojos.Employee;

public interface EmployeeService extends CanteenService<Employee> {
	boolean isUniqueEmail(String email);
	boolean isUniquePhoneNo(String phoneNo);
}
