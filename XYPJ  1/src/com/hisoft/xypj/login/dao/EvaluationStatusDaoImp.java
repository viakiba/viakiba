package com.hisoft.xypj.login.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.hisoft.xypj.login.bean.EvaluationStatus;
import com.hisoft.xypj.login.bean.UserInfo;

public class EvaluationStatusDaoImp extends SqlSessionDaoSupport implements EvaluationStatusDao {

	@Override
	public List<EvaluationStatus> getEvaluationStatusList(UserInfo user) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("User.getEvaluationStatusList", user);
	}
}
