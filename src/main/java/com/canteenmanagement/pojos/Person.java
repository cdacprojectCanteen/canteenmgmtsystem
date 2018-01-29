package com.canteenmanagement.pojos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.canteenmanagement.utils.Gender;

//@Inheritance(strategy=InheritanceType.JOINED)
//@Entity
@MappedSuperclass
public abstract class Person {
	private Integer id;
	
	private String firstName;
	private String lastName;
	private String passHash; //TODO integrate with BCrypt
	private Gender gender;
	private String phoneNo;
	private String email;

	private Date dateOfBirth;
	
	private Date dateOfJoining;
	
	
	public Person() {
		super();
	}

	
	
	public Person(Integer id, String firstName, String lastName, String passHash, Gender gender, String phoneNo,
			String email, Date dateOfBirth, Date dateOfJoining) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.passHash = passHash;
		this.gender = gender;
		this.phoneNo = phoneNo;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.dateOfJoining = dateOfJoining;
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

	@Enumerated(EnumType.STRING)
	public Gender getGender() {
		return gender;
	}


	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Column(name="phone_no", unique=true)
	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Column(unique=true)
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Column(name="date_of_birth")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name="date_of_joining")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateOfJoining() {
		return dateOfJoining;
	}


	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", passHash=" + passHash
				+ ", gender=" + gender + ", phoneNo=" + phoneNo + ", email=" + email + ", dateOfBirth=" + dateOfBirth
				+ ", dateOfJoining=" + dateOfJoining + "]";
	}
	
}
