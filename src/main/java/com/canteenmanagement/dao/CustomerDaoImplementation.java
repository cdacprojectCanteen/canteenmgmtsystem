package com.canteenmanagement.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.canteenmanagement.pojos.Customer;
import com.canteenmanagement.pojos.Order;

@Repository
public class CustomerDaoImplementation extends CanteenDaoImplementation<Customer> implements CustomerDao {

	@Autowired
	protected SessionFactory sessionFactory;
	
	@Override
	public Integer add(Customer customer) {
		return (Integer) sessionFactory.getCurrentSession().save(customer);
	}

	@Override
	public Customer update(Customer customer) {
		sessionFactory.getCurrentSession().update(customer);
		return customer;
	}

	@Override
	public Customer delete(Customer customer) {
		sessionFactory.getCurrentSession().delete(customer);
		return customer;
	}

	@Override
	public Customer delete(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id); //TODO VERIFY
		session.delete(customer);	
		return customer;
	}
	
	@Override
	public List<Customer> get() {
		String jpql = "SELECT c from Customer c";
		Session session = sessionFactory.getCurrentSession();
		List<Customer> customers = session.createQuery(jpql, Customer.class).getResultList();
		sessionFactory.getCurrentSession().clear();
		for(Customer customer: customers)
			customer.setPassHash(""); //TODO Check Side Effect
		return customers;
	}

	@Override
	public Customer get(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		sessionFactory.getCurrentSession().clear();
		customer.setPassHash(""); //TODO Check Side Effect
		return customer;
	}
	
	
	@Override
	public List<Order> getOrders(Customer customer) {
		String jpql = "SELECT o from Orders o where o.customer.id=:id";
		Session session = sessionFactory.getCurrentSession();
		List<Order> orders = session.createQuery(jpql, Order.class).setParameter(":id", customer.getId()).getResultList();
//		customer = sessionFactory.getCurrentSession().get(Customer.class, customer.getId());
		return orders;
	}

	@Override
	public List<Order> getOrders(Integer customerId) {
		String jpql = "SELECT o from Orders o where o.customer.id=:id";
		Session session = sessionFactory.getCurrentSession();
		List<Order> orders = session.createQuery(jpql, Order.class).setParameter(":id", customerId).getResultList();
//		customer = sessionFactory.getCurrentSession().get(Customer.class, customer.getId());
		return orders;
	}

	@Override
	public boolean isUniqueEmail(String email) {
		String jpql= "SELECT c.email from Customer c where c.email=:email";
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
		String jpql= "SELECT c.phoneNo from Customer c where c.phoneNo=:phoneNo";
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
