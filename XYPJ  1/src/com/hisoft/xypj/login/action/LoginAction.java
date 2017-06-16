package com.hisoft.xypj.login.action;

import java.util.List;

import com.hisoft.xypj.login.bean.EvaluationStatus;
import com.hisoft.xypj.login.bean.UserInfo;
import com.hisoft.xypj.login.service.EvaluationStatusService;
import com.hisoft.xypj.login.service.UserInfoService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5345615269342419254L;

	/**
	 * UserInfoService
	 */
	private UserInfoService service = null;

	/**
	 * UserInfoService
	 */
	private EvaluationStatusService evaluationStatusService = null;

	// 用户信息
	private UserInfo user = null;

	// 用户信息
	private List<EvaluationStatus> evaluationStatusList = null;
	
	/* (non-Javadoc)
     * @see com.opensymphony.xwork2.ActionSupport#execute()
     */
    public String execute() throws Exception {

    	UserInfo u = service.getUserInfo(user);

    	if (null != u) {
    		evaluationStatusList = evaluationStatusService.getEvaluationStatusList(u);
    	} else {
    		return "error";
    	}
    	
    	System.out.println(user.getUserId());
        return "success" ; 
    }

	/**
	 * @param service the service to set
	 */
	public void setService(UserInfoService service) {
		this.service = service;
	}

	/**
	 * @return the evaluationStatusList
	 */
	public List<EvaluationStatus> getEvaluationStatusList() {
		return evaluationStatusList;
	}


	/**
	 * @param evaluationStatusList the evaluationStatusList to set
	 */
	public void setEvaluationStatusList(List<EvaluationStatus> evaluationStatusList) {
		this.evaluationStatusList = evaluationStatusList;
	}


	/**
	 * @param evaluationStatusService the evaluationStatusService to set
	 */
	public void setEvaluationStatusService(
			EvaluationStatusService evaluationStatusService) {
		this.evaluationStatusService = evaluationStatusService;
	}

	/**
	 * @return the user
	 */
	public UserInfo getUser() {
		return user;
	}


	/**
	 * @param user the user to set
	 */
	public void setUser(UserInfo user) {
		this.user = user;
	}
}
