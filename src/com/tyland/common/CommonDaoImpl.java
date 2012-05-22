package com.tyland.common;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CommonDaoImpl extends HibernateDaoSupport implements CommonDao{
	public void add(Object obj) {
		this.getHibernateTemplate().save(obj);
		
	}

	public void delete(Object obj) {
		this.getHibernateTemplate().delete(obj);
		
	}

	public List<Object> queryAll(Class cls) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from " + cls.getSimpleName());
	}

	public Object queryById(Class cls, Serializable id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(cls, id);
	
	}

	public void update(Object obj) {
		this.getHibernateTemplate().update(obj);
		
	}


}
