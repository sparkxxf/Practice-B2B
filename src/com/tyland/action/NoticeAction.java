package com.tyland.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.tyland.common.CommonService;
import com.tyland.domain.Agent;
import com.tyland.domain.Notice;
import com.tyland.domain.NoticeUser;
import com.tyland.domain.User;
import com.tyland.service.NoticeService;
import com.tyland.service.UserService;

public class NoticeAction extends ActionSupport implements SessionAware{
	private CommonService commonSer;
	private NoticeService noticeSer;
	private UserService userService;
	private Notice notice;
	private List agentList;
	private boolean afterQuery;
	private String selectedIds;
	private String start_date;
	private String end_date;
	private Map<String,Object> session;
	private List resultList;
	
	public void setSelectedIds(String selectedIds) {
		this.selectedIds = selectedIds;
	}
	public List getResultList() {
		return resultList;
	}
	public Notice getNotice() {
		return notice;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setNoticeSer(NoticeService noticeSer) {
		this.noticeSer = noticeSer;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String startDate) {
		start_date = startDate;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String endDate) {
		end_date = endDate;
	}
	public void setNotice(Notice notice) {
		this.notice = notice;
	}
	public boolean isAfterQuery() {
		return afterQuery;
	}
	public void setAfterQuery(boolean afterQuery) {
		this.afterQuery = afterQuery;
	}
	public List getAgentList() {
		return agentList;
	}
	public void setCommonSer(CommonService commonSer) {
		this.commonSer = commonSer;
	}
	
	public String preAdd() {
		agentList = commonSer.queryAll(Agent.class);
		return "toAdd";
	}
	
	public String add() {
		
		User createUser = (User)session.get("sessionUser");
		notice.setPublisher(createUser);
		commonSer.add(notice);
		String code = this.getCodeString(notice.getId());
		 notice.setCode(code);
		commonSer.update(notice);
		
		int scope = notice.getScope();
		List publishToUserList = null;
		if (scope > 0) {
			//发布给某个商户
			publishToUserList = userService.queryAgentUserByAgentId(notice.getScope());
		} else if (scope == -2) {
			//发布给所有用户
			publishToUserList = commonSer.queryAll(User.class);
		} else {
			//发布给所有企业客户
			publishToUserList = userService.queryAllAgentUser();
		}
		Set noticeUserSer = new HashSet();
		for (int i=0; i<publishToUserList.size(); i++) {
			User oneUser = (User) publishToUserList.get(i);
			NoticeUser nu = new NoticeUser();
			nu.setNotice(notice);
			nu.setUser(oneUser);
			nu.setReadStatus(0);
			commonSer.add(nu);
		}
		
		return "add_success";
	}
	public String prepareQuery() {
		return "success";
	}
	public String query() {
		resultList = noticeSer.query(notice, start_date, end_date);
		notice=null;
		afterQuery = true;
		return "success";
	}
	public String delete() {
		String[] ids = selectedIds.split("\\,");
		for (int i=0; i<ids.length; i++) {
			Notice n = new Notice();
			n.setId(new Integer(ids[i]));
			commonSer.delete(n);
		}
		
		return query();
	}
	
	public String queryNotRead() {
		User loginUser = (User)session.get("sessionUser");
		resultList = noticeSer.queryNotReadByUserid(loginUser.getId());
		return "queryNotRead";
	}
	
	private String getCodeString(int id) {
		String code = "N";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String ymd = sdf.format(new Date());
		String idString = "";
		if (id < 10) {
			idString = "00" + id;
		} else if (id < 100) {
			idString = "0" + id;
		} else if (id < 1000) {
			idString = "" + id;
		} else {
			idString = ("" + id).substring(("" + id).length()-3, ("" + id).length()-1);
		}
		code = code +  ymd + idString;
		return code;
	}
	
	public String detail() {
		notice = (Notice) commonSer.queryById(Notice.class, notice.getId());
		return "notic_detail";
	}
	
	public String read() {
		int noticeId = notice.getId();
		int userId = ((User)session.get("sessionUser")).getId();
		noticeSer.read(userId, noticeId);
		return queryNotRead();
	}
	

	
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;	
	}
}
