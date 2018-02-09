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
import com.cognizant.dao.JPADAO;
import com.cognizant.dao.AccountDao;
import com.cognizant.domain.Account;
import com.cognizant.services.AccountService;

@Service("accountService")
@org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRED, rollbackFor = CompanyMgmtException.class)
public class AccountServiceImpl extends BaseServiceImpl<Long, Account>
		implements AccountService {

	// ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	// Validator validator = factory.getValidator();

	@Autowired
	protected AccountDao dao;

	@PostConstruct
	public void init() throws Exception {
		super.setDAO((JPADAO) dao);
	}

	@PreDestroy
	public void destroy() {
	}

	@Override
	public void setEntityManagerOnDao(EntityManager entityManager) {
		dao.setEntityManager(entityManager);
	}

	@Override
	public void saveOrUpdate(Account account) throws CompanyMgmtException {
		//val
		
		String name = account.getAccount_username();
		Account account2 = getUniqueAccount(name);
		if ( account2== null) {
			dao.persist(account);
		}
		else{
			Mapper  mapper = new DozerBeanMapper();
			account.setId(account2.getId());
			mapper.map(account, account2);
			dao.merge(account2);
		}
	}

	@Override
	    public Account getUniqueAccount(String acc_uname) throws CompanyMgmtException {
	        //Company.getUniqueCompany
	        Map<String, String> queryParams = new HashMap<String, String>();
	        queryParams.put("account_username", acc_uname);
	        
	        List<Account> accs = findByNamedQueryAndNamedParams("Account.getUniqueAccount", queryParams);
	        if(accs.size() > 1){
	            throw new CompanyMgmtException("TOO_MANY_ACCOUNTS_BY_SAME_USERNAME");
	        }
	        if(accs.size() == 0){
	            return null;
	        }
	        return accs.get(0);
	    }
	
	

}
