package com.tyland.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tyland.dao.OrderDao;
import com.tyland.domain.Order;
import com.tyland.service.OrderService;
import com.tyland.util.StatisVo;

public class OrderServiceImpl implements OrderService{
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public List query(Order order, Date startDate, Date endDate, int agentId) {
		// TODO Auto-generated method stub
		return orderDao.query(order, startDate, endDate, agentId);
	}
	
	public List statisticalReport(Date startDate, Date endDate, int agentId,
			int productTypeId) {
		List list = orderDao.statisticalReport(startDate, endDate, agentId, productTypeId);
		List<StatisVo> reslutList = new ArrayList<StatisVo>();
		
		String typeName = "";
		String agentName = "";
		if (list.size() > 0) {
			StatisVo vo = (StatisVo)list.get(0);
			typeName = vo.getTypeName();
			agentName = vo.getAgentName();
		}
		List<StatisVo> oneTypeTemp = new ArrayList<StatisVo>();
		List<StatisVo> oneAgentTemp = new ArrayList<StatisVo>();
		for (int i=0; i<list.size(); i++) {
			StatisVo vo = (StatisVo)list.get(i);
			
			//按产品类别统计小计
			if (!typeName.equals(vo.getTypeName()) || !agentName.equals(vo.getAgentName())) {
				typeName = vo.getTypeName();
				StatisVo typeSum = new StatisVo();
				typeSum.setAgentName("小计");
				int sumProduct = 0;
				int sumPrice = 0;
				for (StatisVo typeVo : oneTypeTemp) {
					sumProduct += Integer.parseInt(typeVo.getSumProduct());
					sumPrice += Integer.parseInt(typeVo.getSumPrice());
				}
				typeSum.setSumProduct(sumProduct + "");
				typeSum.setSumPrice(sumPrice + "");
				oneTypeTemp.clear();
				reslutList.add(typeSum);
			} 
			oneTypeTemp.add(vo);
			//按商户统计总计
			if (!agentName.equals(vo.getAgentName())) {
				agentName = vo.getAgentName();
				StatisVo agentSum = new StatisVo();
				agentSum.setAgentName("总计");
				int sumProduct = 0;
				int sumPrice = 0;
				for (StatisVo typeVo : oneAgentTemp) {
					sumProduct += Integer.parseInt(typeVo.getSumProduct());
					sumPrice += Integer.parseInt(typeVo.getSumPrice());
				}
				agentSum.setSumProduct(sumProduct + "");
				agentSum.setSumPrice(sumPrice + "");
				oneAgentTemp.clear();
				reslutList.add(agentSum);
			}
			oneAgentTemp.add(vo);
			
			reslutList.add(vo);
			
			if ( i == list.size()-1) {
				StatisVo typeSum = new StatisVo();
				typeSum.setAgentName("小计");
				int sumProduct = 0;
				int sumPrice = 0;
				for (StatisVo typeVo : oneTypeTemp) {
					sumProduct += Integer.parseInt(typeVo.getSumProduct());
					sumPrice += Integer.parseInt(typeVo.getSumPrice());
				}
				typeSum.setSumProduct(sumProduct + "");
				typeSum.setSumPrice(sumPrice + "");
				oneTypeTemp.clear();
				reslutList.add(typeSum);
				
				StatisVo agentSum = new StatisVo();
				agentSum.setAgentName("总计");
				int sumProduct_agent = 0;
				int sumPrice_agent = 0;
				for (StatisVo typeVo : oneAgentTemp) {
					sumProduct_agent += Integer.parseInt(typeVo.getSumProduct());
					sumPrice_agent += Integer.parseInt(typeVo.getSumPrice());
				}
				agentSum.setSumProduct(sumProduct_agent + "");
				agentSum.setSumPrice(sumPrice_agent + "");
				oneAgentTemp.clear();
				reslutList.add(agentSum);
			}
		}
		
		
		return reslutList;
	}
	
}
