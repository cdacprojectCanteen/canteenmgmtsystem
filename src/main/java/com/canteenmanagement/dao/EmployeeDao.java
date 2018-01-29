package com.canteenmanagement.dao;

import com.canteenmanagement.pojos.Employee;

public interface EmployeeDao extends CanteenDao<Employee> {
	boolean isUniqueEmail(String email);
	boolean isUniquePhoneNo(String phoneNo);
}
