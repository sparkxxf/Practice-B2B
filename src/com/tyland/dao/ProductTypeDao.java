/**
 * 2012/2/20
 * wangshaozhen
 * 
 * 
 * 
 * 
 */








package com.tyland.dao;

import java.util.List;

import com.tyland.domain.ProductType;

public interface ProductTypeDao { 
	List<ProductType> queryAll();
	List<ProductType> query(ProductType productType);
	void add(ProductType productType);
	ProductType queryById(int id);
	void update(ProductType productType);
	void delete(int id);
	
}
