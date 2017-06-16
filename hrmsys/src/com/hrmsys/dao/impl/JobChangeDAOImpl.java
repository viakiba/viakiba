package com.hrmsys.dao.impl;

import java.util.List;

import com.hrmsys.bean.PageBean;
import com.hrmsys.dao.JobChangeDAO;
import com.hrmsys.model.JobChange;


public class JobChangeDAOImpl extends BaseDAO implements JobChangeDAO{

	public List<JobChange> findAll(String start, String limit){
		String 	hql = "FROM JobChange";
		return this.page(hql, Integer.parseInt(start), Integer.parseInt(limit));
	}
	
	@Override
	public boolean delete(String[] jcIds) {
		boolean flag = true;
		for(String jcId : jcIds){
			if(!super.deleteById(JobChange.class, Integer.parseInt(jcId)))
				flag = false;
		}
		return flag;
	}

	@Override
	public boolean save(JobChange jobChange) {
		return super.save(jobChange);
	}

	@Override
	public PageBean findAll(String condition, String conditionValue,
			String start, String limit) {
		String hql = "FROM JobChange jc WHERE jc.employee."+condition+" = '"+conditionValue+"'";
		PageBean pageBean = new PageBean();
		pageBean.setRoot(this.page(hql, Integer.parseInt(start), Integer.parseInt(limit)));
		pageBean.setTotalProperty(this.findByHQL(hql).size());
		return pageBean;
	}

	@Override
	public JobChange findById(int jcId) {
		return super.get(JobChange.class, jcId);
	}

	@Override
	public boolean update(JobChange jobChange) {
		return super.update(jobChange);
	}
	
}