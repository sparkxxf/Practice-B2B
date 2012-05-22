package com.tyland.service;

import java.util.List;
import com.tyland.domain.User;

public interface UserService {
	List<User> queryAll();
	List<User> query(User user);
	void add(User user);
	void update(User user);
	User queryById(int id);
	void delete(int id);
	List queryAllManager();
	List queryManagerByAgentAndManager(int agentId, int managerId);
	int quertApprovalManagerByAgent(int agentId);
	List findAssignedRole(User user);
	User login(String userName, String password);
	List queryAgentUserByAgentId(int agentId);
	List queryAllAgentUser();
	int checkName(User user);
}
