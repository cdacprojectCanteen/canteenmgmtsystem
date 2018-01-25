package com.canteenmanagement.pojos;

import javax.persistence.Entity;

//@Entity	//TODO FUTURE IMPLEMENTATION
public class CustomerAccount {
	private Customer customer;
	private String passHash;
	
	public CustomerAccount() {
		// TODO Auto-generated constructor stub
	}

	public CustomerAccount(Customer customer, String passHash) {
		super();
		this.customer = customer;
		this.passHash = passHash;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getPassHash() {
		return passHash;
	}

	public void setPassHash(String passHash) {
		this.passHash = passHash;
	}
	
	
}
