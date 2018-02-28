package com.cognizant.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@Entity
@NamedQueries({ 
	@NamedQuery(name="VendorCertification.findByVendorId", 
			query="SELECT v FROM VendorCertification v WHERE v.vendor_Id=:vendor_Id"),
	@NamedQuery(name="VendorCertification.findByCertificateId", 
		query="SELECT v FROM VendorCertification v WHERE v.certificate_Id=:certificate_Id")})
public class VendorCertification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long certificate_Id;
	
	private String vendor_Id;
	
	private String certificate_path;

	public Long getCertificate_Id() {
		return certificate_Id;
	}

	public void setCertificate_Id(Long certificate_Id) {
		this.certificate_Id = certificate_Id;
	}

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

	@Override
	public String toString() {
		return "VendorCertification [certificate_Id=" + certificate_Id
				+ ", vendor_Id=" + vendor_Id + ", certificate_path="
				+ certificate_path + "]";
	}
	
	
}
