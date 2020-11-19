package com.mmit.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Company implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String phone1;
	private String phone2;
	private String email;
	private String website;
	private String ownerName;
	private String address;
	@ManyToOne
	@JoinColumn(name = "township_id")
	private Township township;
	@ManyToOne
	@JoinColumn(name = "entryBy")
	private Recruiter entryBy;
	private LocalDate entryDate;
	@ManyToOne
	@JoinColumn(name = "modifyBy")
	private Recruiter modifyBy;
	private LocalDate modifyDate;
	private String remark;
	private Boolean isHot;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Township getTownship() {
		return township;
	}
	public void setTownship(Township township) {
		this.township = township;
	}
	public Recruiter getEntryBy() {
		return entryBy;
	}
	public void setEntryBy(Recruiter entryBy) {
		this.entryBy = entryBy;
	}
	public LocalDate getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}
	public Recruiter getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Recruiter modifyBy) {
		this.modifyBy = modifyBy;
	}
	public LocalDate getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(LocalDate modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Boolean getIsHot() {
		return isHot;
	}
	public void setIsHot(Boolean isHot) {
		this.isHot = isHot;
	}
	
	


}
