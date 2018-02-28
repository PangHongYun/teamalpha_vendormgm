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
import com.cognizant.services.CompanyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appContext.xml"})
@Transactional
public class TestCompanyService {

	@Autowired
	CompanyService companyService;
	
		@Test
		@Rollback(value = false)
		public void testCompanyCreation(){
			Company com = new Company();
			com.setCompanyAddress("ASDFASDFA");
			com.setCompanyName("ASDFASDFASDF");
			com.setCreatedBy("ASDFASDF");
			com.setCompanyRegistrationNumber("LOLIPOP");
			com.setCreatedDate(new Date());
			companyService.saveOrUpdate(com);
			System.out.println("company created");
		}
		
		@Test
		@Rollback(value=false)
		public void testUpdateCompany(){
//			companyService.updateEmail(companyName,companyRegistrationNo,email);
			Company com = (Company) companyService.findByRegistrationNumber("KNNCCB");
			com.setCompanyEmail("hongyun.pang@cognizant.com");
			companyService.saveOrUpdate(com);	
		}
		
		@Test
		public void testFindCompany(){
			List<Company> comlist = companyService.findAll();
			System.out.println(comlist);
			assertNotNull(comlist);		
		}
		
		@Test
		public void testFindByRegistrationNumber(){
			Company com = (Company) companyService.findByRegistrationNumber("KNNCCB");
			assertNotNull(com);
		}
		
		@Test
		public void testgetUniqueCompany(){
			Company company = companyService.getUniqueCompany("Cognizant", "KNNCCB");
			System.out.println(company);
			assertNotNull(company);
		}
		
		@Test
		@Rollback(value = true)
		public void testDeleteCompany(){
			companyService.deleteByRegistrationNumber("KNNCCB");
			System.out.println("Delete Company Account Successfully...");
		}
}
