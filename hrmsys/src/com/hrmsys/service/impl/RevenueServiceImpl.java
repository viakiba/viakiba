package com.hrmsys.service.impl;

import net.sf.json.JSONArray;

import com.hrmsys.bean.PageBean;
import com.hrmsys.dao.RevenueDAO;
import com.hrmsys.enums.StaticValue;
import com.hrmsys.model.Revenue;
import com.hrmsys.service.RevenueService;

public class RevenueServiceImpl implements RevenueService{
	private RevenueDAO revenueDAO;

	@Override
	public String list(String start, String limit) {
		PageBean pageBean = revenueDAO.findAll(start, limit);
		String revenueJson = JSONArray.fromObject(pageBean.getRoot()).toString();
		return "{totalProperty:"+pageBean.getTotalProperty()+",root:"+revenueJson+"}";
	}

	@Override
	public String delete(String ids) {
		String [] reIds = ids.split(",");
		if(revenueDAO.delete(reIds)){
			return StaticValue.DELETE_SUCCESS;
		}
		return StaticValue.DELETE_FAILURE;
	}

	@Override
	public String modify(String json) {
		boolean flag = true;
		JSONArray jsonArray = JSONArray.fromObject(json);
		for(int i = 0; i < jsonArray.size(); i++){
			Revenue revenue = new Revenue();
			revenue.setReId(jsonArray.getJSONObject(i).getInt("reId"));
			revenue.setReMax((float)jsonArray.getJSONObject(i).getInt("reMax"));
			revenue.setReMin((float)jsonArray.getJSONObject(i).getInt("reMin"));
			revenue.setReMinus((float)jsonArray.getJSONObject(i).getInt("reMinus"));
			revenue.setRePercent((float)jsonArray.getJSONObject(i).getInt("rePercent"));
			if(!revenueDAO.saveOrUpdate(revenue)){
				flag = false;
			}
		}
		if(flag){
			return StaticValue.UPDATE_SUCCESS;
		}
		return StaticValue.UPDATE_FAILURE;
	}


	public RevenueDAO getRevenueDAO() {
		return revenueDAO;
	}

	public void setRevenueDAO(RevenueDAO revenueDAO) {
		this.revenueDAO = revenueDAO;
	}
}
