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

import com.cognizant.domain.Tender;
import com.cognizant.domain.VendorCertification;
import com.cognizant.services.TenderService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appContext.xml"})
@Transactional
public class TestTenderService {

	@Autowired
	TenderService tenderService;
	
	@Test
	@Rollback(value = false)
	public void testCertCreation(){
	Tender ten = new Tender();
	ten.setProject_Name("project a");
	ten.setProject_Incharge("tatsuro");
	ten.setProject_Description("eliminate zombies");
	ten.setProject_Dept("Team A");
	tenderService.saveOrUpdate(ten);
	List<Tender> tenderlist = tenderService.findAll();
	System.out.println(tenderlist);
	assertNotNull(tenderlist);
	}
	
	@Test
	@Rollback(value = false)
	public void testCertUpdate(){
		Tender ten  = tenderService.findProjectID(1L);
		ten.setProject_Description("kill zombies");
		tenderService.saveOrUpdate(ten);
		System.out.println(tenderService.find(1L));
	}
	
	@Test
	@Rollback(value = false)
	public void testFindByCertId(){
		Tender ten  = tenderService.findProjectID(1L);
		String tender = ten.getProject_Name();
		Assert.assertEquals("project a", tender);
	}
	
	@Test
	@Rollback(value = false)
	public void testDeleteCertificate(){
		tenderService.deleteTenderProject(1L);
		List<VendorCertification> vencertlist = tenderService.findAll();
		boolean flag;
		if (vencertlist.size()>0){
			flag = false;
		}else{
			flag=true;
		}
		Assert.assertEquals(true,flag);		
	}
}
