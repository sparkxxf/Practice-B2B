package com.tyland.dao;

import java.util.Date;
import java.util.List;

import com.tyland.domain.Order;

public interface OrderDao {
	List query(Order order, Date start_date, Date end_date, int agentId);
	List statisticalReport(Date start_date, Date end_date, int agentId, int productTypeId);
}
