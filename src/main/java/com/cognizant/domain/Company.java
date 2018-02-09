package com.cognizant.domain;

import javax.jdo.annotations.Unique;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "Company.getUniqueCompany", 
		query = "SELECT c FROM Company c WHERE c.companyName=:companyName AND c.companyRegistrationNumber=:companyRegistrationNumber"),
	@NamedQuery(name="Company.findByRegistrationNumber", 
		query="SELECT c FROM Company c WHERE c.companyRegistrationNumber=:companyRegistrationNumber")})
public class Company extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1513358315407795427L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	private String companyAddress;
	
	private int companyContactNumber;
	
	private String companyEmail;
	
	private String companyName;
	
	@Unique
	private String companyRegistrationNumber;

	private String notificationType;

	public String getCompanyAddress() {
		return companyAddress;
	}
	public int getCompanyContactNumber() {
		return companyContactNumber;
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


	public String getNotificationType() {
		return notificationType;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public void setCompanyContactNumber(int companyContactNumber) {
		this.companyContactNumber = companyContactNumber;
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
	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}
	@Override
	public String toString() {
		return "Company [companyAddress=" + companyAddress
				+ ", companyContactNumber=" + companyContactNumber
				+ ", companyEmail=" + companyEmail + ", companyName="
				+ companyName + ", companyRegistrationNumber="
				+ companyRegistrationNumber + ", notificationType="
				+ notificationType + "]";
	}




	

}
