package com.tyland.service;

import java.util.List;
import com.tyland.domain.Agent;

public interface AgentTypeService {
	List<Agent> queryAll();
	List<Agent> query(Agent agentType);
	void delete(int id);
	void add(Agent agentType);

}
