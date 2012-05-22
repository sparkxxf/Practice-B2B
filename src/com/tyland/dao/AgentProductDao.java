package com.tyland.dao;

import java.util.List;

import com.tyland.domain.ProductCategory;

public interface AgentProductDao {

	List<ProductCategory> querry(int id);
	void add(int pid,int aid);
	List querypublish(int pid,int aid);
	
	
}
