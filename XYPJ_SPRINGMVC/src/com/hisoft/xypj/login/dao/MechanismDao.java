package com.hisoft.xypj.login.dao;

import java.util.List;

import com.hisoft.xypj.common.bean.Mechanism;

public interface MechanismDao {
	public List<Mechanism> selectMechanism();

	// 添加机构信息
	public int addMechanism(Mechanism mech);

	// 查询机构信息
	public List<Mechanism> getMechanism();

	// 删除机构信息
	public int deleteMech(String id);
}
