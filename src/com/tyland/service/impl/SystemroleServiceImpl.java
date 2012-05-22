package com.tyland.service.impl;

import java.util.List;

import javax.sound.midi.SysexMessage;

import com.tyland.dao.SystemroleDao;
import com.tyland.domain.ProductType;
import com.tyland.domain.SystemRole;
import com.tyland.service.SystemroleService;

public class SystemroleServiceImpl implements SystemroleService{
	private SystemroleDao roleDao;

	public void setRoleDao(SystemroleDao roleDao) {
		this.roleDao = roleDao;
	}
	
	public List<SystemRole> query(SystemRole systemrole){
		List<SystemRole> list = roleDao.query(systemrole);
		return list;
	}
	
	public void add(SystemRole systemrole){
		roleDao.add(systemrole);
		
	}

	public void delete(int id) {
		roleDao.delete(id);
		
	}

	public void update(SystemRole systemrole) {
		roleDao.update(systemrole);
		
	}

	public SystemRole queryById(int id) {
	
	 return  roleDao.queryById(id);
	}

}
