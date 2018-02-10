package com.cognizant.dao.impl;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.dao.VendorCertificationDao;
import com.cognizant.domain.VendorCertification;

@Repository("vendorCertificationDAO")
public class VendorCertificationDaoImpl extends JpaDAOImpl<Long, VendorCertification> implements VendorCertificationDao {

	@Autowired
    EntityManagerFactory entityManagerFactory;
	
	@PersistenceContext(unitName="CmpMgmt_PersistenceUnit")
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
		super.setEntityManager(entityManager);
		}
    
    @PostConstruct
    public void init() {
        super.setEntityManagerFactory(entityManagerFactory);
        super.setEntityManager(entityManager);
    }

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public VendorCertification findByCertificateId(Long certificate_Id) {
		
		return null;
	}

	

	
	
}
