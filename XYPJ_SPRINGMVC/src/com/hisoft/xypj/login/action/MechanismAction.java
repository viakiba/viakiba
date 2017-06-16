package com.hisoft.xypj.login.action;

import java.util.List;

import com.hisoft.xypj.common.bean.Mechanism;
import com.hisoft.xypj.login.service.MechanismService;
import com.opensymphony.xwork2.ActionSupport;

public class MechanismAction extends ActionSupport {

	/**
	 * 添加机构
	 */
	public String addMechanism() throws Exception {

		System.out.println("s");
		System.out.println(mech);
		System.out.println(mech.getAddress());

		System.out.println("" + mech.getResponsibleUserId());
		int temp = service.addMechanism(mech);

		if (temp != -1) {
			return "success";
		}

		return "false";

	}

	private static final long serialVersionUID = 5345615269342419254L;

	private List<Mechanism> list = null;

	private String id = null;

	/**
	 * 查询机构信息
	 * 
	 * @return
	 * @throws Exception
	 */
	public String queryList() throws Exception {

		list = service.getMechanism();

		if (null != list) {

			return "success";
		}
		return "flase";
	}

	public String deleteMechanism() throws Exception {

		int temp = service.deleteMech(id);

		if (-1 != temp) {

			return "success";
		}
		return "false";

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Mechanism> getList() {
		return list;
	}

	public void setList(List<Mechanism> list) {
		this.list = list;
	}

	private MechanismService service = null;

	/**
	 * @return the service
	 */
	public MechanismService getService() {
		return service;
	}

	public void setService(MechanismService service) {
		this.service = service;
	}

	private Mechanism mech = null;

	/**
	 * @return the mech
	 */
	public Mechanism getMech() {
		return mech;
	}

	/**
	 * @param mech
	 *            the mech to set
	 */
	public void setMech(Mechanism mech) {
		this.mech = mech;
	}

}
