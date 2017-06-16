package com.tdvm.cjgl.dao;

import java.util.List;

import com.tdvm.cjgl.bean.UserBean;
import com.tdvm.cjgl.entity.BaseUser;
import com.tdvm.common.dao.CommonDao;

public interface LoginDao extends CommonDao {

	/**
	 * 登录验证
	 * @param bean
	 * @return
	 */
	public List<BaseUser> checkUserInfo(UserBean bean);
}
