package com.cognizant.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.cognizant.common.CompanyMgmtException;
import com.cognizant.dao.JPADAO;
import com.cognizant.dao.VendorDao;
import com.cognizant.domain.Account;
import com.cognizant.domain.Vendor;
import com.cognizant.domain.VendorApp;
import com.cognizant.services.VendorService;


@Service("vendorService")
@org.springframework.transaction.annotation.Transactional(propagation= Propagation.REQUIRED, rollbackFor=CompanyMgmtException.class)
public class VendorServiceImpl extends BaseServiceImpl<Long, Vendor> implements VendorService{
	
//	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//	Validator validator = factory.getValidator();
	
	@Autowired
	protected VendorDao dao;

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
	public void saveOrUpdate(Vendor vendor) throws CompanyMgmtException {
		dao.persist(vendor);
	}
	
	@Override
	public List<Vendor> findAll() throws CompanyMgmtException {
		return dao.findAll();
	}

	@Override
	public Vendor getUniqueVendor(String vendorEmail)
			throws CompanyMgmtException {
		Map<String, String> queryParams = new HashMap<String, String>();
        queryParams.put("vendorEmail", vendorEmail);
        
        List<Vendor> vendors = findByNamedQueryAndNamedParams("Vendor.getUniqueVendor", queryParams);
        if(vendors.size() > 1){
            throw new CompanyMgmtException("TOO_MANY_VENDOR_BY_SAME_EMAIL");
        }
        if(vendors.size() == 0){
            return null;
        }
        return vendors.get(0);
	}

	@Override
	public List<VendorApp> getApplications(long vendorId) throws CompanyMgmtException {
		Map<String, Long> queryParams = new HashMap<String, Long>();
        queryParams.put("vendorId", vendorId);
        
        List<VendorApp> appList = findByNamedQueryAndNamedParams("Vendor.getApplications", queryParams);
		return appList;
	}

	
}
