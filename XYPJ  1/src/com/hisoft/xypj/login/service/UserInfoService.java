package com.hisoft.xypj.login.service;

import java.util.List;

import com.hisoft.xypj.login.bean.UserInfo;

public interface UserInfoService {

	public UserInfo getUserInfo(UserInfo u);
	
	public List<UserInfo> getUserInfoList(UserInfo u);
}
