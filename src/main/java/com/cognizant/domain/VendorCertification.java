package com.cognizant.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@Entity
@NamedQueries({ 
	@NamedQuery(name="VendorCertification.findByCertificateId", 
			query="SELECT v FROM VendorCertification v WHERE v.id=:certificate_Id"),
			@NamedQuery(name="VendorCertification.findByVendorId", 
			query="SELECT v FROM VendorCertification v WHERE v.vendor_Id=:vendor_Id")})
public class VendorCertification extends Base{
	
	private static final long serialVersionUID = -7503817170501893656L;

	private String vendor_Id;
	
	private String certificate_name;
	
	private String certificate_path;

	public String getVendor_Id() {
		return vendor_Id;
	}

	public void setVendor_Id(String vendor_Id) {
		this.vendor_Id = vendor_Id;
	}

	public String getCertificate_path() {
		return certificate_path;
	}

	public void setCertificate_path(String certificate_path) {
		this.certificate_path = certificate_path;
	}

	public String getCertificate_name() {
		return certificate_name;
	}

	public void setCertificate_name(String certificate_name) {
		this.certificate_name = certificate_name;
	}
	
	
}
