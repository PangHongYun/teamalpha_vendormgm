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
import com.cognizant.dao.JPADAO;
import com.cognizant.dao.VendorAppDao;
import com.cognizant.domain.VendorApp;
import com.cognizant.services.VendorAppService;

@Service("vendorAppService")
@org.springframework.transaction.annotation.Transactional(propagation= Propagation.REQUIRED, rollbackFor=CompanyMgmtException.class)
public class VendorAppServiceImpl extends BaseServiceImpl<Long, VendorApp> implements VendorAppService{
	
	@Autowired
    protected VendorAppDao VendorAppDao;

	@PostConstruct
    public void init() throws Exception {
	 super.setDAO( (JPADAO)VendorAppDao);
    }
    
    @PreDestroy
    public void destroy() {
    }
    
    @Override
    public void setEntityManagerOnDao(EntityManager entityManager){
    	VendorAppDao.setEntityManager(entityManager);
    }

	@Override
	public void saveOrUpdate(VendorApp vendorApp) throws CompanyMgmtException {
		VendorApp venApp= findbyVendorAndProjId(vendorApp.getVendorId(),vendorApp.getProjId());
		
		if (venApp==null){
			VendorAppDao.persist(vendorApp);
		}
		else{
			vendorApp.setId(venApp.getId());
			Mapper mapper=new DozerBeanMapper();
			mapper.map(vendorApp,venApp);
			VendorAppDao.merge(venApp);
		}
	
	}
	
	public VendorApp findbyVendorAndProjId(String vendorId,String projId){
		Map<String,String>map=new HashMap<String,String>();
		map.put("vendorId",vendorId);
		map.put("projId", projId);
		
		List<VendorApp> vendorApp= findByNamedQueryAndNamedParams("VendorApp.findbyVendorAndProjId",map);
		if(vendorApp.size()>1){
			throw new CompanyMgmtException("Too_many_vendors_app_by_same_id");
		}
		if(vendorApp.size()==0){
			return null;
		}
		return vendorApp.get(0);
	}

	@Override
	public List<VendorApp> findbyProjId(String id) {
		Map<String,String>map=new HashMap<String,String>();
		map.put("projId", id);
		
		List<VendorApp> vendorApp= findByNamedQueryAndNamedParams("VendorApp.findbyProjId",map);
		return vendorApp;
	}



}
