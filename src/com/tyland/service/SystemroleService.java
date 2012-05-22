package com.tyland.service;

import java.util.List;

import com.tyland.domain.ProductType;
import com.tyland.domain.SystemRole;

public interface SystemroleService {
	List<SystemRole> query(SystemRole systemrole);
	void add(SystemRole systemrole);
	void delete(int id);
	void update(SystemRole systemrole);
	SystemRole queryById(int id);

}
