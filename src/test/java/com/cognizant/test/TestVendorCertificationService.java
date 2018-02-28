package com.cognizant.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.domain.VendorCertification;
import com.cognizant.services.VendorCertificateService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appContext.xml"})
@Transactional
public class TestVendorCertificationService {

	@Autowired
	VendorCertificateService vencService;
	
	@Test
	@Rollback(value = false)
	public void testCertCreation(){
	VendorCertification venc = new 	VendorCertification();
	venc.setCertificate_path("asdfasdfasdf");
	venc.setVendor_Id("apple");
	vencService.saveOrUpdate(venc);
	List<VendorCertification> vencertlist = vencService.findAll();
	System.out.println(vencertlist);
	assertNotNull(vencertlist);
	}
	
	@Test
	@Rollback(value = false)
	public void testCertUpdate(){
		VendorCertification venc = vencService.findByCertificateId(1L);
		venc.setCertificate_path("efg/efg");
		vencService.saveOrUpdate(venc);
		System.out.println(vencService.find(1L));
	}
	
	@Test
	@Rollback(value = false)
	public void testFindByCertId(){
		VendorCertification venc = vencService.findByCertificateId(1L);
		String vendor = venc.getVendor_Id();
		Assert.assertEquals("cognizant", vendor);
	}
	
	@Test
	@Rollback(value = false)
	public void testDeleteCertificate(){
		vencService.deleteByCertificateId(1L);
		List<VendorCertification> vencertlist = vencService.findAll();
		boolean flag;
		if (vencertlist.size()>0){
			flag = false;
		}else{
			flag=true;
		}
		Assert.assertEquals(true,flag);		
	}
	
	
}
