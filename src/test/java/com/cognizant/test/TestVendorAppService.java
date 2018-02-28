package com.cognizant.test;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.domain.VendorApp;
import com.cognizant.services.VendorAppService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appContext.xml"})
@Transactional
public class TestVendorAppService {
	@Autowired
	VendorAppService vendorAppService;
	
	@Test
	@Rollback(value=false)
	public void testVendorAppCreation(){
		VendorApp venApp = new VendorApp();
		venApp.setVendorAppDate("12/1/1991");
		venApp.setVendorId(1231244);
		venApp.setProjId(2132142);
		vendorAppService.saveOrUpdate(venApp);
		VendorApp venApp1= (VendorApp) vendorAppService.findbyVendorAndProjId(1231244, 2132142);
		Assert.assertEquals("12/1/1991", venApp1.getVendorAppDate());
	}
	
	@Test
	@Rollback(value=false)
	public void testVendorAppDelete(){
		VendorApp venApp = new VendorApp();
		venApp.setVendorAppDate("12/1/1991");
		venApp.setVendorId(1231244);
		venApp.setProjId(2132142);
		vendorAppService.saveOrUpdate(venApp);
		VendorApp venApp1 = vendorAppService.findbyVendorAndProjId(1231244, 2132142);
		vendorAppService.delete(venApp1.getId());
		venApp1 = vendorAppService.findbyVendorAndProjId(1231244, 2132142);
		Assert.assertEquals(null, venApp1);
	}
	
	@Test
	@Rollback(value=false)
	public void testVendorAppUpdate(){
		VendorApp venApp = new VendorApp();
		venApp.setVendorAppDate("12/1/1991");
		venApp.setVendorId(1231244);
		venApp.setProjId(2132142);
		vendorAppService.saveOrUpdate(venApp);
		VendorApp venApp1= (VendorApp) vendorAppService.findbyVendorAndProjId(1231244, 2132142);
		venApp1.setVendorAppDate("10/10/2010");
		vendorAppService.saveOrUpdate(venApp1);
		venApp1= (VendorApp) vendorAppService.findbyVendorAndProjId(1231244, 2132142);
		Assert.assertEquals("10/10/2010", venApp1.getVendorAppDate());
	}
}
