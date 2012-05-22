package com.tyland.dao.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tyland.dao.NoticeDao;
import com.tyland.domain.Notice;
import com.tyland.domain.NoticeUser;
import com.tyland.domain.ProductType;
import com.tyland.domain.ProductType;

public class NoticeDaoImpl extends HibernateDaoSupport implements NoticeDao {

	public List query(Notice notice, String start_date, String end_date) {
		String hql = "from Notice n where 1=1";
		List param = new ArrayList();

		if (notice != null) {
			String code = notice.getCode();
			String title = notice.getTitle();
			int status = notice.getStatus();
			int mandatory = notice.getMandatory();
			if (code != null && !code.trim().equals("")) {
				hql += " and n.code=?";
				param.add(code);
			}

			if (title != null && !title.trim().equals("")) {
				hql += " and n.title=?";
				param.add(title);
			}
			if (status >= 0) {
				hql += " and n.status=?";
				param.add(status);
			}
			if (mandatory >= 0) {
				hql += " and n.mandatory=?";
				param.add(mandatory);
			}
		}

		if (start_date != null && !start_date.trim().equals("")) {
			hql += " and n.create_date>=?";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = sdf.parse(start_date);
				param.add(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (end_date != null && !end_date.trim().equals("")) {
			hql += " and n.create_date<=?";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			try {
				date = sdf.parse(end_date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			param.add(date);
		}

		hql += " order by n.id desc";
		Object[] objs = param.toArray();

		List resultList = this.getHibernateTemplate().find(hql, objs);
		return resultList;
	}

	public List queryNotReadByUserid(int userid) {
		String hql = "select n from Notice n inner join n.noticeUserSet users where n.status=1 and users.readStatus=0 and users.user.id="
				+ userid;
		return this.getHibernateTemplate().find(hql);
	}

	public void read(final int userId, final int notieId) {
		String hql = "from NoticeUser nu where nu.user.id="+userId+" and nu.notice.id="+notieId;
		NoticeUser nu = (NoticeUser) this.getHibernateTemplate().find(hql).get(0);
		nu.setReadStatus(1);
		this.getHibernateTemplate().update(nu);

	}

}
