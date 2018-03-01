package com.cognizant.services;

import java.util.List;

import com.cognizant.common.CompanyMgmtException;
import com.cognizant.domain.VendorApp;

public interface VendorAppService extends BaseService {


	public void saveOrUpdate(VendorApp vendorApp) throws CompanyMgmtException;

	public VendorApp findbyVendorAndProjId(String vendorId,String projId);

	public List<VendorApp> findbyProjId(String id);

}

