package com.cognizant.services;

import com.cognizant.common.CompanyMgmtException;
import com.cognizant.domain.Department;


public interface DepartmentService extends BaseService{
	
	public void saveOrUpdate(Department dept) throws CompanyMgmtException;

	Department findbyDepartmentNameAndComId(String dept_name, Long com_id);

	public Department findbyDepartmentId(Long d_id);


}
