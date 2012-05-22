package com.tyland.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.tyland.dao.AgentProductDao;
import com.tyland.domain.ProductCategory;
import com.tyland.domain.ProductType;

public class AgentProductDaoImpl extends HibernateDaoSupport implements
		AgentProductDao {



	public List<ProductCategory> querry(int id) {
		String hql = "from ProductCategory p where 1=1";
		List list = new ArrayList();
		if (id != 0) {
			hql += " and p.productType.id=?";
			list.add(id);
		}

		hql += " order by p.id desc";
		Object[] objs = list.toArray();

		List resultList = this.getHibernateTemplate().find(hql, objs);
		return resultList;

	}

	
	public List querypublish(final int pid, final int aid) {



		List list = this.getHibernateTemplate().executeFind(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						String sql = "select pc.*,pt.name from t_agent a join t_agent_productCategory ap on a.id=ap.agent_id join t_product_category pc on pc.id=ap.product_id "
								+ " join t_product_type pt on pc.product_type = pt.id where 1=1";

						if (pid != 0) {
							sql += " and pt.id=" + pid;

						}

						if (aid != 0) {
							sql += " and a.id=" + aid;

						}

						List resultList = session.createSQLQuery(sql).list();
						List<ProductCategory> productList = new ArrayList<ProductCategory>();
						for (Object obj : resultList) {
							Object[] arr = (Object[]) obj;
							ProductCategory p = new ProductCategory();
							ProductType pt = new ProductType();
							p.setId(new Integer(arr[0].toString()));
							// p.setProductType(arr[8].toString());
							p.setBrand(arr[1].toString());
							p.setType(arr[2].toString());
							p.setQuan(arr[3].toString());
							p.setPrize(new Integer(arr[4].toString()));
							p.setDesc(arr[5].toString());
							p.setSpe(arr[6].toString());
							p.setRemark(arr[7].toString());
							//pt.setName(arr[9].toString());
							
							 ProductType ptype = new ProductType();
							 ptype.setId(new Integer(arr[8].toString()));
						
							  ptype.setName(arr[9].toString());
							  p.setProductType(ptype); 
							  productList.add(p);
							

						}
						return productList;
					}
				});

		return list;

	}
	
	public void add(int pid, int aid) {
/*		String hql = "from  Agent_productCategory ap where 1=1";
		List list = new ArrayList();
	 
		if (pid != 0) {
			hql += " and ap.product_id=?";
			list.add(pid);
		}

		if (aid != 0) {
			hql += " and ap.agent_id=?";
			list.add(aid);
		}
		
		Object[] objs = list.toArray();
		List querypublish = this.getHibernateTemplate().find(hql, objs);
	*/	
	}

	
	  
	

}
