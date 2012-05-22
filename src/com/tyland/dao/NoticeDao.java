package com.tyland.dao;

import java.util.List;

import com.tyland.domain.Notice;

public interface NoticeDao {
	List query(Notice notice, String start_date, String end_date);
	List queryNotReadByUserid(int userid);
	void read(int userId, int notieId);
}
