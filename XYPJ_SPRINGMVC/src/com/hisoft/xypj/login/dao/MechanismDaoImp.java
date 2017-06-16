package com.hisoft.xypj.login.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.hisoft.xypj.common.bean.Mechanism;

public class MechanismDaoImp extends SqlSessionDaoSupport implements
		MechanismDao {

	@Override
	public List<Mechanism> selectMechanism() {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList("User.beforeAddUser");
	}

	@Override
	public int addMechanism(Mechanism mech) {
		// TODO Auto-generated method stub
		return this.getSqlSession().insert("User.addMechanism", mech);
	}

	@Override
	public List<Mechanism> getMechanism() {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList("User.getMechanism");
	}

	@Override
	public int deleteMech(String id) {
		// TODO Auto-generated method stub
		return this.getSqlSession().delete("User.deleteMechanism", id);
	}

}
