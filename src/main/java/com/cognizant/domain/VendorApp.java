package com.cognizant.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="VendorApp.findbyVendorAndProjId", query="SELECT v FROM VendorApp v where v.vendorId=:vendorId AND v.projId=:projId"),
	@NamedQuery(name="VendorApp.findbyProjId", query="SELECT v FROM VendorApp v where v.projId=:projId")
})
public class VendorApp extends Base{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2298385364540350275L;
	
	String vendorAppDate;

	String vendorId;
	
	String projId;
	
	int AppStatus;

	public int getAppStatus() {
		return AppStatus;
	}

	public void setAppStatus(int appStatus) {
		AppStatus = appStatus;
	}

	public String getVendorAppDate() {
		return vendorAppDate;
	}

	public void setVendorAppDate(String vendorAppDate) {
		this.vendorAppDate = vendorAppDate;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getProjId() {
		return projId;
	}

	public void setProjId(String projId) {
		this.projId = projId;
	}


	
}