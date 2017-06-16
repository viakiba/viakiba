package com.hisoft.xypj.login.action;

import com.hisoft.xypj.common.bean.UserInfo;
import com.hisoft.xypj.login.service.UserInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class AddUserAction extends ActionSupport {

	/**
	 * Ìí¼ÓÓÃ»§
	 */
	public String execute() throws Exception {
		int i = service.addUserInfo(user);
		if (i > 0) {
			return "success";
		}
		return "false";
	}

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7582871650613691747L;

	/**
	 * UserInfoService
	 */
	private UserInfoService service = null;

	private UserInfo user = null;

	/**
	 * @return the user
	 */
	public UserInfo getUser() {
		return user;
	}

	/**
	 * @param u
	 *            the u to set
	 */
	public void setUser(UserInfo user) {
		this.user = user;
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(UserInfoService service) {
		this.service = service;
		// service.addUserInfo(u);
	}

}
