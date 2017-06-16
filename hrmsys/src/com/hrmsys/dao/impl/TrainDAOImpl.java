package com.hrmsys.dao.impl;

import java.util.List;

import com.hrmsys.bean.PageBean;
import com.hrmsys.bean.TrainBean;
import com.hrmsys.dao.TrainDAO;
import com.hrmsys.model.Train;
import com.hrmsys.util.ConditionValidate;

public class TrainDAOImpl extends BaseDAO implements TrainDAO{

	@Override
	public List<Train> findAll() {
		return super.findAll(Train.class);
	}

	@Override
	public PageBean findAllByCondition(TrainBean trainBean, String start, String limit) {
		StringBuffer hql = new StringBuffer("FROM Train t WHERE 1=1 ");
		if(ConditionValidate.isEmpty(trainBean.getTrainPerson())){
			hql.append(" AND t.trainPerson = '" + trainBean.getTrainPerson()+"' ");
		}
		if(ConditionValidate.isEmpty(trainBean.getTrainTitle())){
			hql.append(" AND t.trainTitle like '%" + trainBean.getTrainTitle() + "%' ");
		}
		if(ConditionValidate.isEmpty(trainBean.getStartDate()) &&
				ConditionValidate.isEmpty(trainBean.getEndDate())){
			hql.append(" AND t.trainDate between '"+trainBean.getStartDate() +"' AND '"+trainBean.getEndDate()+"'");
		}
		PageBean pageBean = new PageBean();
		pageBean.setRoot(this.page(hql.toString(), Integer.parseInt(start), Integer.parseInt(limit)));
		pageBean.setTotalProperty(this.findByHQL(hql.toString()).size());
		return pageBean;
	}

	@Override
	public boolean save(Train train) {
		if(super.saveOrUpdate(train)) return true;
		return false;
	}

	@Override
	public boolean delete(String[] trainIds) {
		boolean flag = true;
		for(String trainId : trainIds){
			if(!super.deleteById(Train.class, Integer.parseInt(trainId))){
				flag = false;
			}
		}
		return flag;
	}

	@Override
	public List<Train> findTrainById(int trainId) {
		return this.findByProperty(Train.class, "trainId", trainId);
	}

	@Override
	public PageBean findAll(String start, String limit) {
		String hql = "FROM Train";
		PageBean pageBean = new PageBean();
		pageBean.setRoot(this.page(hql, Integer.parseInt(start), Integer.parseInt(limit)));
		pageBean.setTotalProperty(this.findTotal(Train.class));
		return pageBean;
	}
	
}