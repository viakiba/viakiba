package com.hisoft.xypj.login.action;

import java.util.List;

import com.hisoft.xypj.common.bean.Mechanism;
import com.hisoft.xypj.login.service.MechanismService;
import com.opensymphony.xwork2.ActionSupport;

public class BeforeAddUserAction extends ActionSupport {

	/**
	 * 添加用户前 页面的下拉框取值
	 */
	public String execute() throws Exception {
		list = service.selectMechanism();
		if (list != null) {
			return "success";
		}
		return "error";
	}

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4146289856844413660L;

	private MechanismService service = null;

	private List<Mechanism> list = null;

	/**
	 * @return the list
	 */
	public List<Mechanism> getList() {
		return list;
	}

	/**
	 * @param list
	 *            the list to set
	 */
	public void setList(List<Mechanism> list) {
		this.list = list;
	}

	/**
	 * @param service
	 *            the service to set
	 */
	public void setService(MechanismService service) {
		this.service = service;
	}

}
