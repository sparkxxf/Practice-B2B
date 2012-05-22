package com.tyland.common;

import java.io.Serializable;
import java.util.List;

public interface CommonService {
	public void add(Object obj);
	public void delete(Object obj);
	public void update(Object obj);
	public List<Object> queryAll(Class cls);
	public Object queryById(Class cls, Serializable id);

}
