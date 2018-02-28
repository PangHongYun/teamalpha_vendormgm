package com.cognizant.services;

import com.cognizant.domain.Employee;


public interface EmployeeService extends BaseService{

	
	 public Employee findByEmployeeIdNo(String employeeIdNo);

	public void createEmployee(Employee employee);

	public Employee getUniqueEmployee(String acc_email);
}
