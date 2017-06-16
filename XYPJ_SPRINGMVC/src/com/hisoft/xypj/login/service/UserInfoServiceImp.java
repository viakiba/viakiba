package com.hisoft.xypj.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hisoft.xypj.common.bean.DeleteUserBean;
import com.hisoft.xypj.common.bean.UserInfo;
import com.hisoft.xypj.login.dao.UserInfoDao;

@Service
public class UserInfoServiceImp implements UserInfoService {

	/**
	 * UserInfoDao
	 */
	@Autowired
	private UserInfoDao userInfoDao = null;

	/**
	 * @param userInfoDao
	 *            the userInfoDao to set
	 */
	public void setUserInfoDao(UserInfoDao userInfoDao) {
		this.userInfoDao = userInfoDao;
	}

	@Override
	public UserInfo getUserInfo(UserInfo u) {
		return userInfoDao.getUserInfo(u);
	}

	@Override
	public int addUserInfo(UserInfo u) {
		return userInfoDao.addUserInfo(u);
	}

	@Override
	public List<DeleteUserBean> getUMR() {
		// TODO Auto-generated method stub
		return userInfoDao.getUMR();
	}

	@Override
	public int deleteUser(int userId) {
		// TODO Auto-generated method stub

		return userInfoDao.deleteUser(userId);
	}

	@Override
	public List<UserInfo> getPingShenList() {
		// TODO Auto-generated method stub
		return userInfoDao.getPingShenList();
	}

}
