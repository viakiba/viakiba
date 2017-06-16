package com.hrmsys.dao.impl;

import java.util.List;

import com.hrmsys.bean.EncouragePunishBean;
import com.hrmsys.bean.PageBean;
import com.hrmsys.dao.EncouragePunishDAO;
import com.hrmsys.model.EncouragePunish;
import com.hrmsys.util.ConditionValidate;

public class EncouragePunishDAOImpl extends BaseDAO implements EncouragePunishDAO{

	@Override
	public PageBean findAll( String start, String limit) {
		String hql = "FROM EncouragePunish";
		PageBean pageBean = new PageBean();
		pageBean.setRoot(this.page(hql, Integer.parseInt(start), Integer.parseInt(limit)));
		pageBean.setTotalProperty(this.findTotal(EncouragePunish.class));
		return pageBean;
	}

	@Override
	public PageBean findAllByCondition(EncouragePunishBean ePunishBean,  String start, String limit) {
		StringBuffer hql = new StringBuffer("FROM EncouragePunish ep WHERE 1 = 1 ");
		log.info("......"+ePunishBean.getEmpId()+"..."+ePunishBean.getEmpName()+"..."+ePunishBean.getEpTitle()+"..."+ePunishBean.getEpType());
		if(ConditionValidate.isEmpty(ePunishBean.getEmpId())){
			hql.append(" AND ep.employee.empId = '"+ePunishBean.getEmpId()+"' ");
		}
		if(ConditionValidate.isEmpty(ePunishBean.getEmpName())){
			hql.append(" AND ep.employee.empName = '"+ePunishBean.getEmpName()+"' ");
		}
		if(ConditionValidate.isEmpty(ePunishBean.getEpTitle())){
			hql.append(" AND ep.epTopic like '%"+ePunishBean.getEpTitle()+"%' ");
		}
		if(ConditionValidate.isEmpty(ePunishBean.getEpType())){
			hql.append(" AND ep.epType = "+Integer.parseInt(ePunishBean.getEpType()));
		}
		PageBean pageBean = new PageBean();
		pageBean.setRoot(this.page(hql.toString(),Integer.parseInt(start), Integer.parseInt(limit)));
		pageBean.setTotalProperty(this.findByHQL(hql.toString()).size());
		return pageBean;
	}

	@Override
	public boolean delete(String[] epIds) {
		boolean flag = true;
		for(String epId : epIds){
			if(!super.deleteById(EncouragePunish.class, Integer.parseInt(epId)))
				flag = false;
		}
		return flag;
	}

	@Override
	public boolean save(EncouragePunish ePunish) {
		if(super.save(ePunish)){
			return true;
		}
		return false;
	}

	@Override
	public EncouragePunish findById(int epId) {
		return super.get(EncouragePunish.class, epId);
	}

	@Override
	public boolean update(EncouragePunish ePunish) {
		return super.update(ePunish);
	}
	
}