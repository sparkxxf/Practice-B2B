package com.tyland.dao;

import java.util.List;

import com.tyland.domain.SystemRole;
import com.tyland.service.SystemroleService;

public interface SystemroleDao {
	List<SystemRole> query(SystemRole systemrole);
	void add(SystemRole systemrole);
	void delete(int id);
	void update(SystemRole systemrole);
	SystemRole queryById(int id);

}
