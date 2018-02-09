package com.cognizant.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.domain.Employee;
import com.cognizant.services.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:appContext.xml"})
@Transactional
public class TestEmployeeService {

	@Autowired
	EmployeeService empService;
	
	@Test
	@Rollback(value = false)
	public void testFindEmployeeByIdNo(){
		Employee emp = empService.findByEmployeeIdNo("123");
		System.out.println(emp);
		assertNotNull(emp);
	}
	
	@Test 
	@Rollback(value = false)
	public void testCreateEmp(){
		Employee employee = new Employee();
		employee.setAccountId(1);
		employee.setEmployeeIdNo("123");
		employee.setEmployeeName("TIM");
		employee.setEmployeeEmail("TIM@cognizant.com");
		empService.createEmployee(employee);
	}
	
	@Test
	@Rollback(value = false)
	public void testUpdateEmp(){
		Employee emp = empService.findByEmployeeIdNo("123");
		emp.setEmployeeDepartment("IT");
		
		empService.saveOrUpdate(emp);
		
	}
	
	@Test
	@Rollback(value = true)
	public void testDeleteEmployee(){
		Employee emp = empService.findByEmployeeIdNo("123");
		
		empService.delete(emp.getId());
	}
}
