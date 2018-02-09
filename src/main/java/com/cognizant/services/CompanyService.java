package com.cognizant.services;

import com.cognizant.common.CompanyMgmtException;
import com.cognizant.domain.Company;
import com.cognizant.domain.Employee;

public interface CompanyService extends BaseService{

	public Company getUniqueCompany(String companyName, String companyRegistrationNumber);
	
	 public void saveOrUpdate(Company company) throws CompanyMgmtException;

	 public Company findByRegistrationNumber(String companyRegistrationNumber);
	 
	 public void deleteByRegistrationNumber(String companyRegistrationNumber) throws CompanyMgmtException;
	 
	/* public void createEmployee(Employee employee);*/
	 
	
}

