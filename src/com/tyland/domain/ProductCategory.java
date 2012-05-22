package com.tyland.domain;

import java.util.Set;

public class ProductCategory {
	private Integer id;         
	private String brand;       //产品品牌
	private String type;       //产品型号 
	private String quan;       //采购单位
	private Integer prize;     //参考价格
	private String desc;       //产品描述
	private String spe;        //技术规格
	private String remark;     //备注
	private ProductType productType;    //产品类别

	private Set<Agent> agentSet;
	
	
	
	
	
	public Set<Agent> getAgentSet() {
		return agentSet;
	}

	public void setAgentSet(Set<Agent> agentSet) {
		this.agentSet = agentSet;
	}

	public void setBrand(String band) {
		this.brand = band;
	}

	public String getBrand() {
		return brand;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQuan() {
		return quan;
	}
	public void setQuan(String quan) {
		this.quan = quan;
	}
	public Integer getPrize() {
		return prize;
	}
	public void setPrize(Integer prize) {
		this.prize = prize;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getSpe() {
		return spe;
	}
	public void setSpe(String spe) {
		this.spe = spe;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRemark() {
		return remark;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	
	
	public boolean equals(Object obj){
		ProductCategory p = (ProductCategory) obj;
		if(p.id.intValue()==this.id.intValue()){
			return true;
		}
		return false;
	}
	
	public int hashCode(){
		return this.id;
	}
	
}
