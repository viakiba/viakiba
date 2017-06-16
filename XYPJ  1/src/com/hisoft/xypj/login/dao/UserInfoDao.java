package com.hisoft.xypj.login.dao;

import java.util.List;

import com.hisoft.xypj.login.bean.UserInfo;

public interface UserInfoDao {

	public UserInfo getUserInfo(UserInfo user);
	
	public List<UserInfo> getUserInfoList(UserInfo user);
}
