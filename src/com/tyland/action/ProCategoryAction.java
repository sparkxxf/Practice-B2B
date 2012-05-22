package com.tyland.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.tyland.common.CommonService;
import com.tyland.domain.ProductCategory;
import com.tyland.domain.ProductType;
import com.tyland.service.ProCategoryService;

public class ProCategoryAction extends ActionSupport{
	private ProductCategory proCategory;
	private CommonService commonSer;
	private List productTypeList;
	private ProCategoryService proCategorySer;
	private List resultList;
	private Boolean afterQuery;
	private String types;
	private String message;
	
	public CommonService getCommonSer() {
		return commonSer;
	}

	public ProCategoryService getProCategorySer() {
		return proCategorySer;
	}

	public String getTypes() {
		return types;
	}

	public void setProductTypeList(List productTypeList) {
		this.productTypeList = productTypeList;
	}

	public void setAfterQuery(Boolean afterQuery) {
		this.afterQuery = afterQuery;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public List<ProductCategory> getResultList() {
		return resultList;
	}

	public Boolean getAfterQuery() {
		return afterQuery;
	}

	public void setProCategorySer(ProCategoryService proCategorySer) {
		this.proCategorySer = proCategorySer;
	}


	public void setCommonSer(CommonService commonSer) {
		this.commonSer = commonSer;
	}


	public List getProductTypeList() {
		return productTypeList;
	}


	public ProductCategory getProCategory() {
		return proCategory;
	}

	public void setProCategory(ProductCategory proCategory) {
		this.proCategory = proCategory;
	}
	
	public String getMessage() {
		return message;
	}

	
	
	/**
	 * 进入查询页面
	 * @return
	 */
	public String prepareQuery(){
		productTypeList = commonSer.queryAll(ProductType.class);
		/*resultList = commonSer.queryAll(ProductCategory.class);
		afterQuery = true;*/
		return "success";
	}
	
	
	/**
	 * 条件查询
	 * @return
	 */
	public String query(){
		resultList = proCategorySer.query(proCategory);	
		productTypeList = commonSer.queryAll(ProductType.class);
		afterQuery = true;
		return "success";
	}

	/**
	 * 删除产品
	 * @return
	 */
	public String delete() throws Exception{
		try{
			proCategory = (ProductCategory)commonSer.queryById(ProductCategory.class, proCategory.getId());
			this.commonSer.delete(proCategory);
			proCategory = null;
		}catch (Exception e) {
			throw new Exception(this.getText("nav.error.label"));
		}
		message = "/b2b/category/categoryAction_prepareQuery";
		return "add_success";

	}
	
	/**
	 * 更新产品
	 * @return
	 */
	public String preUpdate(){
		proCategory = (ProductCategory)commonSer.queryById(ProductCategory.class, proCategory.getId());
		//proCategory = proCategorySer.queryById(Integer.parseInt(types));
		productTypeList = commonSer.queryAll(ProductType.class);
		return "preUpdate";
	}
	
	public String update(){
		proCategorySer.update(proCategory);
		proCategory = null;
		message = "/b2b/category/categoryAction_prepareQuery";
		return "add_success";
	}
	
	
	/**
	 * 添加产品
	 * @return
	 */
	public String preAdd(){
		productTypeList = commonSer.queryAll(ProductType.class);
		return "preAdd";
	}
	
	public String add(){
		commonSer.add(proCategory);
		proCategory = null;
		message = "/b2b/category/categoryAction_prepareQuery";
		return "add_success";
	}
	
	
}
