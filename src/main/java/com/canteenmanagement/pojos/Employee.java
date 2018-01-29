package com.canteenmanagement.pojos;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee extends Person {
//	private double salary;
//	private Department department;

	public Employee() {
		super();
	}
	

//	public double getSalary() {
//		return salary;
//	}
//
//	public void setSalary(double salary) {
//		this.salary = salary;
//	}

	
//	@ManyToOne(fetch=FetchType.EAGER)
//	@JoinColumn(name="department_id")
//	public Department getDepartment() {
//		return department;
//	}
//
//
//
//	public void setDepartment(Department department) {
//		this.department = department;
//	}

}
