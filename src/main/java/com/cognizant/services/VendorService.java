package com.cognizant.services;

import java.util.List;

import com.cognizant.common.CompanyMgmtException;
import com.cognizant.domain.Account;
import com.cognizant.domain.Vendor;
import com.cognizant.domain.VendorApp;


public interface VendorService extends BaseService{

	void saveOrUpdate(Vendor vendor) throws CompanyMgmtException;
	
	Vendor getUniqueVendor(String vendorEmail) throws CompanyMgmtException;
	
	List<VendorApp> getApplications(long vendorId) throws CompanyMgmtException;
}
