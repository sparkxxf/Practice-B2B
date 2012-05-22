package com.tyland.service.impl;

import java.util.List;

import com.tyland.dao.ProCategoryDao;
import com.tyland.domain.ProductCategory;
import com.tyland.service.ProCategoryService;

public class ProCategoryServiceImpl implements ProCategoryService {
	private ProCategoryDao proCategoryDao;
	
	public ProCategoryDao getProCategoryDao() {
		return proCategoryDao;
	}

	public void setProCategoryDao(ProCategoryDao proCategoryDao) {
		this.proCategoryDao = proCategoryDao;
	}

	public List query(ProductCategory proCategory) {
		return proCategoryDao.query(proCategory);
	}

	public void delete(int id) {
		proCategoryDao.delete(id);
	}

	public ProductCategory queryById(int id) {
		return proCategoryDao.queryById(id);
	}

	public void update(ProductCategory productCategory) {
		proCategoryDao.update(productCategory);
	}

}
