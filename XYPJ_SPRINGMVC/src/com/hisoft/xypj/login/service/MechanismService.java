package com.hisoft.xypj.login.service;

import java.util.List;

import com.hisoft.xypj.common.bean.Mechanism;

public interface MechanismService {
	public List<Mechanism> selectMechanism();

	// 查询机构信息
	public List<Mechanism> getMechanism();

	// 添加机构信息
	public int addMechanism(Mechanism mech);

	// 删除机构信息
	public int deleteMech(String id);
}
