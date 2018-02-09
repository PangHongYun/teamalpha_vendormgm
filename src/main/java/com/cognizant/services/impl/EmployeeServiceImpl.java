package com.cognizant.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.cognizant.common.CompanyMgmtException;
import com.cognizant.dao.EmployeeDao;
import com.cognizant.dao.JPADAO;
import com.cognizant.domain.Employee;
import com.cognizant.services.EmployeeService;

@Service("employeeService")
@org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRED, rollbackFor = CompanyMgmtException.class)
public class EmployeeServiceImpl extends BaseServiceImpl<Long, Employee> implements EmployeeService{

	@Autowired
	protected EmployeeDao dao;
	
	@PostConstruct
    public void init() throws Exception {
	 super.setDAO( (JPADAO)dao);
    }
    
    @PreDestroy
    public void destroy() {
    }
    
    @Override
    public void setEntityManagerOnDao(EntityManager entityManager){
    	dao.setEntityManager(entityManager);
    }

	@Override
	public Employee findByEmployeeIdNo(String employeeIdNo) {
		Map<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("employeeIdNo", employeeIdNo);
		
		List<Employee> emp = findByNamedQueryAndNamedParams("Employee.findByEmployeeIdNo", queryParams);
		if(emp.size() > 1){
	         throw new CompanyMgmtException("duplicate");
	     }
	     if(emp.size() == 0){
	         return null;
	     }
	     return emp.get(0);
	}
	
	@Override
	public void createEmployee(Employee employee) {
		
		Employee emp = findByEmployeeIdNo(employee.getEmployeeIdNo());
		
		if(emp == null){
			dao.persist(employee);
		}else{
			System.out.println("duplicate");
			employee.setId(emp.getId());//incase we search via empty id
			Mapper mapper = new DozerBeanMapper();
			mapper.map(employee, emp);
			dao.merge(emp);
	}
}
	
	
}
