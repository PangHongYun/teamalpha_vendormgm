package com.cognizant.services;

import java.util.List;

import com.cognizant.common.CompanyMgmtException;
import com.cognizant.domain.Company;
import com.cognizant.domain.VendorCertification;

public interface VendorCertificateService extends BaseService{
	
	 public void saveOrUpdate(VendorCertification vendorCertificationdor) throws CompanyMgmtException;

	 public VendorCertification findByCertificateId(Long certificate_Id);
	 
	 public List<VendorCertification> findByVendorId(String vendor_Id);
	 
	 public void deleteByCertificateId(Long certificate_Id) throws CompanyMgmtException;
	

}
