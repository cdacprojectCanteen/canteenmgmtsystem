package com.canteenmanagement.dao;

import com.canteenmanagement.pojos.Customer;
import com.canteenmanagement.pojos.Employee;

public interface LoginDao {
	Customer customerLogin(String username, String passHash);
	Employee employeeLogin(String username, String passHash);
}
