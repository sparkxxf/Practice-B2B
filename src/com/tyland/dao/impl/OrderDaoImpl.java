package com.tyland.dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tyland.dao.OrderDao;
import com.tyland.domain.Order;
import com.tyland.util.StatisVo;

public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao {

	public List query(Order order, Date start_date, Date end_date, int agentId) {
		
		String hql = "from Order o where o.create_user.agent.id=" + agentId;
		List param = new ArrayList();
		
		if (order != null) {
			String code = order.getOrderCode();
			int status = order.getStatus();
			if (code != null && !code.trim().equals("")) {
				hql += " and o.orderCode=?";
				param.add(code);
			}
			
			if (status >= 0 ) {
				hql += " and o.status=?";
				param.add(status);
			}
			if (null != start_date) {
				hql += " and o.createTime>?";
				param.add(start_date);
			}
			if (null != end_date) {
				hql += " and o.createTime<?";
				param.add(end_date);
			}
		}
		
		hql += " order by o.id desc";
		Object[] objs = param.toArray();
		
		List resultList = this.getHibernateTemplate().find(hql, objs);
		return resultList;
	}
	
	public List statisticalReport(final Date startDate, final Date endDate, final int agentId,
			final int productTypeId) {

		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {

				StringBuffer sql = new StringBuffer("select ag.name as agentName,pt.name as typeName,to_char(o.createtime,'yyyy-mm'), sum(oit.cou), sum(oit.cou * pd.prize)");
				sql.append(" from t_order o");
				sql.append(" left join t_order_item oit");
				sql.append(" on o.id = oit.orderid");
				sql.append(" left join t_user u");
				sql.append(" on o.creat_userid = u.id");
				sql.append(" left join t_agent ag");
				sql.append(" on u.own_agent = ag.id");
				sql.append(" left join t_product_category pd");
				sql.append(" on pd.id=oit.productid");
				sql.append(" left join t_product_type pt");
				sql.append(" on pd.product_type=pt.id");
				sql.append(" where o.status=2");
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				if (startDate != null) {
					sql.append(" and to_char(o.createTime,'yyyymmdd')>=" + sdf.format(startDate));
				}
				if (endDate != null) {
					sql.append(" and to_char(o.createTime,'yyyymmdd')<=" + sdf.format(endDate));
				}
				if (agentId > 0) {
					sql.append(" and ag.id=" + agentId);
				}
				if (productTypeId > 0) {
					sql.append(" and pt.id=" + productTypeId);
				}
				
				sql.append(" group by ag.name, pt.name, to_char(o.createtime,'yyyy-mm') order by ag.name");
				List proTmpList = session.createSQLQuery(sql.toString()).list();
				List<StatisVo> voList = new ArrayList<StatisVo>();
				for (Object obj : proTmpList) {
					Object[] arr = (Object[]) obj;
					StatisVo vo = new StatisVo();

					vo.setAgentName(arr[0].toString());
					vo.setTypeName(arr[1].toString());
					vo.setMonths(arr[2].toString());
					vo.setSumProduct(arr[3].toString());
					vo.setSumPrice(arr[4].toString());
					
					voList.add(vo);
				}
				return voList;
			
			}
		});
		
		
		return list;
	}

}
