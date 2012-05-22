package com.tyland.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import com.tyland.common.CommonService;
import com.tyland.domain.SystemRole;
import com.tyland.domain.User;

public class UserAssignRoleAction {
	private CommonService commonSer;
	private List userList;
	private List hasNotAssignRoleList = new ArrayList();;
	private Set assignedRoleSet= new HashSet();
	private User user;
	private String assignedRoleIds;
	private String message;

	public Set getAssignedRoleSet() {
		return assignedRoleSet;
	}
	public String getAssignedRoleIds() {
		return assignedRoleIds;
	}
	public void setAssignedRoleIds(String assignedRoleIds) {
		this.assignedRoleIds = assignedRoleIds;
	}
	public CommonService getCommonSer() {
		return commonSer;
	}
	public void setCommonSer(CommonService commonSer) {
		this.commonSer = commonSer;
	}
	public List getUserList() {
		return userList;
	}
	public void setUserList(List userList) {
		this.userList = userList;
	}
	public List getHasNotAssignRoleList() {
		return hasNotAssignRoleList;
	}
	public void setHasNotAssignRoleList(List hasNotAssignRoleList) {
		this.hasNotAssignRoleList = hasNotAssignRoleList;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setAssignedRoleSet(Set assignedRoleSet) {
		this.assignedRoleSet = assignedRoleSet;
	}

	
	public String prepareQuery()
	{
		getRoles(null);
		return "success";
	}
	
	
	public String reFindByUserId () {
		getRoles(user);
		System.out.println(assignedRoleSet.size());
		System.out.println(hasNotAssignRoleList.size());
		return "success";
	}
	
	
	
	private void getRoles(User selectedUser) {	
		try {	
		userList = commonSer.queryAll(User.class);
			//系统中全部的用户
			
			//系统中全部的角色
			List allRoles = commonSer.queryAll(SystemRole.class);
			
			if (userList != null && userList.size() > 0) {
				if (selectedUser == null) {
					user = (User) userList.get(0);
				} else {
					user = (User)commonSer.queryById(User.class, user.getId());
				}
			
				assignedRoleSet = user.getRoles();
				System.out.println(assignedRoleSet.size());
				
				int type = user.getType().intValue();
				
				
				if (type == 0 ) {
					//大客户
					if (assignedRoleSet.isEmpty()) {
						
						SystemRole agentAgent = (SystemRole)commonSer.queryById(SystemRole.class, 1);
						hasNotAssignRoleList.add(agentAgent);//当还未为大户户分配角色时，把企业客户角色放入未分配的角色列表中
					} else {
						
					}
				} else {
					//大客户经理
					if (assignedRoleSet.size() > 0) {
						
						//把所有角色视为未分配的
						hasNotAssignRoleList.addAll(allRoles);
						
						Iterator itHasNot = hasNotAssignRoleList.iterator();
						while (itHasNot.hasNext()) {
							SystemRole r = (SystemRole)itHasNot.next();
							if (r.getId().intValue() == 1) {
								itHasNot.remove();
							}
						}
					
						Iterator it = assignedRoleSet.iterator();
						while (it.hasNext()) {
							SystemRole r_has_assin = (SystemRole)it.next();
							Iterator it2 = hasNotAssignRoleList.iterator();
							while (it2.hasNext()) {
								SystemRole r_not_assign = (SystemRole)it2.next();
								if (r_not_assign.getId().intValue() == r_has_assin.getId().intValue()) {
									it2.remove();
								}
							}
							
						}
					} else {
						for (int i = 0; i < allRoles.size(); i++) {
							SystemRole oneOfAll = (SystemRole) allRoles.get(i);
							if (oneOfAll.getId().intValue()!= 1) {
								hasNotAssignRoleList.add(oneOfAll);
							}
						}
					}
							
				}
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
	
	}
	
	
	public String saveUserRoles() {
		Set<SystemRole> rolsSet = new HashSet<SystemRole>();
		user = (User)commonSer.queryById(User.class, user.getId());
		
		if (assignedRoleIds != null && !assignedRoleIds.trim().equals("")) {
			String[] arrId = assignedRoleIds.split("\\,");
			for (int i = 0; i<arrId.length; i++) {
				String id = arrId[i];
				SystemRole r = new SystemRole();
				r.setId(new Integer(id));
				rolsSet.add(r);
			}
			
			user.setRoles(rolsSet);
			
		} else {
			user.setRoles(rolsSet);
		}
		commonSer.update(user);
		
		message = "/b2b/userrole/userAssignRoleAction_prepareQuery";
		return "add_success";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
