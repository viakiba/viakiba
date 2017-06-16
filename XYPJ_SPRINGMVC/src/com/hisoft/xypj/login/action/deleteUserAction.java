package com.hisoft.xypj.login.action;

import com.hisoft.xypj.login.service.UserInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class deleteUserAction extends ActionSupport {
	/**
	 * É¾³ýÓÃ»§
	 */
	public String execute() throws Exception {
		num = service.deleteUser(Integer.parseInt(userId));
		if (num > 0) {
			return "success";
		}
		return "error";
	}

	private static final long serialVersionUID = 3938059226864107003L;

	private UserInfoService service;

	private int num;

	public void setService(UserInfoService service) {
		this.service = service;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}

	private String userId;

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
