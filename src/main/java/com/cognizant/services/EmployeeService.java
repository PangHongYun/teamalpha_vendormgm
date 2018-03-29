package com.cognizant.services;

import java.util.List;

import com.cognizant.common.CompanyMgmtException;
import com.cognizant.domain.Account;
import com.cognizant.domain.Employee;


public interface EmployeeService extends BaseService{

	public void saveOrUpdate(Employee employee) throws CompanyMgmtException;
	public Employee findByEmployeeIdNo(String employeeIdNo);
	public Employee getUniqueEmployee(String acc_email);
	public List<Employee> findByEmployeeDeptAndCompany(String old_name,
			String com_name);
}
