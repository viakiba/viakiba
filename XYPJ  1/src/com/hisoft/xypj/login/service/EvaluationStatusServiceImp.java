package com.hisoft.xypj.login.service;

import java.util.List;

import com.hisoft.xypj.login.bean.EvaluationStatus;
import com.hisoft.xypj.login.bean.UserInfo;
import com.hisoft.xypj.login.dao.EvaluationStatusDao;

public class EvaluationStatusServiceImp implements EvaluationStatusService {

	/**
	 * EvaluationStatusDao
	 */
	private EvaluationStatusDao evaluationStatusDao = null;

	/**
	 * @param evaluationStatusDao the evaluationStatusDao to set
	 */
	public void setEvaluationStatusDao(EvaluationStatusDao evaluationStatusDao) {
		this.evaluationStatusDao = evaluationStatusDao;
	}

	@Override
	public List<EvaluationStatus> getEvaluationStatusList(UserInfo u) {
		// TODO Auto-generated method stub
		return evaluationStatusDao.getEvaluationStatusList(u);
	}
	
}
