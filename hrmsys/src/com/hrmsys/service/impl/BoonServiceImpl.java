package com.hrmsys.service.impl;

import net.sf.json.JSONArray;

import com.hrmsys.bean.PageBean;
import com.hrmsys.dao.BoonDAO;
import com.hrmsys.enums.StaticValue;
import com.hrmsys.model.Boon;
import com.hrmsys.service.BoonService;

public class BoonServiceImpl implements BoonService{
	private BoonDAO boonDAO;
	public String list(String start, String limit) {
		PageBean pageBean = boonDAO.findAll(start, limit);
		String boonJson = JSONArray.fromObject(pageBean.getRoot()).toString();
		return "{totalProperty:"+pageBean.getTotalProperty()+",root:"+boonJson+"}";
	}

	@Override
	public String delete(String ids) {
		String [] reIds = ids.split(",");
		if(boonDAO.delete(reIds)){
			return StaticValue.DELETE_SUCCESS;
		}
		return StaticValue.DELETE_FAILURE;
	}

	@Override
	public String modify(String json) {
		boolean flag = true;
		JSONArray jsonArray = JSONArray.fromObject(json);
		for(int i = 0; i < jsonArray.size(); i++){
			Boon boon = new Boon();
			boon.setBoonId(jsonArray.getJSONObject(i).getInt("boonId"));
			boon.setBoonName(jsonArray.getJSONObject(i).getString("boonName"));
			boon.setBoonMoney((float)jsonArray.getJSONObject(i).getInt("boonMoney"));
			boon.setBoonPercent((float)jsonArray.getJSONObject(i).getInt("boonPercent"));
			boon.setBoonRemark(jsonArray.getJSONObject(i).getString("boonRemark"));
			if(!boonDAO.saveOrUpdate(boon)){
				flag = false;
			}
		}
		if(flag){
			return StaticValue.UPDATE_SUCCESS;
		}
		return StaticValue.UPDATE_FAILURE;
	}

	public BoonDAO getBoonDAO() {
		return boonDAO;
	}

	public void setBoonDAO(BoonDAO boonDAO) {
		this.boonDAO = boonDAO;
	}
	
}
