package com.cognizant.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="VendorApp.findbyVendorAndProjId", query="SELECT v FROM VendorApp v where v.vendorId=:vendorId AND v.projId=:projId")
})
public class VendorApp extends Base{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2298385364540350275L;
	
	String vendorAppDate;

	long vendorId;
	
	long projId;

	public String getVendorAppDate() {
		return vendorAppDate;
	}

	public void setVendorAppDate(String vendorAppDate) {
		this.vendorAppDate = vendorAppDate;
	}

	public long getVendorId() {
		return vendorId;
	}

	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;
	}

	public long getProjId() {
		return projId;
	}

	public void setProjId(long projId) {
		this.projId = projId;
	}


	
}