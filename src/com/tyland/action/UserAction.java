package com.tyland.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;


import com.opensymphony.xwork2.ActionSupport;
import com.tyland.common.CommonService;
import com.tyland.domain.Agent;
import com.tyland.domain.User;
import com.tyland.service.UserService;

public class UserAction extends ActionSupport implements ServletResponseAware{

	private User user;
	private List agentList;
	private List<User> resultList;
	private Boolean afterQuery;
	private UserService userService;
	private CommonService commonService;
	private Integer types;
	private HttpServletResponse response;
	
	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	public CommonService getCommonService() {
		return commonService;
	}
	
	public List getAgentList() {
		return agentList;
	}

	public void setTypes(Integer types) {
		this.types = types;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getResultList() {
		return resultList;
	}

	public Boolean getAfterQuery() {
		return afterQuery;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public UserService getUserService() {
		return userService;
	}

	public Integer getTypes() {
		return types;
	}

	public void setAgentList(List agentList) {
		this.agentList = agentList;
	}

	public void setResultList(List<User> resultList) {
		this.resultList = resultList;
	}

	public void setAfterQuery(Boolean afterQuery) {
		this.afterQuery = afterQuery;
	}

	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}

	public String prepareQuery() {
		agentList = commonService.queryAll(Agent.class);
		user = null;
		return "success";
	}

	public String query() {
		agentList = commonService.queryAll(Agent.class);
		resultList = userService.query(user);
		afterQuery = true;
		user = null;
		return "success";
	}

	public String preAdd() {
		agentList = commonService.queryAll(Agent.class);
		return "preAdd";
	}

	public String add() {
		user.setPassword("1f82c942befda29b6ed487a51da199f78fce7f05");
		userService.add(user);
		agentList = commonService.queryAll(Agent.class);
		user = null;
		return "success";
	}

	public String preUpdate() {

		agentList = commonService.queryAll(Agent.class);
		user = userService.queryById(types);
		return "preupdate";
	}

	public String update() {
		agentList = commonService.queryAll(Agent.class);
		User user1 = userService.queryById(user.getId()); 
		user.setPassword(user1.getPassword());
		user.setEnabled_approval(user1.getEnabled_approval());
		user.setAgent(user1.getAgent());
		user.setManagement_agent(user1.getManagement_agent());
		user.setRoles(user1.getRoles());
		userService.update(user);
	
		return "success";
	}

	public String delete() {
		userService.delete(types);
		return query();
	}
	
	public String checkName(){
		int userCount = userService.checkName(user);
		PrintWriter out = null;
		try{
			out = this.response.getWriter();
		}catch (IOException e) {
			e.printStackTrace();
		}
		if (userCount > 0){
			out.print(true);
		}else{
			out.print(false);
		}
		return null;
	}


}
