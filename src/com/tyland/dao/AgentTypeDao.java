package com.tyland.dao;

import java.util.List;

import com.tyland.domain.Agent;

public interface AgentTypeDao {
	List<Agent> queryAll();
	List<Agent> query(Agent agentType);
	void delete(int id);
	void add(Agent agentType);
}
