package com.canteenmanagement.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.canteenmanagement.pojos.Employee;

@Repository
public class EmployeeDaoImplementation extends CanteenDaoImplementation<Employee> implements EmployeeDao {
	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public Integer add(Employee employee) {
		return (Integer) sessionFactory.getCurrentSession().save(employee);
	}

	@Override
	public Employee update(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
		return employee;
	}

	@Override
	public Employee delete(Employee employee) {
		sessionFactory.getCurrentSession().delete(employee);
		return employee;
	}

	@Override
	public Employee delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Employee employee = session.get(Employee.class, id);
		session.delete(employee);	
		return employee;
	}
	
	@Override
	public List<Employee> get() {
		String jpql = "SELECT e from Employee e";
		Session session = sessionFactory.getCurrentSession();
		List<Employee> employees = session.createQuery(jpql, Employee.class).getResultList();
		sessionFactory.getCurrentSession().clear();
		for(Employee e: employees)
			e.setPassHash(""); //TODO Check Side Effect
		return employees;
	}

	@Override
	public Employee get(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Employee employee = session.get(Employee.class, id);
		sessionFactory.getCurrentSession().clear();
		employee.setPassHash(""); //TODO Check Side Effect
		return employee;
	}
	
	@Override
	public boolean isUniqueEmail(String email) {
		String jpql= "SELECT e.email from Employee e where e.email=:email";
		try {
//			String eMail = sessionFactory.getCurrentSession().createQuery(jpql, String.class).setParameter("email", email).getSingleResult();
			sessionFactory.getCurrentSession()
					.createQuery(jpql, String.class)
					.setParameter("email", email)
					.getSingleResult();
			return false;
		}
		catch(NoResultException e) {
			return true;
		}
	}

	@Override
	public boolean isUniquePhoneNo(String phoneNo) {
		String jpql= "SELECT e.phoneNo from Employee e where e.phoneNo=:phoneNo";
		try {
//			String phNo = sessionFactory.getCurrentSession().createQuery(jpql, String.class).setParameter("phoneNo", phoneNo).getSingleResult();
			sessionFactory.getCurrentSession()
					.createQuery(jpql, String.class)
					.setParameter("phoneNo", phoneNo)
					.getSingleResult();
			return false;
		}
		catch(NoResultException e) {
			return true;
		}
	}
}
