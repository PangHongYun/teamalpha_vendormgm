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
import com.cognizant.dao.DepartmentDao;
import com.cognizant.dao.JPADAO;
import com.cognizant.domain.Department;
import com.cognizant.services.DepartmentService;

@Service("departmentService")
@org.springframework.transaction.annotation.Transactional(propagation= Propagation.REQUIRED, rollbackFor=CompanyMgmtException.class)
public class DepartmentServiceImpl extends BaseServiceImpl<Long, Department> implements DepartmentService{
	
	@Autowired
    protected DepartmentDao DepartmentDao;

	@PostConstruct
    public void init() throws Exception {
	 super.setDAO( (JPADAO)DepartmentDao);
    }
    
    @PreDestroy
    public void destroy() {
    }
    
    @Override
    public void setEntityManagerOnDao(EntityManager entityManager){
    	DepartmentDao.setEntityManager(entityManager);
    }

	@Override
	public void saveOrUpdate(Department dept) throws CompanyMgmtException {
		Department dept1= findbyDepartmentNameAndComId(dept.getDept_name(),dept.getCom_id());
		
		if (dept1==null){
			DepartmentDao.persist(dept);
		}
		else{
			dept.setId(dept1.getId());
			Mapper mapper=new DozerBeanMapper();
			mapper.map(dept,dept1);
			DepartmentDao.merge(dept1);
		}
	
	}

	@Override
	public Department findbyDepartmentNameAndComId(String dept_name,Long com_id) {
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("dept_name",dept_name);
		map.put("com_id", com_id);
		
		List<Department> depts= findByNamedQueryAndNamedParams("Department.findbyDepartmentNameAndComId",map);
		if(depts.size()>1){
			throw new CompanyMgmtException("Too_many_department_by_same_name_or_company");
		}
		if(depts.size()==0){
			return null;
		}
		return depts.get(0);
	}

	
	
	
		
}

