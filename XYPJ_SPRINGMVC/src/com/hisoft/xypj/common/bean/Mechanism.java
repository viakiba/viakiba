package com.hisoft.xypj.common.bean;

import java.util.Date;

public class Mechanism {

	private int mechanismId;
	private String mechanismName = null;
	private String address = null;
	private String telephone = null;
	private int responsibleUserId;
	private int createUserId;
	private Date createTime = null;
	private Date updateTime = null;

	/**
	 * @return the mechanismId
	 */
	public int getMechanismId() {
		return mechanismId;
	}

	/**
	 * @param mechanismId
	 *            the mechanismId to set
	 */
	public void setMechanismId(int mechanismId) {
		this.mechanismId = mechanismId;
	}

	/**
	 * @return the mechanismName
	 */
	public String getMechanismName() {
		return mechanismName;
	}

	/**
	 * @param mechanismName
	 *            the mechanismName to set
	 */
	public void setMechanismName(String mechanismName) {
		this.mechanismName = mechanismName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the responsibleUserId
	 */
	public int getResponsibleUserId() {
		return responsibleUserId;
	}

	/**
	 * @param responsibleUserId
	 *            the responsibleUserId to set
	 */
	public void setResponsibleUserId(int responsibleUserId) {
		this.responsibleUserId = responsibleUserId;
	}

	/**
	 * @return the createUserId
	 */
	public int getCreateUserId() {
		return createUserId;
	}

	/**
	 * @param createUserId
	 *            the createUserId to set
	 */
	public void setCreateUserId(int createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime
	 *            the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
