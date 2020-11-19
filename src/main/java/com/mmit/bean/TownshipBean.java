package com.mmit.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.mmit.entity.Township;
import com.mmit.service.TownshipService;
@Named
@RequestScoped
public class TownshipBean {

	private Township township;
	private List<Township> townshipList;
	@EJB
	private TownshipService service;
	
	@PostConstruct
	public void initialize() {
		String townshipid=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("townshipid");
		if(townshipid!=null)
			township=service.findById(Integer.parseInt(townshipid));	
		else 
			township=new Township();
			townshipList=service.findAll();
			
	}
	
	
	public Township getTownship() {
		return township;
	}

	public void setTownship(Township township) {
		this.township = township;
	}

	public List<Township> getTownshipList() {
		return townshipList;
	}

	public void setTownshipList(List<Township> townshipList) {
		this.townshipList = townshipList;
	}

	
	
}
