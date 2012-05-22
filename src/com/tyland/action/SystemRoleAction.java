package com.tyland.action;

import java.util.List;

import com.tyland.domain.SystemRole;

import com.tyland.service.SystemroleService;

public class SystemRoleAction {
	private SystemRole systemrole;
	private SystemroleService roleService;
	private List<SystemRole> ruesultList;
	private boolean afterQuery; 
	private String types;

	public void setTypes(String types) {
		this.types = types;
	}

	public SystemRole getSystemrole() {
		return systemrole;
	}

	public void setSystemrole(SystemRole systemrole) {
		this.systemrole = systemrole;
	}

	public List<SystemRole> getRuesultList() {
		return ruesultList;
	}

	public boolean isAfterQuery() {
		return afterQuery;
	}

	public void setRoleService(SystemroleService roleService) {
		this.roleService = roleService;
	}
	
	public String query(){
		ruesultList=roleService.query(systemrole);
		afterQuery = true;
		systemrole = null;
		return "success";
	}
	
	public String prepareQuery(){
		return "success";
    }
	
	public String preAdd(){
		return "toAdd";
	}
	
	public String add(){
		roleService.add(systemrole);
		systemrole = null;
		query();
		return "add_success";
	}
	
	public String delete(){
		roleService.delete(Integer.parseInt(types));
		return query();
	}
	
public String preUpdate(){
		
	systemrole = roleService.queryById(Integer.parseInt(types));
		return "preupdate";
	}

public String update(){
	roleService.update(systemrole);
	systemrole = null;
	return "success";
}

}
