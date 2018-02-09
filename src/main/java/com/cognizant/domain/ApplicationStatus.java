package com.cognizant.domain;

import javax.persistence.Entity;

@Entity
public class ApplicationStatus extends Base {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4756479168478018916L;
	
	private String applicationStatusName;

	public String getApplicationStatusName() {
		return applicationStatusName;
	}

	public void setApplicationStatusName(String applicationStatusName) {
		this.applicationStatusName = applicationStatusName;
	}
	
	
}
