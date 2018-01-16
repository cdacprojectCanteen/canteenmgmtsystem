package com.canteenmanagement.pojos;

import javax.persistence.Embeddable;

@Embeddable
public class PhoneNo {
	private String phoneNo;

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
}
