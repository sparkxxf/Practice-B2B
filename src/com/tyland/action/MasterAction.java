package com.tyland.action;

import java.util.List;

import com.tyland.common.CommonService;
import com.tyland.domain.Agent;
import com.tyland.domain.User;
import com.tyland.service.UserService;

public class MasterAction {

	private CommonService commonService;
	private UserService userService;
	private User user;
	private Boolean afterQuery;
	private List allManagerList;
	private List allAgentList;
	private Integer userId;
	private String message;
	private List resultList;
	
	public List getResultList() {
		return resultList;
	}
	public void setResultList(List resultList) {
		this.resultList = resultList;
	}
	public List getAllManagerList() {
		return allManagerList;
	}
	public List getAllAgentList() {
		return allAgentList;
	}
	public void setAllManagerList(List allManagerList) {
		this.allManagerList = allManagerList;
	}
	public void setAllAgentList(List allAgentList) {
		this.allAgentList = allAgentList;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setAfterQuery(Boolean afterQuery) {
		this.afterQuery = afterQuery;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public CommonService getCommonService() {
		return commonService;
	}
	public UserService getUserService() {
		return userService;
	}
	public User getUser() {
		return user;
	}
	public Boolean getAfterQuery() {
		return afterQuery;
	}
	
	public String prepareQuery(){
		allManagerList = userService.queryAllManager();
		allAgentList = commonService.queryAll(Agent.class);
		return "success";
	}
	
	 public String query() {
			int agentId=0;
			int managerId=0;
			if (user != null) {
				if (user.getId() != null) {
					managerId = user.getId();
				}
				if (user.getManagement_agent() != null && user.getManagement_agent().getId()!= null) {
					agentId = user.getManagement_agent().getId();
				}
			}
			resultList = userService.queryManagerByAgentAndManager(agentId,managerId);
			allManagerList = userService.queryAllManager();
			allAgentList = commonService.queryAll(Agent.class);
			afterQuery = true;
			return "success";
		}
	
	
	public String preAdd(){
		allManagerList = userService.queryAllManager();
		allAgentList = commonService.queryAll(Agent.class);
		return "toAdd";
	}
	
	public String add(){
		allManagerList = userService.queryAllManager();
		allAgentList = commonService.queryAll(Agent.class);
		User user_db = (User) commonService.queryById(User.class, user.getId());
		if (user_db.getManagement_agent() != null){
			
			allManagerList = userService.queryAllManager();
			allAgentList = commonService.queryAll(Agent.class);
			return "toAdd";
		}else {
			int count = userService.quertApprovalManagerByAgent(user.getManagement_agent().getId());
			if (count > 0 && user.getEnabled_approval().intValue() == 1){
				
				allManagerList = userService.queryAllManager();
				allAgentList = commonService.queryAll(Agent.class);
				return "toAdd";
			}
			user_db.setManagement_agent(user.getManagement_agent());
			user_db.setEnabled_approval(user.getEnabled_approval());
			commonService.update(user_db);
			return "success";
		}
	}
	
	public String delete(){
		user = (User) commonService.queryById(User.class, userId);
		user.setManagement_agent(null);
		commonService.update(user);
		return prepareQuery();
	}
}
