package com.canteenmanagement.dao;

import javax.persistence.NoResultException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.canteenmanagement.pojos.Customer;
import com.canteenmanagement.pojos.Employee;

@Repository
public class LoginDaoImplementation implements LoginDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Customer customerLogin(String username, String passHash) {
		String jpql = "select c from Customer where (c.id=:uname or c.emailId=:uname or c.phoneNo) and c.passHash=:passHash";
		Customer customer;
		try {
			customer = sessionFactory.getCurrentSession()
					.createQuery(jpql, Customer.class)
					.setParameter("uname", username)
					.setParameter("passHash", passHash)
					.getSingleResult();
		}
		catch(NoResultException e) {
			customer = null;
		}
		return customer;
	}

	@Override
	public Employee employeeLogin(String username, String passHash) {
		String jpql = "select e from Employee where (e.id=:uname or e.emailId=:uname or e.phoneNo) and e.passHash=:passHash";
		Employee employee;
		try {
			employee = sessionFactory.getCurrentSession()
					.createQuery(jpql, Employee.class)
					.setParameter("uname", username)
					.setParameter("passHash", passHash)
					.getSingleResult();
		}
		catch(NoResultException e) {
			employee = null;
		}
		return employee;
	}
	
	

}
