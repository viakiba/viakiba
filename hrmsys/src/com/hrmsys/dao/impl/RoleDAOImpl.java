package com.hrmsys.dao.impl;

import java.util.List;

import com.hrmsys.dao.RoleDAO;
import com.hrmsys.model.Role;

public class RoleDAOImpl extends BaseDAO implements RoleDAO{

	@Override
	public List<Role> findAll() {
		return super.findAll(Role.class);
	}

	@Override
	public boolean save(Role role) {
		return super.save(role);
	}

	@Override
	public boolean deleteById(String id) {
		return deleteById(Role.class, Integer.parseInt(id));
	}

	@Override
	public boolean update(Role role) {
		return super.update(role);
	}
	
}