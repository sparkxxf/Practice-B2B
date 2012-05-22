package com.tyland.service;

import java.util.List;

import com.tyland.domain.Notice;

public interface NoticeService {
	List query(Notice notice, String start_date, String end_date);
	List queryNotReadByUserid(int userid);
	void read(int userId, int notieId);
}
