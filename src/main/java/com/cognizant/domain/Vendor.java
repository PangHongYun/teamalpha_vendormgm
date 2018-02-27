package com.cognizant.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "Vendor.getUniqueVendor", query = "SELECT v FROM Vendor v WHERE v.vendorEmail=:vendorEmail"),
	@NamedQuery(name = "Vendor.getAllApplications", query="SELECT v FROM VendorApp v WHERE v.vendorId=:vendorId")
})
public class Vendor extends Base{
	
	
	private String vendorName;
	private String vendorAddress;
	private String vendorRegistrationNumber;
	private String vendorEmail;
	private int vendorContactNumber;
	
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

}
