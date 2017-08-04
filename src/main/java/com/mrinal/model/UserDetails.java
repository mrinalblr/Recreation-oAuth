package com.mrinal.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity(name="USER_DETAILS")
public class UserDetails {

	@Id
	@Column(name="USER_DETAILS_ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userDetailsId;
	
	@Column(name="USER_GENDER")
	private String gender;
	
	@Column(name="USER_DOB")
	private String dob;
	
	@Column(name="USER_MOBILE")
	private String mobileNumber;
	
	@Column(name="USER_ADDRESSLINE1")
	private String addressLine1;
	
	@Column(name="USER_ADDRESSLINE2")
	private String addressLine2;

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USER_ID",unique=true)
	private User user;

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}



	public UserDetails(int userDetailsId, String gender, String dob, String mobileNumber, String addressLine1,
			String addressLine2, User user) {
		super();
		this.userDetailsId = userDetailsId;
		this.gender = gender;
		this.dob = dob;
		this.mobileNumber = mobileNumber;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.user = user;
	}



	public int getUserDetailsId() {
		return userDetailsId;
	}

	public void setUserDetailsId(int userDetailsId) {
		this.userDetailsId = userDetailsId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	public UserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

}
