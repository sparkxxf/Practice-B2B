package com.tyland.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Iterator;
import com.tyland.common.CommonService;
import com.tyland.domain.MenuItem;
import com.tyland.domain.SystemRole;

public class RoleAssignFuncsAction {
	
	private CommonService commonSer;
	private List roleList;
	private List hasnotAssignFuncsList = new ArrayList<MenuItem>();
	private Set assignedFuncs =new HashSet();
	private SystemRole role;
	private String assignedFuncsId;
	public String getAssignedFuncsId() {
		return assignedFuncsId;
	}

	public void setAssignedFuncsId(String assignedFuncsId) {
		this.assignedFuncsId = assignedFuncsId;
	}

	public Set getAssignedFuncs() {
		return assignedFuncs;
	}

	public void setRoleList(List roleList) {
		this.roleList = roleList;
	}

	public void setHasnotAssignFuncsList(List hasnotAssignFuncsList) {
		this.hasnotAssignFuncsList = hasnotAssignFuncsList;
	}


	
	public SystemRole getRole() {
		return role;
	}
	
	public void setAssignedFuncs(Set assignedFuncs) {
		this.assignedFuncs = assignedFuncs;
	}

	public void setRole(SystemRole role) {
		this.role = role;
	}
	public List getRoleList() {
		return roleList;
	}
	public List getHasnotAssignFuncsList() {
		return hasnotAssignFuncsList;
	}

	
	public CommonService getCommonSer() {
		return commonSer;
	}
	public void setCommonSer(CommonService commonSer) {
		this.commonSer = commonSer;
	}
	
	public String prepareQuery() {
		getFuncs(null);
		return "success";
	}
	
	public String reFindBySystemRoleId () {
		getFuncs(role);
		return "success";
	}
	
	
	private void getFuncs(SystemRole selectedRole){
		roleList=commonSer.queryAll(SystemRole.class);
		List allMenuItems = commonSer.queryAll(MenuItem.class);
		List<MenuItem> orderfuncs = new ArrayList<MenuItem>();
		List<MenuItem> systemfuncs = new ArrayList<MenuItem>();
		for(int i = 0;i<allMenuItems.size();i++){
			
			MenuItem mitem = (MenuItem)allMenuItems.get(i);
			if(mitem.getId().intValue()>10){
				orderfuncs.add(mitem);
			}else{ 
				systemfuncs.add(mitem);	
			}	
		}
		if(selectedRole == null){
			role = (SystemRole) roleList.get(0);
		}else{
			role = (SystemRole) commonSer.queryById(SystemRole.class, role.getId());
		}
		assignedFuncs = role.getMenuItemSet();//已经分配角色的功能
		//以下计算未分配给角色的功能
		if(role.getId().longValue() == 1l){//企业客户的id为1
			Iterator<MenuItem> itAll =  orderfuncs.iterator();
			while( itAll.hasNext()){
				MenuItem allOfOne = (MenuItem)itAll.next();
				Iterator itAssigned = assignedFuncs.iterator();
				while(itAssigned.hasNext()){
					MenuItem assignedOfOne = (MenuItem) itAssigned.next();
					if(allOfOne.getId().equals(assignedOfOne.getId())){
						itAll.remove();
					}
				}
				
			}
			hasnotAssignFuncsList = orderfuncs;
		}else{//非企业客户
			Iterator itAll =  systemfuncs.iterator();
			while( itAll.hasNext()){
				MenuItem allOfOne = (MenuItem)itAll.next();
				Iterator itAssigned = assignedFuncs.iterator();
				while(itAssigned.hasNext()){
					MenuItem assignedOfOne = (MenuItem) itAssigned.next();
					if(allOfOne.getId().equals(assignedOfOne.getId())){
						itAll.remove();
					}
				}
				
			}
			hasnotAssignFuncsList = systemfuncs;
		}
			
	}
	
	
	public String saveRoleFuncs() {
		Set<MenuItem> funcsSet = new HashSet<MenuItem>();
		role = (SystemRole)commonSer.queryById(SystemRole.class, role.getId());
		
		if (assignedFuncsId != null && !assignedFuncsId.trim().equals("")) {
			String[] arrId = assignedFuncsId.split("\\,");
			for (int i = 0; i<arrId.length; i++) {
				String id = arrId[i];
				MenuItem r = new MenuItem();
				r.setId(new Integer(id));
				funcsSet.add(r);
			}
			
			role.setMenuItemSet(funcsSet);
			
		} else {
			role.setMenuItemSet(funcsSet);
		}
		commonSer.update(role);
		getFuncs(null);
		return "success";
	}
}
