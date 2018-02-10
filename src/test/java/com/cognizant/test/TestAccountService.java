package com.cognizant.test;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.domain.Account;
import com.cognizant.services.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appContext.xml"})
@Transactional
public class TestAccountService {
	
	@Autowired
	AccountService accountService;

	@Test
	@Rollback(value=false)
	public void testVendorAccountCreation(){
		Account acc = new Account();
		acc.setAcc_email("hi@hi.com");
		acc.setAcc_password("000000");
		acc.setAcc_type(1);
		accountService.saveOrUpdate(acc);
		boolean flag;
		String email=acc.getAcc_email();
		Account acc2=accountService.getUniqueAccount(email);
		if(acc2!=null){
			flag=true;
		}
		else{
			flag=false;
		}
		Assert.assertEquals(true, flag);
	}
	@Test
	@Rollback(value=false)
	public void testChangePassword(){
		Account acc = new Account();
		acc.setAcc_email("hi@hi.com");
		acc.setAcc_password("000000");
		acc.setAcc_type(1);
		accountService.saveOrUpdate(acc);
		acc=accountService.getUniqueAccount(acc.getAcc_email());
		acc.setAcc_password("111111");
		accountService.saveOrUpdate(acc);
		Assert.assertEquals("111111", accountService.getUniqueAccount(acc.getAcc_email()).getAcc_password());
	}

	@Test
	@Rollback(value=false)
	public void testAuthentication(){
		Account acc = new Account();
		acc.setAcc_email("hi@hi.com");
		acc.setAcc_password("000000");
		acc.setAcc_type(1);
		accountService.saveOrUpdate(acc);
		Assert.assertEquals(true, accountService.authenticateAccount(acc.getAcc_email(), acc.getAcc_password()));
		Assert.assertEquals(false, accountService.authenticateAccount(acc.getAcc_email(),"asdfghjkl"));
	}

}
