package com.hrmsys.dao.impl;

import com.hrmsys.bean.PageBean;
import com.hrmsys.bean.TrainRecordBean;
import com.hrmsys.dao.TrainRecordDAO;
import com.hrmsys.model.TrainRecord;
import com.hrmsys.util.ConditionValidate;

public class TrainRecordDAOImpl extends BaseDAO implements TrainRecordDAO{

	@Override
	public PageBean findAll(String start, String limit) {
		String hql = "FROM TrainRecord";
		PageBean pageBean = new PageBean();
		pageBean.setRoot(this.page(hql, Integer.parseInt(start), Integer.parseInt(limit)));
		pageBean.setTotalProperty(this.findTotal(TrainRecord.class));
		return pageBean;
	}

	@Override
	public boolean delete(String[] tRecordIds) {
		boolean flag = true;
		for(String tRecordId : tRecordIds){
			if(!super.deleteById(TrainRecord.class, Integer.parseInt(tRecordId)))
					flag = false;
		}
		return flag;
	}

	@Override
	public PageBean findAllByCondition(TrainRecordBean tRecordBean, String start, String limit) {
		StringBuffer hql = new StringBuffer("FROM TrainRecord tr WHERE 1=1 ");
		if(ConditionValidate.isEmpty(tRecordBean.getEmpName())){
			hql.append(" AND tr.employee.empName = '" + tRecordBean.getEmpName()+"' ");
		}
		if(ConditionValidate.isEmpty(tRecordBean.getTrainPerson())){
			hql.append(" AND tr.train.trainPerson = '" + tRecordBean.getTrainPerson()+"' ");
		}
		if(ConditionValidate.isEmpty(tRecordBean.getTrainTitle())){
			hql.append(" AND tr.train.trainTitle like '%" + tRecordBean.getTrainTitle() + "%' ");
		}
		if(ConditionValidate.isEmpty(tRecordBean.getStartDate()) &&
				ConditionValidate.isEmpty(tRecordBean.getEndDate())){
			hql.append(" AND tr.train.trainDate between '"+tRecordBean.getStartDate() +"' AND '"+tRecordBean.getEndDate()+"'");
		}
		PageBean pageBean = new PageBean();
		pageBean.setRoot(this.page(hql.toString(), Integer.parseInt(start), Integer.parseInt(limit)));
		pageBean.setTotalProperty(this.findByHQL(hql.toString()).size());
		return pageBean;
	}

	@Override
	public boolean saveOrUpdate(TrainRecord tRecord) {
		if(super.saveOrUpdate(tRecord)){
			return true;
		}
		return false;
	}

	@Override
	public TrainRecord findById(int tRecordId) {
		return super.get(TrainRecord.class, tRecordId);
	}

	@Override
	public boolean update(TrainRecord trainRecord) {
		return super.update(trainRecord);
	}

}
