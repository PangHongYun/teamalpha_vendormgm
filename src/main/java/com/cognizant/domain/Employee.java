package com.cognizant.domain;

import javax.jdo.annotations.Unique;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	
	@NamedQuery(name="Employee.findByEmployeeIdNo", 
		query="SELECT e FROM Employee e WHERE e.employeeIdNo=:employeeIdNo")})
public class Employee extends Company {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7567100544790163140L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
 
	private int accountId;
	
	private int companyId;

	private String employeeDepartment;

	private String employeeEmail;
	
	@Unique
	private String employeeIdNo;
	
	private String employeeName;

	public int getAccountId() {
		return accountId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public String getEmployeeDepartment() {
		return employeeDepartment;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public String getEmployeeIdNo() {
		return employeeIdNo;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public void setEmployeeIdNo(String employeeIdNo) {
		this.employeeIdNo = employeeIdNo;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	

}
