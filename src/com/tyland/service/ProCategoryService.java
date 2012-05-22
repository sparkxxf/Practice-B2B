package com.tyland.service;

import java.util.List;

import com.tyland.domain.ProductCategory;

public interface ProCategoryService {
	List query(ProductCategory proCategory);
	void delete(int id);
	ProductCategory queryById(int id);
	void update(ProductCategory productCategory);
}
