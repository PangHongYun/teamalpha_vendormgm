package com.cognizant.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;




@Entity
@NamedQueries({
	@NamedQuery(name = "Account.getUniqueAccount", query = "SELECT a FROM Account a WHERE a.acc_email=:acc_email"),
	@NamedQuery(name = "Account.authenticateAccount", query = "SELECT a FROM Account a WHERE a.acc_email=:acc_email AND a.acc_password=:acc_password")
})
public class Account extends Base {

private	String acc_email;

private	String acc_password;

private	int acc_type;

	public String getAcc_email() {
		return acc_email;
	}

	public void setAcc_email(String acc_email) {
		this.acc_email = acc_email;
	}

	public String getAcc_password() {
		return acc_password;
	}

	public void setAcc_password(String acc_password) {
		this.acc_password = acc_password;
	}

	public int getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(int acc_type) {
		this.acc_type = acc_type;
	}

}

