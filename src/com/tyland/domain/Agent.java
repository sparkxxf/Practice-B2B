package com.tyland.domain;

import java.util.Set;

public class Agent {
	
	private Integer id;
	private String code;
	private String name;
	private Integer size;
	private String legal;
	private String tel;
	private String fax;
	private String zip;
	private String address;
	private Set<User> ManagerSet;
	private User approvalManager;
	private Set<ProductCategory> PublishProductSet;
	
	
	
	
	public Set<User> getManagerSet() {
		return ManagerSet;
	}
	public void setManagerSet(Set<User> managerSet) {
		ManagerSet = managerSet;
	}
	public User getApprovalManager() {
		return approvalManager;
	}
	public void setApprovalManager(User approvalManager) {
		this.approvalManager = approvalManager;
	}
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getLegal() {
		return legal;
	}
	public void setLegal(String legal) {
		this.legal = legal;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public void setPublishProductSet(Set<ProductCategory> publishProductSet) {
		PublishProductSet = publishProductSet;
	}
	public Set<ProductCategory> getPublishProductSet() {
		return PublishProductSet;
	}
	
	
}
