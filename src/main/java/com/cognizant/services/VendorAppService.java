package com.cognizant.services;

import com.cognizant.common.CompanyMgmtException;
import com.cognizant.domain.VendorApp;

public interface VendorAppService extends BaseService {


	public void saveOrUpdate(VendorApp vendorApp) throws CompanyMgmtException;

	public VendorApp findbyVendorAndProjId(long vendorId,long projId);

}

