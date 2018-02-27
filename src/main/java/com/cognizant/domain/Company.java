package com.cognizant.domain;

import javax.jdo.annotations.Unique;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "Company.getUniqueCompany", 
			query = "SELECT c FROM Company c WHERE c.companyName=:companyName AND c.companyRegistrationNumber=:companyRegistrationNumber"),
	@NamedQuery(name = "Company.getUniqueCompanyByName", 
			query = "SELECT c FROM Company c WHERE c.companyName=:companyName"),
	@NamedQuery(name="Company.findByRegistrationNumber", 
		query="SELECT c FROM Company c WHERE c.companyRegistrationNumber=:companyRegistrationNumber")})
public class Company extends Base {

	private String companyAddress;
	private String companyEmail;
	private int companyContactNumber;
	private String companyName;
	
	@Unique
	private String companyRegistrationNumber;
	private String passWord;
	private String userName;
	
	public String getCompanyAddress() {
		return companyAddress;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getCompanyRegistrationNumber() {
		return companyRegistrationNumber;
	}

	public String getPassWord() {
		return passWord;
	}

	public String getUserName() {
		return userName;
	}

	
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setCompanyRegistrationNumber(String companyRegistrationNumber) {
		this.companyRegistrationNumber = companyRegistrationNumber;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Company [companyName=" + companyName + ", companyAddress="
				+ companyAddress + ", companyRegistrationNumber="
				+ companyRegistrationNumber + ", companyEmail=" + companyEmail
				+ ", userName=" + userName + ", passWord=" + passWord + "]";
	}

	

}
