package com.cognizant.services;

import com.cognizant.common.CompanyMgmtException;
import com.cognizant.domain.Account;
import com.cognizant.domain.Employee;


public interface EmployeeService extends BaseService{

	public void saveOrUpdate(Employee employee) throws CompanyMgmtException;
	public Employee findByEmployeeIdNo(String employeeIdNo);
	public Employee getUniqueEmployee(String acc_email);
}
