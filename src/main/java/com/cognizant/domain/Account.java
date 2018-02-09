package com.cognizant.domain;


import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import com.cognizant.common.CompanyMgmtException;

@Entity
@NamedQueries({
    @NamedQuery(name="Account.getUniqueAccount", 
            query="SELECT a FROM Account a WHERE a.account_username=:account_username")
})
public class Account extends Base{
	
	
	
	String account_username;
	
	String account_password;	
	
	int account_type;

	public String getAccount_username() {
		return account_username;
	}

	public void setAccount_username(String account_username) {
		this.account_username = account_username;
	}

	public String getAccount_password() {
		return account_password;
	}

	public void setAccount_password(String account_password) {
		this.account_password = account_password;
	}

	public int getAccount_type() {
		return account_type;
	}

	public void setAccount_type(int account_type) {
		this.account_type = account_type;
	}
	
}
