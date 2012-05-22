/**
 * 
 * 2012/03/20
 * wangshanzeng
 *实现接口ProductTypeDao.java
 * 
 * 
 * 
 */



package com.tyland.dao.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tyland.dao.ProductTypeDao;
import com.tyland.domain.ProductType;

public class ProductTypeDaoImpl extends HibernateDaoSupport implements ProductTypeDao{
	 
	public List<ProductType> query(ProductType productType){
		
		List list = new ArrayList();
		String hql="from ProductType pt where 1=1";
		
		if(productType != null){
			
			String code = productType.getCode();
			String name = productType.getName();
			
			if(code != null && !code.trim().equals("")){
				hql+=" and pt.code=?";
				list.add(code);
				
			}
			
			if (name != null && !name.trim().equals("")){
				hql+=" and pt.name=?";
				list.add(name);
				
			}
			
		}
		hql+=" order by pt.id desc";
		
		return this.getHibernateTemplate().find(hql, list.toArray());
	}
	 
	public List<ProductType> queryAll(){
		
		return this.getHibernateTemplate().find("from ProductType");
	}
	
	
	
	
	public void add(ProductType productType){
		 this.getHibernateTemplate().save(productType);
		 int id = productType.getId();
		
		 if(id<10){
			 productType.setCode("C"+"00"+id);
		 }
		 else if(id<100){
			 productType.setCode("C"+"0"+id);
		 }
		 else{
			 productType.setCode("C"+id);
		 }
		 
		 this.getHibernateTemplate().update(productType);
	}

	
	
	
	public ProductType queryById(int id) { 
		
		return (ProductType)this.getHibernateTemplate().get(ProductType.class, id);
		
	}

	
	
	public void update(ProductType productType) {
			this.getHibernateTemplate().update(productType);
		
	}

	public void delete(int id) {
		ProductType pt = new ProductType();
		pt.setId(id);
		this.getHibernateTemplate().delete(pt);
		
	}
	
}
