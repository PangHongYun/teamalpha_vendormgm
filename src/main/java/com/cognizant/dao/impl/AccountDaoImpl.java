package com.cognizant.dao.impl;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.dao.AccountDao;
import com.cognizant.domain.Account;

@Repository("accountDao")
public class AccountDaoImpl extends JpaDAOImpl<Long, Account> implements AccountDao{

	@PersistenceContext(unitName="CmpMgmt_PersistenceUnit")
	private EntityManager entityManager;
	
	@Autowired
    EntityManagerFactory entityManagerFactory;
	
	@PostConstruct
    public void init() {
        super.setEntityManagerFactory(entityManagerFactory);
        super.setEntityManager(entityManager);
    }
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
    
    public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
		super.setEntityManager(entityManager);
		}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}


	

}
