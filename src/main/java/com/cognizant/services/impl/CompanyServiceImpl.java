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
import com.cognizant.dao.CompanyDao;
import com.cognizant.dao.JPADAO;
import com.cognizant.domain.Company;
import com.cognizant.services.CompanyService;

@Service("companyService")
@org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRED, rollbackFor = CompanyMgmtException.class)
public class CompanyServiceImpl extends BaseServiceImpl<Long, Company>
		implements CompanyService {

	@Autowired
	protected CompanyDao companyDao;

	@PostConstruct
	public void init() throws Exception {
		super.setDAO((JPADAO) companyDao);
	}

	@PreDestroy
	public void destroy() {
	}

	@Override
	public void setEntityManagerOnDao(EntityManager entityManager) {
		
		companyDao.setEntityManager(entityManager);
	}

	
	public Company getUniqueCompany(String companyName,
			String companyRegistrationNumber) {
		
	Map<String, String> queryParams= new HashMap<String, String>();
	
	queryParams.put("companyName", companyName);
	queryParams.put("companyRegistrationNumber", companyRegistrationNumber);
	
	
	List<Company> companies = findByNamedQueryAndNamedParams("Company.getUniqueCompany", queryParams);
	 if(companies.size() > 1){
         throw new CompanyMgmtException("TOO_MANY_COMPANIES_BY_SAME_NAME");
     }
     if(companies.size() == 0){
         return null;
     }
     return companies.get(0);
	}

	
	@Override
	public void saveOrUpdate(Company company) throws CompanyMgmtException {
	Company comp = findByRegistrationNumber(company.getCompanyRegistrationNumber());
	
	if(comp == null){
		companyDao.persist(company);
	}else{
		company.setId(comp.getId());//incase we search via empty id
		Mapper mapper = new DozerBeanMapper();
		mapper.map(company, comp);
		companyDao.merge(comp);
	}
	}

	@Override
	public Company findByRegistrationNumber(String companyRegistrationNumber) {
		Map<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("companyRegistrationNumber", companyRegistrationNumber);
		
		List<Company> com = findByNamedQueryAndNamedParams("Company.findByRegistrationNumber", queryParams);
		if(com.size() > 1){
	         throw new CompanyMgmtException("TOO_MANY_COMPANIES_BY_SAME_NAME");
	     }
	     if(com.size() == 0){
	         return null;
	     }
	     return com.get(0);
	}

	@Override
	public void deleteByRegistrationNumber(String companyRegistrationNumber)
			throws CompanyMgmtException {
		Company com = findByRegistrationNumber(companyRegistrationNumber);
		if(com == null){
			throw new CompanyMgmtException("No such company...");
		}else{
			System.out.println("deletting: "+com);
			companyDao.remove(com);
		}
	}




	

	
}
