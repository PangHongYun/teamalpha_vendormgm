package com.cognizant.services;

import com.cognizant.domain.Account;

public interface AccountService extends BaseService{
	
	public void saveOrUpdate(Account account) throws CompanyMgmtException;

	Account getUniqueAccount(String account_email) throws CompanyMgmtException;

}
