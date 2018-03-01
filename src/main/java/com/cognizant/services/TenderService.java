package com.cognizant.services;

import java.util.List;

import com.cognizant.common.CompanyMgmtException;
import com.cognizant.domain.Tender;

public interface TenderService extends BaseService {

	public Tender getTenderProject(Long Project_ID, String Project_Name)
			throws CompanyMgmtException;

	public void saveOrUpdate(Tender createTender) throws CompanyMgmtException;

	public Tender findProjectID(Long Project_ID) throws CompanyMgmtException;

	public void deleteTenderProject(Long Project_ID)
			throws CompanyMgmtException;
	public List<Tender> findbyDeptId(Long id);


}
