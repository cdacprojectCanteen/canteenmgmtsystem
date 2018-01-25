package com.canteenmanagement.services;

import com.canteenmanagement.pojos.Customer;
import com.canteenmanagement.pojos.Employee;

public interface AccountService {
	Customer customerLogin(String username, String passHash);
	Employee employeeLogin(String username, String passHash);
}
