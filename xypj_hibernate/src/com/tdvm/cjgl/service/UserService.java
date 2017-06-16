package com.tdvm.cjgl.service;

import java.util.List;

import com.tdvm.bean.PageInfo;
import com.tdvm.cjgl.bean.UserBean;
import com.tdvm.cjgl.entity.BaseUser;

public interface UserService {
	public List<UserBean> getUserList(UserBean userBean, PageInfo pageInfo);
	public String insertUser(BaseUser user);
	public void updateUser(UserBean userBean);
	public void deleteUser(UserBean userBean);
	public UserBean getUserById(String id);
}
