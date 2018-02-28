package com.cognizant.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.cognizant.common.CompanyMgmtException;
import com.cognizant.dao.AccountDao;
import com.cognizant.dao.JPADAO;
import com.cognizant.domain.Account;
import com.cognizant.services.AccountService;

@Service("accountService")
@org.springframework.transaction.annotation.Transactional(propagation= Propagation.REQUIRED, rollbackFor=CompanyMgmtException.class)
public class AccountServiceImpl extends BaseServiceImpl<Long, Account> implements AccountService{
	
//	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//	Validator validator = factory.getValidator();
	
	@Autowired
    protected AccountDao dao;

	@PostConstruct
    public void init() throws Exception {
	 super.setDAO( (JPADAO)dao);
    }
    
    @PreDestroy
    public void destroy() {
    }
    
    @Override
    public void setEntityManagerOnDao(EntityManager entityManager){
    	dao.setEntityManager(entityManager);
    }

	@Override
	public void saveOrUpdate(Account account) throws CompanyMgmtException {
		String acc_email=account.getAcc_email();
		Account acc2=getUniqueAccount(acc_email);
		if(acc2==null){
			dao.persist(account);
		}
		else{
			Mapper mapper=new DozerBeanMapper();
			account.setId(acc2.getId());
			mapper.map(account,acc2);
			dao.merge(acc2);
		}
	}
	
	@Override
    public Account getUniqueAccount(String acc_email) throws CompanyMgmtException {
        Map<String, String> queryParams = new HashMap<String, String>();
        queryParams.put("acc_email", acc_email);
        
        List<Account> accounts = findByNamedQueryAndNamedParams("Account.getUniqueAccount", queryParams);
        if(accounts.size() > 1){
            throw new CompanyMgmtException("TOO_MANY_ACCOUNTS_BY_SAME_EMAIL");
        }
        if(accounts.size() == 0){
            return null;
        }
        return accounts.get(0);
    }

	@Override
    public boolean authenticateAccount(String acc_email,String acc_password) throws CompanyMgmtException {
        Map<String, String> queryParams = new HashMap<String, String>();
        queryParams.put("acc_email", acc_email);
        queryParams.put("acc_password", acc_password);
        
        List<Account> accounts = findByNamedQueryAndNamedParams("Account.authenticateAccount", queryParams);
        if(accounts.size() == 1){
            return true;
        }
        else{
        	return false;
        }
    }
	
	
}
