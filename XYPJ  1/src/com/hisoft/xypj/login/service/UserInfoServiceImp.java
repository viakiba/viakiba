package com.hisoft.xypj.login.service;

import java.util.List;

import com.hisoft.xypj.login.bean.UserInfo;
import com.hisoft.xypj.login.dao.UserInfoDao;

public class UserInfoServiceImp implements UserInfoService {

	/**
	 * UserInfoDao
	 */
	private UserInfoDao userInfoDao = null;
	
	/**
	 * @param userInfoDao the userInfoDao to set
	 */
	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	@Override
	public UserInfo getUserInfo(UserInfo u) {
		
		return userInfoDao.getUserInfo(u);
	}

	@Override
	public List<UserInfo> getUserInfoList(UserInfo u) {
		
		
		return userInfoDao.getUserInfoList(u);
	}
}
