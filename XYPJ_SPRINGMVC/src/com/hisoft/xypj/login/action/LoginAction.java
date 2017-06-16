package com.hisoft.xypj.login.action;

import com.hisoft.xypj.common.bean.UserInfo;
import com.hisoft.xypj.login.service.UserInfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {

	/**
	 * 登录
	 */
	public String execute() throws Exception {

		u = service.getUserInfo(user);
		if (null != u) {
			ActionContext.getContext().getSession().put("u", u);
			return "success";
		}
		return "false";
	}

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5345615269342419254L;

	private UserInfo u = null;

	public UserInfo getU() {
		return u;
	}

	public void setU(UserInfo u) {
		this.u = u;
	}

	/**
	 * UserInfoService
	 */
	private UserInfoService service = null;

	// 用户信息
	private UserInfo user = null;

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(UserInfoService service) {
		this.service = service;
	}

	/**
	 * @return the user
	 */
	public UserInfo getUser() {
		return user;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(UserInfo user) {
		this.user = user;
	}
}
