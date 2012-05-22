package com.tyland.domain;

import java.util.List;

public class Menu {
	private Integer id;
	private String name;
	private List<MenuItem> menuItemSet;
	private boolean enabled;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public List<MenuItem> getMenuItemSet() {
		return menuItemSet;
	}
	public void setMenuItemSet(List<MenuItem> menuItemSet) {
		this.menuItemSet = menuItemSet;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	
}
