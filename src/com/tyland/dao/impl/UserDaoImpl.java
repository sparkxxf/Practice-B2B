package com.tyland.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tyland.dao.UserDao;
import com.tyland.domain.Agent;
import com.tyland.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	public List<User> queryAll() {
		
		return this.getHibernateTemplate().find("from User");
		
	}
	
	
	public List<User> query(User user) {
		List list=new ArrayList();
 		String hql="from User u where 1=1";
		
		if (user != null) {
			Integer type = user.getType();
			String userName = user.getUserName();
			String realName = user.getRealName();
			Agent agent = user.getAgent();
			
			if (type != -1) {
				hql += " and u.type=?";
				list.add(type);
			}
			
			if (userName != null && !userName.trim().equals("")) {
			
				hql += " and u.userName=?";
				list.add(userName);
			}
			
			
			if (realName  != null && !realName .trim().equals("")) {
				
				hql += " and u.realName =?";
				list.add(realName );
			}
			

			if (null != agent){
				if(null != agent.getId() && agent.getId().intValue()!=0) {
					hql += " and u.agent.id=?";
					list.add(agent.getId());
				}
			}
		}
		hql += " order by u.id desc";
		Object[] objs = list.toArray();
		
		List resultList = this.getHibernateTemplate().find(hql, objs);
		return resultList;
	}
	public void add(User user) {
		this.getHibernateTemplate().save(user);
		
		
	}


	public void update(User user) {
		this.getHibernateTemplate().update(user);
		
	}


	public User queryById(int id) {
		// TODO Auto-generated method stub
		return (User)this.getHibernateTemplate().get(User.class, id);
	}

	
	public void delete(int id) {

		User user = new User();
		user.setId(id);
		this.getHibernateTemplate().delete(user);

	}
	
	public List queryAllManager(){
		// 查询所有大客户经理
		String hql = "from User u where u.type=1 order by u.id desc ";
		List resultList = this.getHibernateTemplate().find(hql);
		return resultList;
	}
	
 	public List queryManagerByAgentAndManager(int agentId, int managerId){
 		String hql = "from User u where u.type=1 and u.management_agent!=null";
 		List param = new ArrayList();
 		if (agentId != 0){
 			hql += " and u.management_agent.id=?";
 			param.add(agentId);
 		}
 		if (managerId != 0){
 			hql += " and u.id=?";
 			param.add(managerId);
 		}
 		List resultList = this.getHibernateTemplate().find(hql, param.toArray());
 		return resultList;
 	}
	
 	public int quertApprovalManagerByAgent(int agentId){
 		String hql = "select count(*) from User u where u.type=1 and u.management_agent!=null and u.management_agent.id=? and u.enabled_approval=?";
 		List param = new ArrayList();
 		param.add(agentId);
 		param.add(1);
 		List list = this.getHibernateTemplate().find(hql, param.toArray());
 		return ((Integer)list.get(0)).intValue();
 	}

	public List findAssignedRole(User user) {
		String hql = "from User u where u.id= "+ user.getId().intValue();
		List resultList = this.getHibernateTemplate().find(hql);
		return resultList;
	}


	public User login(String userName, String password) {
		String hql = "from User u where u.userName=? and u.password=?";
		List param = new ArrayList();
		param.add(userName);
		param.add(password);
		List list =  this.getHibernateTemplate().find(hql,param.toArray());
		if (list.size() > 0) {
			return (User)list.get(0);
		} else {
			return null;
		}
	}

	
	public List queryAllAgentUser() {
		String hql = "from User u where u.type=0";
		
		
		List resultList = this.getHibernateTemplate().find(hql);
		return resultList;
	}
	
	public List queryAgentUserByAgentId(int agentId) {
		String hql = "from User u where u.type=0 and u.agent.id="+agentId;
		
		List resultList = this.getHibernateTemplate().find(hql);
		return resultList;
	}


	public int checkName(User user) {
		
			String hql = "from User u where u.userName="+"'"+user.getUserName()+"'";
			List resultList = this.getHibernateTemplate().find(hql);
			if(resultList.size()>0)
			return resultList.size();
			else return 0;
	}
}
