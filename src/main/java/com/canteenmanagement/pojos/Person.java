package com.canteenmanagement.pojos;

import java.time.LocalDate;

public abstract class Person {
	private String name;
	private Address address;
	private PhoneNo phoneNo;
	private Email emailId;
	private LocalDate dateOfBirth;
	private LocalDate dateOfJoining;
	private LanguageEnum preferredLanguage;
	
	public abstract String getId();
}
