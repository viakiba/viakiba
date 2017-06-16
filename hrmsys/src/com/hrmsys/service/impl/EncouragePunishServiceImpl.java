package com.hrmsys.service.impl;

import net.sf.json.JSONArray;

import com.hrmsys.bean.EncouragePunishBean;
import com.hrmsys.bean.PageBean;
import com.hrmsys.dao.EncouragePunishDAO;
import com.hrmsys.enums.StaticValue;
import com.hrmsys.model.EncouragePunish;
import com.hrmsys.service.EncouragePunishService;

public class EncouragePunishServiceImpl implements EncouragePunishService{
	private EncouragePunishDAO ePunishDAO;

	@Override
	public String list( String start, String limit) {
		PageBean pageBean = ePunishDAO.findAll(start, limit);
		String ePunishJson = JSONArray.fromObject(pageBean.getRoot()).toString();
		return "{totalProperty:"+pageBean.getTotalProperty()+",root:"+ePunishJson+"}";
	}
	
	@Override
	public String listByCondition(EncouragePunishBean ePunishBean,  String start, String limit) {
		PageBean pageBean = ePunishDAO.findAllByCondition(ePunishBean, start, limit);
		String ePunishJson = JSONArray.fromObject(pageBean.getRoot()).toString();
		return "{totalProperty:"+pageBean.getTotalProperty()+",root:"+ePunishJson+"}";
	}
	
	@Override
	public String delete(String ids) {
		String[] epIds = ids.split(",");
		if(ePunishDAO.delete(epIds)){
			return StaticValue.DELETE_SUCCESS;
		}
		return StaticValue.DELETE_FAILURE;
	}

	@Override
	public String save(EncouragePunish ePunish) {
		if(ePunishDAO.save(ePunish)){
			return StaticValue.SAVE_SUCCESS;
		}
		return StaticValue.SAVE_FAILURE;
	}
	
	@Override
	public String getEPunishById(String epId) {
		EncouragePunish ePunish = ePunishDAO.findById(Integer.parseInt(epId));
		return JSONArray.fromObject(ePunish).toString();
	}
	
	@Override
	public String update(EncouragePunish ePunish) {
		if(ePunishDAO.update(ePunish)){
			return StaticValue.UPDATE_SUCCESS;
		}
		return StaticValue.UPDATE_FAILURE;
	}
	
	public EncouragePunishDAO getePunishDAO() {
		return ePunishDAO;
	}

	public void setePunishDAO(EncouragePunishDAO ePunishDAO) {
		this.ePunishDAO = ePunishDAO;
	}

}
