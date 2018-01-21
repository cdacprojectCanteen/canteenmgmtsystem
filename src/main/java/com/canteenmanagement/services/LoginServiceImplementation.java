package com.canteenmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canteenmanagement.dao.LoginDao;
import com.canteenmanagement.pojos.Customer;
import com.canteenmanagement.pojos.Employee;

@Service
@Transactional
public class LoginServiceImplementation implements LoginService {

	@Autowired
	private LoginDao loginDao;
	
	@Override
	public Customer customerLogin(String username, String passHash) {
		return loginDao.customerLogin(username, passHash);
	}

	@Override
	public Employee employeeLogin(String username, String passHash) {
		return loginDao.employeeLogin(username, passHash);
	}

}
