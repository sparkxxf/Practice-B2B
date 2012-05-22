package com.tyland.service.impl;

import java.util.List;

import sun.management.resources.agent;

import com.tyland.dao.AgentTypeDao;
import com.tyland.domain.Agent;
import com.tyland.service.AgentTypeService;


public class AgentTypeServiceImpl implements AgentTypeService {

	private AgentTypeDao atypeDao;

	public void setAtypeDao(AgentTypeDao atypeDao) {
		this.atypeDao = atypeDao;
	}

	public List<Agent> queryAll() {
		return atypeDao.queryAll();
		
	}

	public List<Agent> query(Agent agentType) {
		List<Agent> list = atypeDao.query(agentType);
		return list;
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		atypeDao.delete(id);
		
	}
	
	
	
	
	public void add(Agent agentType) {
		atypeDao.add(agentType);
	}
	
	
	
}
