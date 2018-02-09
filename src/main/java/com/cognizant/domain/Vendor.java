package com.cognizant.domain;

import javax.jdo.annotations.Unique;
import javax.persistence.Entity;

@Entity
public class Vendor extends Base{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -75448013102150616L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Unique
	private String passWord;
	
	private String userName;
	
	private String vendorAddress;
	
	private int vendorContactNumber;
	
	private String vendorEmail;
	
	private String vendorName;
	
	private String vendorRegistrationNumber;
	
	public String getPassWord() {
		return passWord;
	}

	public String getUserName() {
		return userName;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public int getVendorContactNumber() {
		return vendorContactNumber;
	}

	public String getVendorEmail() {
		return vendorEmail;
	}

	public String getVendorName() {
		return vendorName;
	}

	public String getVendorRegistrationNumber() {
		return vendorRegistrationNumber;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public void setVendorContactNumber(int vendorContactNumber) {
		this.vendorContactNumber = vendorContactNumber;
	}

	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public void setVendorRegistrationNumber(String vendorRegistrationNumber) {
		this.vendorRegistrationNumber = vendorRegistrationNumber;
	}

	@Override
	public String toString() {
		return "Vendor [vendorName=" + vendorName + ", vendorAddress="
				+ vendorAddress + ", vendorRegistrationNumber="
				+ vendorRegistrationNumber + ", vendorEmail=" + vendorEmail
				+ ", vendorContactNumber=" + vendorContactNumber
				+ ", passWord=" + passWord + ", userName=" + userName + "]";
	}



	

}
