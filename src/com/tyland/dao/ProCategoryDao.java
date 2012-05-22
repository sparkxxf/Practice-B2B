package com.tyland.dao;

import java.util.List;

import com.tyland.domain.ProductCategory;

public interface ProCategoryDao {
	List query(ProductCategory proCategory);
	void delete(int id);
	ProductCategory queryById(int id);
	void update(ProductCategory productCategory);
}
