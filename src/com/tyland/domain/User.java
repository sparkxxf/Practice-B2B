package com.tyland.domain;

import java.util.Date;
import java.util.Set;

import javax.management.relation.Role;



public class User {
	private Integer id;
	private Integer type;
	private String userName;
	private String password;
	private String realName;
	private Date   dead_line;
	private String email;
	private String tel;
	private String remark;
	private Agent  agent;
	
	private Integer enabled_approval; //0 :: No ; 1 :: Yes
	private Agent management_agent;
	
	private Set<SystemRole> roles;
	

	public Set<SystemRole> getRoles() {
		return roles;
	}
	public void setRoles(Set<SystemRole> roles) {
		this.roles = roles;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Date getDead_line() {
		return dead_line;
	}
	public void setDead_line(Date deadLine) {
		dead_line = deadLine;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public void setEnabled_approval(Integer enabled_approval) {
		this.enabled_approval = enabled_approval;
	}
	public Integer getEnabled_approval() {
		return enabled_approval;
	}
	public void setManagement_agent(Agent management_agent) {
		this.management_agent = management_agent;
	}
	public Agent getManagement_agent() {
		return management_agent;
	}

}
