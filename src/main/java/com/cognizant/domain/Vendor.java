package com.cognizant.domain;

import javax.persistence.Entity;

@Entity
public class Vendor extends Base{
	
	
	private String vendorName;
	private String vendorAddress;
	private String vendorRegistrationNumber;
	private String vendorEmail;
	private int vendorContactNumber;
	private String passWord;
	private String userName;
	
	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public String getVendorRegistrationNumber() {
		return vendorRegistrationNumber;
	}

	public void setVendorRegistrationNumber(String vendorRegistrationNumber) {
		this.vendorRegistrationNumber = vendorRegistrationNumber;
	}

	public String getVendorEmail() {
		return vendorEmail;
	}

	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}

	public int getVendorContactNumber() {
		return vendorContactNumber;
	}

	public void setVendorContactNumber(int vendorContactNumber) {
		this.vendorContactNumber = vendorContactNumber;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
