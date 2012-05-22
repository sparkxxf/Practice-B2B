package com.tyland.domain;

public class NoticeUser {
	private Integer id;
	private User user;
	private Notice notice;
	private Integer readStatus;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Notice getNotice() {
		return notice;
	}
	public void setNotice(Notice notice) {
		this.notice = notice;
	}
	public Integer getReadStatus() {
		return readStatus;
	}
	public void setReadStatus(Integer readStatus) {
		this.readStatus = readStatus;
	}
	
}
