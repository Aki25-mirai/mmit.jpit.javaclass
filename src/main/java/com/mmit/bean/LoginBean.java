package com.mmit.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.mmit.entity.Recruiter;
import com.mmit.service.RecruiterService;

@Named
@SessionScoped
public class LoginBean implements Serializable{
	
	
	private String username;
	private String password;
	
	
	private Recruiter loginUser;
	
	@EJB
	private RecruiterService service;
	
	
	private static final long serialVersionUID = 1L;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@PostConstruct
	private void init()
	{
		loginUser=new Recruiter();
	}
	//action listener method
		public void checkUser()
		{
			FacesContext context=FacesContext.getCurrentInstance();
			try {
			loginUser=service.check(username, password);
			}catch(Exception e)
			{
				FacesMessage msg=new FacesMessage("Invalid Login!");
				context.addMessage(null, msg);
				context.validationFailed();
			}
		}
		
		//action method
		public String authenticateUser()
		{
			FacesContext context=FacesContext.getCurrentInstance();
			if(context.isValidationFailed())
				return null;
			return "/views/dashboard?faces-redirect=true";
		}
		
		//logout method
		public String processLogOut()
		{
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return "/index?faces-redirect=true";
		}
		
		public Recruiter getLoginUser() {
			return loginUser;
		}
		public void setLoginUser(Recruiter loginUser) {
			this.loginUser = loginUser;
		}
	

}
