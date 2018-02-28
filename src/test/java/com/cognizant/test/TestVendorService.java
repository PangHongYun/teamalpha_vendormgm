package com.cognizant.test;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.domain.Company;
import com.cognizant.domain.Vendor;
import com.cognizant.services.CompanyService;
import com.cognizant.services.VendorService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appContext.xml"})
@Transactional
public class TestVendorService {
	
	@Autowired
	VendorService vendorService;
	
	@Autowired
	CompanyService companyService;
	
	//==================================================TEST VENDOR ========================================================================
	
	@Test
	@Rollback(value=false)
	public void testVendorCreation(){
		Vendor ven = new Vendor();
		ven.setVendorName("Vendor 2");
		ven.setCreatedBy("HY");
		ven.setCreatedDate(new Date());
		vendorService.saveOrUpdate(ven);
	}
	
	@Test
	@Rollback(value=false)
	public void testUpdateVendor(){
		Vendor vendor = (Vendor) vendorService.find(5L);
		vendor.setVendorRegistrationNumber("");
		vendor.setVendorEmail("hy.pang@cognizant.com");
		vendorService.save(vendor);
		
	}
	
	
	@Test
	public void testFindAll(){
		List<Vendor> venlist = vendorService.findAll();
		System.out.println(venlist);
		assertNotNull(venlist);
	}
	
	
	
	

}
