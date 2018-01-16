package com.canteenmanagement.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.canteenmanagement.utils.LanguageEnum;

@Inheritance(strategy=InheritanceType.JOINED)
@Entity
public abstract class Person {
	private Integer id;
	
	private String name;
	private Address address;
	private PhoneNo phoneNo;
	private Email emailId;
	private LocalDate dateOfBirth;
	private LocalDate dateOfJoining;
	private LanguageEnum preferredLanguage;
	
	
	public Person() {
		super();
	}


	public Person(String name, Address address, PhoneNo phoneNo, Email emailId, LocalDate dateOfBirth,
			LocalDate dateOfJoining, LanguageEnum preferredLanguage) {
		super();
		this.name = name;
		this.address = address;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.dateOfJoining = dateOfJoining;
		this.preferredLanguage = preferredLanguage;
	}


//	public abstract Integer getId();
//	
//	public abstract void setId(Integer id);
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public PhoneNo getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(PhoneNo phoneNo) {
		this.phoneNo = phoneNo;
	}


	public Email getEmailId() {
		return emailId;
	}


	public void setEmailId(Email emailId) {
		this.emailId = emailId;
	}


	@Column(name="date_of_birth")
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name="date_of_joining")
	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}


	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	
	public LanguageEnum getPreferredLanguage() {
		return preferredLanguage;
	}


	public void setPreferredLanguage(LanguageEnum preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", address=" + address + ", phoneNo=" + phoneNo + ", emailId=" + emailId
				+ ", dateOfBirth=" + dateOfBirth + ", dateOfJoining=" + dateOfJoining + ", preferredLanguage="
				+ preferredLanguage + "]";
	}
	
	
}
