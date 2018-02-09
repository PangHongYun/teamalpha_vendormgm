package com.cognizant.dao.impl;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.dao.CompanyDao;
import com.cognizant.domain.Company;

@Repository("companyDAO")
public class CompanyDaoImpl extends JpaDAOImpl<Long, Company> implements CompanyDao {

	@Autowired
	EntityManagerFactory entityManagerFactor;
	
	@PersistenceContext(unitName="CmpMgmt_PersistenceUnit")
	EntityManager entityManager;
	
    @PostConstruct
    public void init() {
        super.setEntityManagerFactory(entityManagerFactory);
        super.setEntityManager(entityManager);        
    } 
    
	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
		super.setEntityManager(entityManager);
		}

	public EntityManagerFactory getEntityManagerFactor() {
		return entityManagerFactor;
	}

	public void setEntityManagerFactor(EntityManagerFactory entityManagerFactor) {
		this.entityManagerFactor = entityManagerFactor;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

    

}
