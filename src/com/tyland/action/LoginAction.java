package com.tyland.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import com.tyland.common.CommonService;
import com.tyland.domain.Menu;
import com.tyland.domain.MenuItem;
import com.tyland.domain.SystemRole;
import com.tyland.domain.User;
import com.tyland.service.NoticeService;
import com.tyland.service.UserService;
import com.tyland.util.EncoderUtil;

public class LoginAction extends ActionSupport implements SessionAware{
	private CommonService commonService;
	private UserService userService;
	private NoticeService noticeSer;
	private User user;
	private String userName;
	private String password;
	private String loginErrorTips;
	private List menulist;
	private Map<String, Object> session;
	private List resultList;
	
	public CommonService getCommonService() {
		return commonService;
	}
	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public NoticeService getNoticeSer() {
		return noticeSer;
	}
	public void setNoticeSer(NoticeService noticeSer) {
		this.noticeSer = noticeSer;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginErrorTips() {
		return loginErrorTips;
	}
	public void setLoginErrorTips(String loginErrorTips) {
		this.loginErrorTips = loginErrorTips;
	}
	public List getMenulist() {
		return menulist;
	}
	public void setMenulist(List menulist) {
		this.menulist = menulist;
	}
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}
	
	public void setResultList(List resultList) {
		this.resultList = resultList;
	}
	public List getResultList() {
		return resultList;
	}
	public String login() {
		password = EncoderUtil.sha1Encode(password);
		user = userService.login(userName, password);
		if (user != null){
			customMenu();
			setResultList(noticeSer.queryNotReadByUserid(user.getId()));
			setLoginErrorTips(null);
			session.put("sessionUser", user);
			session.put("custommenus", menulist);	
		}else{
			loginErrorTips = getText("loginError.tip");
			return INPUT;			
		}
		return "success";
	}
	
	public String logout() {
		session.clear();
		return "logout";
	}
	
	protected void customMenu() {
		menulist = commonService.queryAll(Menu.class);
		List<MenuItem> userMenuItem = new ArrayList<MenuItem>();
		if (user.getRoles() != null){
			Set<SystemRole> set_role = user.getRoles();
			for(SystemRole r : set_role){
				Set<MenuItem> roleMenuItem = r.getMenuItemSet();
				if (roleMenuItem != null) {
					for (MenuItem mi : roleMenuItem) {
						userMenuItem.add(mi);
					}
				}
			}
		}
		for (int i=0; i<menulist.size(); i++) {
			Menu menuOneOfAll = (Menu) menulist.get(i);
			if (menuOneOfAll.getMenuItemSet() != null) {
				for (MenuItem itemOfOneMenu : menuOneOfAll.getMenuItemSet()) {
					for (MenuItem userItem : userMenuItem) {
						if (itemOfOneMenu.getId().equals(userItem.getId())) {
							menuOneOfAll.setEnabled(true);
							itemOfOneMenu.setEnabled(true);
						}
					}
				}
			}
		}
	}

}
