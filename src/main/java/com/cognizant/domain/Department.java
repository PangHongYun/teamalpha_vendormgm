package com.cognizant.domain;

import javax.persistence.Entity;

@Entity
public class Department extends Company {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4884481087586936973L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	private String departmentName;
	
	
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	
	
	
}
