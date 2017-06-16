package com.tdvm.cjgl.service;

import com.tdvm.cjgl.bean.UserBean;


/**
 * 登录业务处理
 */
public interface LoginService {

	/**
	 * 验证用户信息
	 * @param userBean
	 * @return
	 */
	public UserBean checkUserInfo(UserBean userBean);

}
