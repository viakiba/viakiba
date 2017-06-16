package com.hisoft.xypj.login.action;

import java.util.List;

import com.hisoft.xypj.common.bean.DeleteUserBean;
import com.hisoft.xypj.login.service.UserInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class selectUserAction extends ActionSupport {

	/**
	 * ²éÑ¯ÓÃ»§
	 */
	public String execute() throws Exception {

		listUMR = service.getUMR();
		if (listUMR.size() > 0) {
			return "success";
		}
		return "false";
	}

	private UserInfoService service;
	private List<DeleteUserBean> listUMR;

	public List<DeleteUserBean> getListUMR() {
		return listUMR;
	}

	public void setListUMR(List<DeleteUserBean> listUMR) {
		this.listUMR = listUMR;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setService(UserInfoService service) {
		this.service = service;

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 8819380077057517970L;

}
