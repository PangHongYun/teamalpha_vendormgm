package com.cognizant.dao;

import com.cognizant.domain.VendorCertification;

public interface VendorCertificationDao extends JPADAO<VendorCertification, Long> {

	VendorCertification findByCertificateId(Long certificate_Id);
}
