package com.tyland.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tyland.dao.ProCategoryDao;
import com.tyland.domain.ProductCategory;
import com.tyland.domain.ProductType;

public class ProCategoryDaoImpl extends HibernateDaoSupport implements ProCategoryDao {

	public List query(ProductCategory proCategory) {
		String hql = "from ProductCategory pc where 1=1";
		List param = new ArrayList();
		
		if ( null != proCategory ) {
			String brand = proCategory.getBrand();
			String type = proCategory.getType();

			if ( brand != null && !brand.trim().equals("") ) {
				hql += " and pc.brand=?";
				param.add(brand);
			}
			
			if ( type != null && !type.trim().equals("")) {
				hql += " and pc.type=?";
				param.add(type);
			}
			if( proCategory.getProductType().getId()!= null && proCategory.getProductType().getId().intValue()!= 0){
				hql += " and pc.productType.id=?";
				param.add(proCategory.getProductType().getId().intValue());
			}
		}
		
		hql += " order by pc.id desc";
		Object[] objs = param.toArray();
		
		List resultList = this.getHibernateTemplate().find(hql, objs);
		return resultList;
	}

	public void delete(int id) {
		ProductCategory pc = new ProductCategory();
		pc.setId(id);
		this.getHibernateTemplate().delete(pc);
	}

	public ProductCategory queryById(int id) {
		return (ProductCategory)this.getHibernateTemplate().get(ProductCategory.class, id);		
	}

	public void update(ProductCategory productCategory) {
	 this.getHibernateTemplate().update(productCategory);
	}


}
