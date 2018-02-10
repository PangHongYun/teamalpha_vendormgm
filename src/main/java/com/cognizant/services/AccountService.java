package com.cognizant.services;

import com.cognizant.common.CompanyMgmtException;
import com.cognizant.domain.Account;

public interface AccountService extends BaseService{
	
	public void saveOrUpdate(Account account) throws CompanyMgmtException;

	Account getUniqueAccount(String acc_email) throws CompanyMgmtException;

	boolean authenticateAccount(String acc_email, String acc_password)
			throws CompanyMgmtException;


}