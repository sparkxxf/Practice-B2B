/**
 * 
 * 2012/03/20
 * wangshanzeng
 *实现接口ProductTypeService.java
 * 
 * 
 * 
 */


package com.tyland.service.impl;

import java.util.List;

import com.tyland.dao.ProductTypeDao;
import com.tyland.dao.impl.ProductTypeDaoImpl;
import com.tyland.domain.ProductType;
import com.tyland.service.ProductTypeService;

public class ProductTypeServiceImpl implements ProductTypeService {
	
		private ProductTypeDao ptypeDao;


		public void setPtypeDao(ProductTypeDao ptypeDao) {
			this.ptypeDao = ptypeDao;
		}
		
		public List<ProductType> query(ProductType productType){
			
			List<ProductType> list = ptypeDao.query(productType);
			return list;
		}
		
		
		public List<ProductType> queryAll(){
			List<ProductType> list = ptypeDao.queryAll();
			return list;
		}
		
		public void  add(ProductType productType){
			ptypeDao.add(productType);
		}
		

		public ProductType queryById(int id){
			
			return  ptypeDao.queryById(id);
			
		}

		public void update(ProductType productType) {
			ptypeDao.update(productType);
			
		}

		public void delete(int id) {
			
			ptypeDao.delete(id);
		
		}

		
		
		
}
