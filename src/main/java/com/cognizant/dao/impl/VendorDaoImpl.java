package com.cognizant.dao.impl;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.dao.VendorDao;
import com.cognizant.domain.Vendor;

@Repository("vendorDAO")
public class VendorDaoImpl  extends JpaDAOImpl<Long, Vendor> implements VendorDao{
	
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
	
	
	
	
}