package com.hrmsys.dao.impl;

import java.util.List;

import com.hrmsys.dao.RolePermissionDAO;
import com.hrmsys.model.RolePermission;

public class RolePermissionDAOImpl extends BaseDAO implements RolePermissionDAO{

	@Override
	public boolean saveOrUpdate(RolePermission rolePer) {
		return super.saveOrUpdate(rolePer);
	}

	@Override
	public List<RolePermission> findByRoleId(int roleId) {
		return this.findByHQL("FROM RolePermission WHERE role.roleId = "+roleId);
	}

	@Override
	public RolePermission findByPerIdAndRoleId(int perId, String roleId) {
		String hql = "FROM RolePermission WHERE permission.perId = ? AND role.roleId = ? ";
		Integer[] values = new Integer[]{perId,  Integer.parseInt(roleId)};
		List<RolePermission> rolePers = this.findByHQLAndValue(hql, values);
		if(rolePers.size() > 0) 
			return rolePers.get(0);
		return null;
	}

	@Override
	public void deleteByRole(String roleId) {
		String hql = "FROM RolePermission p WHERE p.role.roleId = ? ";
		List<RolePermission> rps = this.findByHQLAndValue(hql, Integer.parseInt(roleId));
		for(RolePermission rp : rps){
			this.delete(rp);
		}
	}
	
	
}
