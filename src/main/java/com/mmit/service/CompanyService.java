package com.mmit.service;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.mmit.entity.Company;
import com.mmit.bean.LoginBean;
@Stateless
public class CompanyService {
	
	@PersistenceContext(name="jsf-template-assignment")
	
	private EntityManager em;
	
	@Inject
	private LoginBean loginbean;

	public Company findById(int id) {
		
		return em.find(Company.class, id);
	}

	public List<Company> findAll() {
		
		return em.createQuery("SELECT c FROM Company c",Company.class).getResultList();
		
	}

	public void save(Company company) {
		if(company.getId()==0)	
		{	
			company.setIsHot(company.getIsHot());
			company.setEntryBy(loginbean.getLoginUser());
			company.setEntryDate(LocalDate.now());
			em.persist(company);
			
		}
		else
		{
			company=findById(company.getId());
			company.setModifyBy(loginbean.getLoginUser());
			company.setModifyDate(LocalDate.now());
			
		}
			
		}

	public void delete(int id) {
		Company c=em.find(Company.class, id);
		em.remove(c);
		
	}

}
