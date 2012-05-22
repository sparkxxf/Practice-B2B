package com.tyland.service.impl;

import java.util.List;

import com.tyland.dao.AgentProductDao;
import com.tyland.domain.ProductCategory;
import com.tyland.service.AgentProductService;

public class AgentProductServiceImpl  implements AgentProductService {

	private AgentProductDao agentproductdao;
	public void setAgentproductdao(AgentProductDao agentproductdao) {
		this.agentproductdao = agentproductdao;
	}
	
	

	public List<ProductCategory> querry(int id) {
		
		return agentproductdao.querry(id);
	}



	public void add(int pid, int aid) {
	
		agentproductdao.add(pid, aid);
	}



	public List querypublish(int pid,int aid) {
		
		return agentproductdao.querypublish(pid, aid);
	}
	
}
