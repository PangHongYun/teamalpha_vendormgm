package com.cognizant.dao;

import com.cognizant.domain.Company;

public interface CompanyDao extends JPADAO<Company, Long> {

	Company findByCompanyRegistrationNumber(String companyRegistrationNumber);

}
