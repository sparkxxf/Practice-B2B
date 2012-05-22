package com.tyland.domain;

import java.util.Set;

public class SystemRole {
	private Integer id;
	private String rolename;
	private String roledesc;
	private Set<MenuItem> menuItemSet;

	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getRoledesc() {
		return roledesc;
	}
	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}
	public Set<MenuItem> getMenuItemSet() {
		return menuItemSet;
	}
	public void setMenuItemSet(Set<MenuItem> menuItemSet) {
		this.menuItemSet = menuItemSet;
	}
	

}
