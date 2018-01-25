package com.canteenmanagement.dao;

import javax.persistence.NoResultException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.canteenmanagement.pojos.Customer;
import com.canteenmanagement.pojos.Employee;

@Repository
public class AccountDaoImplementation implements AccountDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Customer customerLogin(String username, String passHash) {
		String jpql = "select c from Customer c where (c.id=:unameInt or c.email=:uname or c.phoneNo=:uname) and c.passHash=:passHash";
		Customer customer;
		Integer id = -1;
		try {
			try {
				id = Integer.parseInt(username);
			}
			catch(NumberFormatException e) {
				
			}
			System.out.println(username+" IS THE USERNAME_________________________________________________________________");
			customer = sessionFactory.getCurrentSession()
					.createQuery(jpql, Customer.class)
					.setParameter("unameInt", id)
					.setParameter("uname", username)
					.setParameter("passHash", passHash)
					.getSingleResult();
			sessionFactory.getCurrentSession().clear();
			customer.setPassHash("");
		}
		catch(NoResultException e) {
			customer = null;
		}
		return customer;
	}

	@Override
	public Employee employeeLogin(String username, String passHash) {
		String jpql = "select e from Employee e where (e.id=:unameInt or e.email=:uname or e.phoneNo=:uname) and e.passHash=:passHash";
		Employee employee;
		Integer id = -1;
		try {
			try {
				id = Integer.parseInt(username);
			}
			catch(NumberFormatException e) {
				
			}
			
			employee = sessionFactory.getCurrentSession()
					.createQuery(jpql, Employee.class)
					.setParameter("unameInt", id)
					.setParameter("uname", username)
					.setParameter("passHash", passHash)
					.getSingleResult();
			sessionFactory.getCurrentSession().clear();
			employee.setPassHash("");
		}
		catch(NoResultException e) {
			employee = null;
		}
		return employee;
	}
	
	

}
