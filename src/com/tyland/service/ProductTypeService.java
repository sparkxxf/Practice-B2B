package com.tyland.service;

import java.util.List;

import com.tyland.domain.ProductType;

public interface ProductTypeService {
	List<ProductType> queryAll();
	List<ProductType> query(ProductType productType);
	void  add(ProductType productType);
	ProductType queryById(int id);
	void update(ProductType productType);
	void delete(int id);
	
}
