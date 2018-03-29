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
import com.cognizant.domain.Vendor;
import com.cognizant.domain.VendorApp;
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
		Map<String, Long> queryParams = new HashMap<String, Long>();
		queryParams.put("employeeIdNo", Long.parseLong(employeeIdNo));
		
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
	public void saveOrUpdate(Employee employee) {
		
		Employee emp = getUniqueEmployee(employee.getEmployeeEmail());
		
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

	@Override
	public Employee getUniqueEmployee(String acc_email) {
		Map<String, String> queryParams = new HashMap<String, String>();
        queryParams.put("empEmail", acc_email);
        
        List<Employee> employees = findByNamedQueryAndNamedParams("Employee.getUniqueEmployee", queryParams);
        if(employees.size() > 1){
            throw new CompanyMgmtException("TOO_MANY_EMPLOYEE_BY_SAME_EMAIL");
        }
        if(employees.size() == 0){
            return null;
        }
        return employees.get(0);
	}

	@Override
	public List<Employee> findByEmployeeDeptAndCompany(String old_name,
			String com_name) {
		Map<String, String> queryParams = new HashMap<String, String>();
        queryParams.put("dept_name", old_name);
        queryParams.put("com_name", com_name);        
        
        List<Employee> employees = findByNamedQueryAndNamedParams("Employee.getEmployeeByDeptNameAndComId", queryParams);
        return employees;
	}
	
	
}
