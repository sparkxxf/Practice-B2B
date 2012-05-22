package com.tyland.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.tyland.domain.ProductType;
import com.tyland.service.ProductTypeService;



public class ProDuctTypeAction extends ActionSupport{
	
	private ProductType productType;
	private ProductTypeService ptypeService;
	private Boolean afterQuery;
	private List<ProductType> ruesultList;
	private Integer types;
	private String message;
	
	


	
	

	public String getMessage() {
		return message;
	}


	public void setTypes(Integer types) {
		this.types = types;
	}


	public List<ProductType> getRuesultList() {
		return ruesultList;
	}


	public Boolean getAfterQuery() {
		return afterQuery;
	}


	public void setPtypeService(ProductTypeService ptypeService) {
		this.ptypeService = ptypeService;
	}

	
	public ProductType getProductType() {
		return productType;
	}
	
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	
	
		/*
		 * 点击查询后执行查询
		 * 
		 */
	public String query(){
		//ruesultList=ptypeService.queryAll();
		ruesultList = ptypeService.query(productType);//经struts-data.xml返回query.jsp
		afterQuery=true;
		System.out.println("Listsize()::"+ruesultList.size());
		return "success";//经struts-data.xml返回query.jsp
	}
	
	
	
	
	/**
	 * 由main.jsp 跳到查询页面
	 * @return
	 */
	
	
	public String prepareQuery(){
		return "success";//经struts-data.xml返回query.jsp
	}
	
	
	/*
	 * 由query.jsp跳到add.jsp
	 * 
	 * 
	 */
	public String preAdd(){
		productType=null;
		return "preadd";
	}
	
	
	/*
	 * 
	 * 点击add.jsp添加按钮
	 * 
	 */
	public String add(){
		ptypeService.add(productType);
		productType=null;
		return "success";//经struts-data.xml返回query.jsp
	}
	
	
	/*
	 *  由query.jsp跳到updata.jsp
	 * 
	 * 
	 */
	
	public String preUpdate(){
	
		productType = ptypeService.queryById(types);
		return "preupdate";
	}
	
	/*
	 * 
	 * 点击update.jsp添加按钮
	 * 
	 */
	public String update(){
		ptypeService.update(productType);
		productType = null;
		return "success";
	}
	
	public String delete() throws Exception{
		try {
			ptypeService.delete(types);
			
		} catch (Exception e) {
			throw new Exception(this.getText("nav.error.label"));
		}
		
		return query();
	}
	
	
	
}
