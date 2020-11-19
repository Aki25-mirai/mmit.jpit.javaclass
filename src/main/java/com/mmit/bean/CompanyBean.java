package com.mmit.bean;


import java.util.List;


import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.mmit.entity.Company;
import com.mmit.service.CompanyService;
@Named
@RequestScoped
public class CompanyBean {
	
	private Company company;
	private List<Company> companyList;
	
	@EJB
	private CompanyService service;
	
	@PostConstruct
	private void initialize() {
		Map<String,String> parms=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String id=parms.get("companyid");
		if(id!=null)
			company=service.findById(Integer.parseInt(id));
		else
		company=new Company();
		companyList=service.findAll();
		
	}
	
	public String saveCompany()
	{
		service.save(company);
		return "/views/company?faces-redirect=true";
	}
	
	public String removeCompany(int id)
	{
		service.delete(id);
		return "/views/company?faces-redirect=true";
	}


	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Company> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}

}
