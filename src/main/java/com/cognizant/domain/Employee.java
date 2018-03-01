package com.cognizant.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	@NamedQuery(name ="Employee.getUniqueEmployee", query="SELECT e FROM Employee e WHERE e.employeeEmail=:empEmail"),
	@NamedQuery(name ="Employee.findByEmployeeIdNo", query="SELECT e FROM Employee e WHERE e.id=:employeeIdNo")
	})
public class Employee extends Base {

	private static final long serialVersionUID = 7567100544790163140L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
		
	private String company_name;

	private String employeeDepartment;

	private String employeeEmail;
		
	private String employeeName;	
	
	private int employeeContactNumber;

	public String getEmployeeDepartment() {
		return employeeDepartment;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public int getEmployeeContactNumber() {
		return employeeContactNumber;
	}

	public void setEmployeeContactNumber(int employeeContactNumber) {
		this.employeeContactNumber = employeeContactNumber;
	}
	
	

}

