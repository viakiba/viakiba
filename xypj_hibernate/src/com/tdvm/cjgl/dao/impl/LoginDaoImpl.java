package com.tdvm.cjgl.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tdvm.base.UpdateConst;
import com.tdvm.cjgl.bean.UserBean;
import com.tdvm.cjgl.dao.LoginDao;
import com.tdvm.cjgl.entity.BaseUser;
import com.tdvm.common.dao.impl.CommonDaoImpl;


/**
 * 
 */
@Repository
public class LoginDaoImpl extends CommonDaoImpl implements LoginDao {

	public List<BaseUser> checkUserInfo(UserBean userBean) {

		List<String> params = new ArrayList<String>();
		params.add(userBean.getUserName());
		params.add(userBean.getPassword());

		@SuppressWarnings("unchecked")
		List<BaseUser> list = (List<BaseUser>) getListByHQL(
				"from BaseUser where userName =? and password = ?", params.toArray(),
				null);

		return list;
	}

}
