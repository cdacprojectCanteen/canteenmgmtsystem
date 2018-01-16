package com.canteenmanagement.pojos;

import javax.persistence.Embeddable;

import com.canteenmanagement.exceptions.InvalidEmailException;
import com.canteenmanagement.utils.Validator;

@Embeddable
public class Email {
	String email;
	
	public Email() {
		
	}
	
	private Email(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



//	public Email newEmail(String email) throws InvalidEmailException {
//		if(Validator.validateEmail(email))
//			return new Email(email);
//		throw new InvalidEmailException(email+" is not a valid E-mail id");
//	}

	@Override
	public String toString() {
		return email;
	}
}
