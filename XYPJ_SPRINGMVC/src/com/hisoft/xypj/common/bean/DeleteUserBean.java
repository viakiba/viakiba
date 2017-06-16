package com.hisoft.xypj.common.bean;

public class DeleteUserBean {

	private int userId;
	private String userName = null;
	private String mechanismName = null;
	private int mechanismId;
	private String right = null;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMechanismName() {
		return mechanismName;
	}

	public void setMechanismName(String mechanismName) {
		this.mechanismName = mechanismName;
	}

	public int getMechanismId() {
		return mechanismId;
	}

	public void setMechanismId(int mechanismId) {
		this.mechanismId = mechanismId;
	}

	public String getRight() {
		return right;
	}

	public void setRight(String right) {
		this.right = right;
	}

}
