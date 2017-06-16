package com.tdvm.cjgl.dao;

import java.util.List;

import com.tdvm.bean.PageInfo;
import com.tdvm.cjgl.bean.UserBean;
import com.tdvm.cjgl.entity.BaseUser;
import com.tdvm.common.dao.CommonDao;

public interface UserDao extends CommonDao{
	
	public List<UserBean> getUserList(UserBean userBean, PageInfo pageInfo);
	public BaseUser getUserById(String id);
}
