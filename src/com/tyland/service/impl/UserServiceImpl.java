package com.tyland.service.impl;

import java.util.List;

import org.hibernate.connection.UserSuppliedConnectionProvider;

import com.tyland.dao.UserDao;
import com.tyland.domain.User;
import com.tyland.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	public List<User> queryAll() {
		return  userDao.queryAll();
		
	}

	
	public List<User> query(User user) {
		
		List<User> list = userDao.query(user);
		return list;
	}


	public void add(User user) {
		userDao.add(user);
		
	}


	public void update(User user) {
		userDao.update(user);
		
	}


	public User queryById(int id) {
		// TODO Auto-generated method stub
		return userDao.queryById(id);
	}


	public void delete(int id) {
		userDao.delete(id);
		
	}


	public List queryAllManager() {
		// TODO Auto-generated method stub
		return userDao.queryAllManager();
	}


	public int quertApprovalManagerByAgent(int agentId) {
		// TODO Auto-generated method stub
		return userDao.quertApprovalManagerByAgent(agentId);
	}


	public List queryManagerByAgentAndManager(int agentId, int managerId) {
		// TODO Auto-generated method stub
		
		return userDao.queryManagerByAgentAndManager(agentId, managerId);
	}



	public List findAssignedRole(User user) {
		return userDao.findAssignedRole(user);
	}


	public User login(String userName, String password) {
		// TODO Auto-generated method stub
		return userDao.login(userName, password);
	}

	public List queryAllAgentUser() {
		// TODO Auto-generated method stub
		return userDao.queryAllAgentUser();
	}


	public List queryAgentUserByAgentId(int agentId) {
		// TODO Auto-generated method stub
		return userDao.queryAgentUserByAgentId(agentId);
	}


	public int checkName(User user) {
		// TODO Auto-generated method stub
		return userDao.checkName(user);
	}
}
