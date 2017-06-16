package com.tdvm.cjgl.bean;

import com.tdvm.base.UpdateConst;
import com.tdvm.cjgl.entity.BaseUser;


/**
 * 用户信息
 */
public class UserBean extends BaseUser {

	private static final long serialVersionUID = 1520732327075202901L;

	/**
	 * 结果
	 */
	private String state = UpdateConst.RESULT_BEAN_STATE_FAIL;

	/**
	 * 错误信息
	 */
	private String data;
	
	private String passwordOld;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getPasswordOld() {
		return passwordOld;
	}

	public void setPasswordOld(String passwordOld) {
		this.passwordOld = passwordOld;
	}

}
