package com.tyland.domain;


public class OrderItem{
	public Integer id;
	public Order order;
	public ProductCategory product;
	public Integer number;
	public String desc;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}

	public ProductCategory getProduct() {
		return product;
	}
	public void setProduct(ProductCategory product) {
		this.product = product;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
