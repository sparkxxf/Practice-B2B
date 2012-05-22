package com.tyland.domain;

import java.util.Date;
import java.util.Set;

public class Notice {
	private Integer id;
	private String code;
	private String title;
	private Integer status;
	private Integer mandatory;
	private Integer scope;
	private String content;
	private Date create_date = new Date();
	
	private Set<NoticeUser> noticeUserSet;
	private User publisher;
	
	


	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public User getPublisher() {
		return publisher;
	}
	public void setPublisher(User publisher) {
		this.publisher = publisher;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date createDate) {
		create_date = createDate;
	}
	public Set<NoticeUser> getNoticeUserSet() {
		return noticeUserSet;
	}
	public void setNoticeUserSet(Set<NoticeUser> noticeUserSet) {
		this.noticeUserSet = noticeUserSet;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getMandatory() {
		return mandatory;
	}
	public void setMandatory(Integer mandatory) {
		this.mandatory = mandatory;
	}
	public Integer getScope() {
		return scope;
	}
	public void setScope(Integer scope) {
		this.scope = scope;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
