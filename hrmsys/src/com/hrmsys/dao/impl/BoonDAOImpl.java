package com.hrmsys.dao.impl;

import java.util.List;

import com.hrmsys.bean.PageBean;
import com.hrmsys.dao.BoonDAO;
import com.hrmsys.model.Boon;

public class BoonDAOImpl extends BaseDAO implements BoonDAO{
	@Override
	public PageBean findAll(String start, String limit) {
		String hql = "FROM Boon";
		PageBean pageBean = new PageBean();
		pageBean.setRoot(this.page(hql, Integer.parseInt(start), Integer.parseInt(limit)));
		pageBean.setTotalProperty(this.findTotal(Boon.class));
		return pageBean;
	}

	@Override
	public boolean delete(String[] boonIds) {
		boolean flag = true;
		for(String boonId : boonIds){
			if(!super.deleteById(Boon.class, Integer.parseInt(boonId))) 
				flag = false;
		}
		return flag;
	}

	@Override
	public boolean saveOrUpdate(Boon boon) {
		if(super.saveOrUpdate(boon)){
			return true;
		}
		return false;
	}

	@Override
	public List<Boon> findAll() {
		return findAll(Boon.class);
	}
}
