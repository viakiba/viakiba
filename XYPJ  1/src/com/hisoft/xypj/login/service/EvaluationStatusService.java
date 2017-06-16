package com.hisoft.xypj.login.service;

import java.util.List;

import com.hisoft.xypj.login.bean.EvaluationStatus;
import com.hisoft.xypj.login.bean.UserInfo;

public interface EvaluationStatusService {


	
	public List<EvaluationStatus> getEvaluationStatusList(UserInfo u);
}
