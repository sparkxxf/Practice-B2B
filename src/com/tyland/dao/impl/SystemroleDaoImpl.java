package com.tyland.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tyland.dao.SystemroleDao;
import com.tyland.domain.Agent;
import com.tyland.domain.ProductType;
import com.tyland.domain.SystemRole;
import com.tyland.service.SystemroleService;

public class SystemroleDaoImpl extends HibernateDaoSupport  implements SystemroleDao {
	
	public  List<SystemRole> query(SystemRole systemrole){
		
		List list=new ArrayList();
		String hql="from SystemRole s where 1=1";
		
		if (systemrole != null) {

			String orlename = systemrole.getRolename();
			String roledesc = systemrole.getRoledesc();
	
			if (orlename != null && !orlename.trim().equals("")) {
			
				hql += " and s.rolename=?";
				list.add(orlename);
			}
			
			
			if (roledesc  != null && !roledesc .trim().equals("")) {
				
				hql += " and s.roledesc =?";
				list.add(roledesc );
			}
			
		}
		
		hql += " order by s.id desc";
		Object[] objs = list.toArray();
		
		List resultList = this.getHibernateTemplate().find(hql, objs);
		return resultList;
	}
	
	public void add(SystemRole systemrole){
		 this.getHibernateTemplate().save(systemrole);	 
	}

	public void delete(int id) {
		SystemRole pt = new SystemRole();
		pt.setId(id);
		this.getHibernateTemplate().delete(pt);
		
	}

	public void update(SystemRole systemrole) {
		this.getHibernateTemplate().update(systemrole);	
		
	}

	public SystemRole queryById(int id) {
		
		return (SystemRole)this.getHibernateTemplate().get(SystemRole.class, id);
	}



}
