package com.tyland.service.impl;

import java.util.List;

import com.tyland.dao.NoticeDao;
import com.tyland.domain.Notice;
import com.tyland.service.NoticeService;

public class NoticeServiceImpl implements NoticeService{
	
	private NoticeDao noticeDao;
	
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	public List query(Notice notice, String startDate, String endDate) {
		// TODO Auto-generated method stub
		return noticeDao.query(notice, startDate, endDate);
	}

	public List queryNotReadByUserid(int userid) {
		// TODO Auto-generated method stub
		return noticeDao.queryNotReadByUserid(userid);
	}

	public void read(int userId, int notieId) {
		noticeDao.read(userId, notieId);
		
	}

}
