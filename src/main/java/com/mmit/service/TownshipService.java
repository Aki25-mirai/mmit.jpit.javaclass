package com.mmit.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.mmit.entity.Township;

@Stateless
public class TownshipService {
	
	@PersistenceContext(name="jsf-template-assignment")
	private EntityManager em;
	
	public List<Township> findAll() {
		TypedQuery<Township> query=em.createQuery("SELECT t FROM Township t",Township.class);
		return query.getResultList();
	}

	public Township findById(int id) {
		return em.find(Township.class, id);
	}

}
