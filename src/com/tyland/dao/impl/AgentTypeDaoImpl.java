package com.tyland.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tyland.dao.AgentTypeDao;
import com.tyland.domain.Agent;
import com.tyland.domain.ProductType;

public class AgentTypeDaoImpl extends HibernateDaoSupport implements AgentTypeDao{

	public List<Agent> queryAll() {
		return this.getHibernateTemplate().find("from Agent");
		
	}

	public List<Agent> query(Agent agentType) {
		
		List list=new ArrayList();
		String hql="from Agent ag where 1=1";
		
	
		
		if (agentType != null) {
			Integer size = agentType.getSize();
			//Integer id = agentType.getId();
			
			String name = agentType.getName();
			if (size != -1) {
				hql += " and ag.size=?";
				list.add(size);
			}
			
			if (name != null && !name.trim().equals("")) {
			//if (id != -1) {
				hql += " and ag.name=?";
				list.add(name);
			}
		}
		
		hql += " order by ag.id desc";
		Object[] objs = list.toArray();
		
		List resultList = this.getHibernateTemplate().find(hql, objs);
		return resultList;
		
		
	}
		
		
		
	
		
	public void delete(int id) {
		
		Agent ag = new Agent();
		ag.setId(id);
		this.getHibernateTemplate().delete(ag);
		
	
		
	}
	
	
	
	public void add(Agent agentType) {
	
			 this.getHibernateTemplate().save(agentType);
			 int id = agentType.getId();
			 System.out.println(id);
			 if(id<10){
				 agentType.setCode("D"+"00"+id);
			 }
			 else if(id<100){
				 agentType.setCode("D"+"0"+id);
			 }
			 else{
				 agentType.setCode("D"+id);
			 }
			 
		this.getHibernateTemplate().update(agentType);
	
	}
	
	
}
