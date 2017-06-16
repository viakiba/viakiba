package com.hisoft.xypj.login.service;

import java.util.List;

import com.hisoft.xypj.common.bean.Mechanism;
import com.hisoft.xypj.login.dao.MechanismDao;

public class MechanismServiceImp implements MechanismService {

	@Override
	public List<Mechanism> selectMechanism() {
		// TODO Auto-generated method stub
		return mechanismDao.selectMechanism();
	}

	@Override
	public List<Mechanism> getMechanism() {
		// TODO Auto-generated method stub
		return mechanismDao.getMechanism();
	}

	@Override
	public int addMechanism(Mechanism mech) {
		// TODO Auto-generated method stub
		return mechanismDao.addMechanism(mech);
	}

	@Override
	public int deleteMech(String id) {
		// TODO Auto-generated method stub
		return mechanismDao.deleteMech(id);
	}

	private MechanismDao mechanismDao = null;

	/**
	 * @param mechanismDao
	 *            the mechanismDao to set
	 */
	public void setMechanismDao(MechanismDao mechanismDao) {
		this.mechanismDao = mechanismDao;
	}

}
