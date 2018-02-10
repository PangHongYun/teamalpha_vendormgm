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
import com.cognizant.dao.VendorCertificationDao;
import com.cognizant.domain.Company;
import com.cognizant.domain.VendorCertification;
import com.cognizant.services.VendorCertificateService;


@Service("vendorCertificateService")
@org.springframework.transaction.annotation.Transactional(propagation= Propagation.REQUIRED, rollbackFor=CompanyMgmtException.class)
public class VendorCertificateServiceImpl extends BaseServiceImpl<Long, VendorCertification> implements VendorCertificateService {

	@Autowired
	protected VendorCertificationDao dao;

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
	public void deleteByCertificateId(Long certificate_Id)
			throws CompanyMgmtException {
		VendorCertification venc = findByCertificateId(certificate_Id);
		if(venc == null){
			System.out.println("no such certification...");
		}else{
			System.out.println("deleting : "+venc);
			dao.remove(venc);
		}
		
	}

	@Override
	public VendorCertification findByCertificateId(Long certificate_Id) {
		Map<String, Long> queryParams = new HashMap<String, Long>();
		queryParams.put("certificate_Id",certificate_Id);
		
		List<VendorCertification> vencert = findByNamedQueryAndNamedParams("VendorCertification.findByCertificateId", queryParams);
		if(vencert.size()>1){
			throw new CompanyMgmtException("identical certifications");
		}
		if(vencert.size() == 0){
			return null;
		}
		return vencert.get(0);
	}

	@Override
	public void saveOrUpdate(VendorCertification vendorCertification)
			throws CompanyMgmtException {
		VendorCertification vencert = dao.findByCertificateId(vendorCertification.getCertificate_Id());
		if( vencert == null){
			dao.persist(vendorCertification);
		}else{
			vendorCertification.setCertificate_Id(vencert.getCertificate_Id());
			Mapper mapper = new DozerBeanMapper();
			mapper.map(vendorCertification, vencert);
			dao.merge(vencert);
			
		}
		
	}
    
    
    
    


}
