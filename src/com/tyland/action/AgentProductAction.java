package com.tyland.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.mapping.Array;

import com.tyland.common.CommonService;
import com.tyland.domain.Agent;
import com.tyland.domain.ProductCategory;
import com.tyland.domain.ProductType;
import com.tyland.service.AgentProductService;
import com.tyland.service.ProCategoryService;

public class AgentProductAction {
	
	private List  allproductType;
	private ProductCategory  proCategory;
	private List  allagent;
	private CommonService commonSer;
	private List  resultList;
	private AgentProductService agentProductSer;
	private Agent agent;
	private Integer types;
	private String selectedIds;
	private String assignedProductIds;
	
	
	public String getAssignedProductIds() {
		return assignedProductIds;
	}

	public void setAssignedProductIds(String assignedProductIds) {
		this.assignedProductIds = assignedProductIds;
	}
	
	public String getSelectedIds() {
		return selectedIds;
	}


	public void setSelectedIds(String selectedIds) {
		this.selectedIds = selectedIds;
	}


	public void setTypes(Integer types) {
		this.types = types;
	}


	public void setAgentProductSer(AgentProductService agentProductSer) {
		this.agentProductSer = agentProductSer;
	}
	
	
	private Boolean afterQuery;


	public Agent getAgent() {
		return agent;
	}


	public void setAgent(Agent agent) {
		this.agent = agent;
	}


	public Boolean getAfterQuery() {
		return afterQuery;
	}


	public void setAfterQuery(Boolean afterQuery) {
		this.afterQuery = afterQuery;
	}


	public ProductCategory getProCategory() {
		return proCategory;
	}



	public void setProCategory(ProductCategory proCategory) {
		this.proCategory = proCategory;
	}


	public List getResultList() {
		return resultList;
	}


	public List getAllproductType() {
		return allproductType;
	}


	public List getAllagent() {
		return allagent;
	}



	public void setCommonSer(CommonService commonSer) {
		this.commonSer = commonSer;
	}




	public String prepareQuery(){
		
		allproductType = commonSer.queryAll(ProductType.class);
		allagent = commonSer.queryAll(Agent.class);
		System.out.println(((ProductType)allproductType.get(0)).getId());
		resultList = agentProductSer.querry(((ProductType)allproductType.get(0)).getId());
		afterQuery = true;
		return "success";
	}
	
	
	public String query(){
		allproductType = commonSer.queryAll(ProductType.class);
		allagent = commonSer.queryAll(Agent.class);
		resultList = agentProductSer.querry(proCategory.getProductType().getId());
		afterQuery = true;
		return "success";
	}
	
	
	public String querypublish(){
		
		allproductType = commonSer.queryAll(ProductType.class);
		allagent = commonSer.queryAll(Agent.class);
		resultList =agentProductSer.querypublish(proCategory.getProductType().getId(), agent.getId());
		afterQuery=true;
		return "querypublish";
	}
	
	
	
	public String add(){
		allproductType = commonSer.queryAll(ProductType.class);
		allagent = commonSer.queryAll(Agent.class);
		agent = (Agent) commonSer.queryById(Agent.class, agent.getId());
		Set<ProductCategory> allPublished = agent.getPublishProductSet();
		String[] selectedInPage = selectedIds.split("\\,");
			
		for (String selectedId : selectedInPage) {
			ProductCategory new_pro = new ProductCategory();
			new_pro.setId(new Integer(selectedId));
			if (!allPublished.contains(new_pro)) {
				allPublished.add(new_pro);
			}
			
		}
			
		commonSer.update(agent);
		return querypublish();
	
	}
	
	
	public String delete() {

		agent = (Agent) commonSer.queryById(Agent.class, agent.getId());
		Set<ProductCategory> productSet = new HashSet<ProductCategory>();
		productSet = agent.getPublishProductSet();

		if (assignedProductIds != null && !assignedProductIds.trim().equals("")) {
			String[] arrId = assignedProductIds.split("\\,");
			for (int i = 0; i < arrId.length; i++) {
				String id = arrId[i];
				ProductCategory p = new ProductCategory();
				p.setId(new Integer(id));
				productSet.remove(p);
			}
			agent.setPublishProductSet(productSet);
		}

		commonSer.update(agent);

		allproductType = commonSer.queryAll(ProductType.class);
		return querypublish();

	}
	
	
}
