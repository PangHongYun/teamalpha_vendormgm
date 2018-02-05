package com.cognizant.services;

import com.cognizant.common.CompanyMgmtException;
import com.cognizant.domain.Vendor;


public interface VendorService extends BaseService{

	void saveOrUpdate(Vendor vendor) throws CompanyMgmtException;
	
	
}
