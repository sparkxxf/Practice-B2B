package com.tyland.common;

import java.io.Serializable;
import java.util.List;

public class CommonServiceImpl implements CommonService{
	
	private CommonDao commonDao;
	
	
	
	public void setCommonDao(CommonDao commonDao) {
		this.commonDao = commonDao;
	}

	public void add(Object obj) {
		commonDao.add(obj);
		
	}

	public void delete(Object obj) {
		commonDao.delete(obj);
		
	}

	public List<Object> queryAll(Class cls) {
		
		return commonDao.queryAll(cls);
	}

	public Object queryById(Class cls, Serializable id) {
		// TODO Auto-generated method stub
		return commonDao.queryById(cls, id);
	}

	public void update(Object obj) {
		// TODO Auto-generated method stub
		commonDao.update(obj);
	}

}
