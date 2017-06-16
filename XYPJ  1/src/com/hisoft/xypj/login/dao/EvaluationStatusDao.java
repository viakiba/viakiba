package com.hisoft.xypj.login.dao;

import java.util.List;

import com.hisoft.xypj.login.bean.EvaluationStatus;
import com.hisoft.xypj.login.bean.UserInfo;

public interface EvaluationStatusDao {

	public List<EvaluationStatus> getEvaluationStatusList(UserInfo user);
}
