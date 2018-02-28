package com.cognizant.test;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.domain.Department;
import com.cognizant.services.DepartmentService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appContext.xml"})
@Transactional
public class TestDepartmentService {

	
	@Autowired
	DepartmentService departmentService;
	
	@Test
	@Rollback(value=false)
	public void testDepartmentCreation(){
		Department dept = new Department();
		dept.setDept_name("ADGADS");
		dept.setCom_id((long) 85778);
		departmentService.saveOrUpdate(dept);
		Department dept1= (Department) departmentService.findbyDepartmentNameAndComId("ADGADS", (long) 85778);
		Assert.assertEquals("ADGADS", dept1.getDept_name());
	}
	
	@Test
	@Rollback(value=false)
	public void testDepartmentAppDelete(){
		Department dept = new Department();
		dept.setDept_name("ADGADS");
		dept.setCom_id((long) 85778);
		departmentService.saveOrUpdate(dept);
		Department dept1 = departmentService.findbyDepartmentNameAndComId(dept.getDept_name(), dept.getCom_id());
		departmentService.delete(dept1.getId());
		dept1 = departmentService.findbyDepartmentNameAndComId("ADGADS", (long) 85778);
		Assert.assertEquals(null, dept1);
	}
	
	@Test
	@Rollback(value=false)
	public void testDepartmentAppUpdate(){
		Department dept = new Department();
		dept.setDept_name("ADGADS");
		dept.setCom_id((long) 85778);
		departmentService.saveOrUpdate(dept);
		Department dept1= (Department) departmentService.findbyDepartmentNameAndComId("ADGADS", (long) 85778);
		dept1.setDept_name("AAAA");
		departmentService.saveOrUpdate(dept1);
		dept1= (Department) departmentService.findbyDepartmentNameAndComId("AAAA", (long) 85778);
		Assert.assertEquals("AAAA", dept1.getDept_name());
	}
}