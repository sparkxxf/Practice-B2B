package com.tyland.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.tyland.domain.Agent;
import com.tyland.domain.ProductType;

import com.tyland.service.AgentTypeService;

public class AgentTypeAction extends ActionSupport{
	private Integer types;
	private Agent agentType;
	private Boolean afterQuery;
	private AgentTypeService atypeService;
	private List agentList;
	
	
	
	
	
	
	public List getAgentList() {
		return agentList;
	}


	public void setTypes(Integer types) {
		this.types = types;
	}

	
	public void setAtypeService(AgentTypeService atypeService) {
		this.atypeService = atypeService;
	}

	private List<Agent> resultList;
	
	
	public Agent getAgentType() {
		return agentType;
	}

	public void setAgentType(Agent agentType) {
		this.agentType = agentType;
	}

	public Boolean getAfterQuery() {
		return afterQuery;
	}

	public List<Agent> getResultList() {
		return resultList;
	}

	
	
	
	
	public String prepareQuery(){
		agentList = atypeService.queryAll();
		query();
		return "success";
	}

	public String query(){
		
		agentList = atypeService.queryAll();
	    resultList = atypeService.query(agentType);
		afterQuery = true;
		return "success";
	}
	
	
	public String delete(){
			System.out.println(types);
		atypeService.delete(types);
			return query();

	}
	
	
	public String preAdd(){
		
		return "preadd";
	}
	
	
	public String add(){

		atypeService.add(agentType);
		agentType = null;

		return "success";
	}
	
	
	
	

}
