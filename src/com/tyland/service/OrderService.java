package com.tyland.service;

import java.util.Date;
import java.util.List;

import com.tyland.domain.Order;

public interface OrderService {
	List query(Order order, Date start_date, Date end_date, int agentId);
	List statisticalReport(Date start_date, Date end_date, int agentId, int productTypeId);
}
