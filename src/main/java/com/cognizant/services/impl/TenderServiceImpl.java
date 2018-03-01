package com.cognizant.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.cognizant.common.CompanyMgmtException;
import com.cognizant.dao.JPADAO;
import com.cognizant.dao.TenderDao;
import com.cognizant.domain.Tender;
import com.cognizant.services.TenderService;

@Service("tenderService")
@org.springframework.transaction.annotation.Transactional(propagation = Propagation.REQUIRED, rollbackFor = CompanyMgmtException.class)
public class TenderServiceImpl extends BaseServiceImpl<Long, Tender>
		implements TenderService {

	@Autowired
	protected TenderDao tenderDao;

	@PostConstruct
	public void init() throws Exception {
		super.setDAO((JPADAO) tenderDao);
	}

	@PreDestroy
	public void destroy() {
	}

	@Override
	public void setEntityManagerOnDao(EntityManager entityManager) {
		
		tenderDao.setEntityManager(entityManager);
	}

	
	public Tender getTenderProject(Long Project_ID, String Project_Name) {
		String projectIdInString = Project_ID.toString();
	Map<String, String> queryParams= new HashMap<String, String>();
	
	queryParams.put("Project_ID", projectIdInString);
	queryParams.put("Project_Name", Project_Name);
	
	
	
	List<Tender> cT = findByNamedQueryAndNamedParams("createTender.getTenderProject", queryParams);
	 if(cT.size() > 1){
         throw new CompanyMgmtException("TOO_MANY_TENDERS_BY_SAME_NAME");
     }
     if(cT.size() == 0){
         return null;
     }
     return cT.get(0);
	}

	
	@Override
	public void saveOrUpdate(Tender tender) throws CompanyMgmtException {
		Tender cT = findProjectID(tender.getId());
	
	if(cT == null){
		tenderDao.persist(tender);
	}else{
		System.out.println("duplicate");
		tender.setId(cT.getId());
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.map(tender, cT);
		tenderDao.merge(cT);
	}
	}

	

	@Override
	public void deleteTenderProject(Long Project_ID)
			throws CompanyMgmtException {
		Tender cT = findProjectID(Project_ID);
		if(cT == null){
			throw new CompanyMgmtException("No Tender Found");
		}else{
			System.out.println("deleteing: "+cT);
			tenderDao.remove(cT);
		}
	}

	@Override
	public Tender findProjectID(Long Project_ID) throws CompanyMgmtException {
		Map<String, Long> queryParams = new HashMap<String, Long>();
		queryParams.put("id", Project_ID);
		
		List<Tender> cT = findByNamedQueryAndNamedParams("createTender.findProjectID", queryParams);
		if(cT.size() > 1){
	         throw new CompanyMgmtException("TOO_MANY_TENDERS_BY_SAME_NAME");
	     }
	     if(cT.size() == 0){
	         return null;
	     }
	     return cT .get(0);
	}

	@Override
	public List<Tender> findbyDeptId(Long id) {
		Map<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("Project_Dept", Long.toString(id));
		
		List<Tender> cT = findByNamedQueryAndNamedParams("createTender.findbyDeptId", queryParams);
	     return cT;
	}
	
		}