package com.hrmsys.dao.impl;

import java.util.List;

import com.hrmsys.bean.PageBean;
import com.hrmsys.dao.RevenueDAO;
import com.hrmsys.model.Revenue;

public class RevenueDAOImpl extends BaseDAO implements RevenueDAO{

	@Override
	public List<Revenue> findAll() {
		return super.findAll(Revenue.class);
	}

	@Override
	public boolean delete(String[] reIds) {
		boolean flag = true;
		for(String reId : reIds){
			if(!super.deleteById(Revenue.class, Integer.parseInt(reId))) 
				flag = false;
		}
		return flag;
	}

	@Override
	public boolean saveOrUpdate(Revenue revenue) {
		if(super.saveOrUpdate(revenue)){
			return true;
		}
		return false;
	}

	@Override
	public Revenue findByMinAndMax(float allMoney) {
		String hql = "FROM Revenue r WHERE r.reMin < " + allMoney +" AND r.reMax >=" +allMoney;
		List<Revenue> revenus = super.findByHQL(hql);
		if(revenus.size() != 0)
			return revenus.get(0);
		return null;
	}

	@Override
	public PageBean findAll(String start, String limit) {
		String hql = "FROM Revenue";
		PageBean pageBean = new PageBean();
		pageBean.setRoot(this.page(hql, Integer.parseInt(start), Integer.parseInt(limit)));
		pageBean.setTotalProperty(this.findTotal(Revenue.class));
		return pageBean;
	}

}
