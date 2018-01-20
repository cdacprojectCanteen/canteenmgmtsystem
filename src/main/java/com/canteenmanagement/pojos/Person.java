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
	
	private String firstName;
	private String lastName; //OPTIONAL
	private String passHash; //TODO integrate with BCrypt
	private Address address; //OPTIONAL
	private PhoneNo phoneNo;
	private Email emailId;	//REQUIRED
	private LocalDate dateOfBirth;
	private LocalDate dateOfJoining; //AUTOMATIC
	private LanguageEnum preferredLanguage; //FUTURE IMPLEMENTATION
	
	
	public Person() {
		super();
	}

	
	
	public Person(Integer id, String firstName, String lastName, String passHash, Address address, PhoneNo phoneNo,
			Email emailId, LocalDate dateOfBirth, LocalDate dateOfJoining, LanguageEnum preferredLanguage) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.passHash = passHash;
		this.address = address;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.dateOfJoining = dateOfJoining;
		this.preferredLanguage = preferredLanguage;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="first_name")
	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	@Column(name="last_name")
	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@Column(name="pass_hash")
	public String getPassHash() {
		return passHash;
	}



	public void setPassHash(String passHash) {
		this.passHash = passHash;
	}



	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}

	@Column(name="phone_no")
	public PhoneNo getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(PhoneNo phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Column(name="email_id")
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

	@Column(name="preferred_language")
	public LanguageEnum getPreferredLanguage() {
		return preferredLanguage;
	}


	public void setPreferredLanguage(LanguageEnum preferredLanguage) {
		this.preferredLanguage = preferredLanguage;
	}



	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", passHash=" + passHash
				+ ", address=" + address + ", phoneNo=" + phoneNo + ", emailId=" + emailId + ", dateOfBirth="
				+ dateOfBirth + ", dateOfJoining=" + dateOfJoining + ", preferredLanguage=" + preferredLanguage + "]";
	}


	
}
