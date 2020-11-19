package com.mmit.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.mmit.entity.Recruiter;
@Stateless
public class RecruiterService {
	@PersistenceContext(name="jsf-template-assignment")
	private EntityManager em;
	
	
	public Recruiter check(String username, String password) throws EntityNotFoundException{
		TypedQuery<Recruiter> query=em.createNamedQuery("Recruiter.login",Recruiter.class);
		query.setParameter("name", username);
		query.setParameter("pass", password);
		return query.getSingleResult();
	}

}
