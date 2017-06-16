package com.hisoft.xypj.login.dao;

import java.util.List;

import com.hisoft.xypj.common.bean.DeleteUserBean;
import com.hisoft.xypj.common.bean.UserInfo;

public interface UserInfoDao {
	// 登录
	public UserInfo getUserInfo(UserInfo u);

	// 添加用户
	public int addUserInfo(UserInfo u);

	// 查询用户
	public List<DeleteUserBean> getUMR();

	// 查询所有评审员
	public List<UserInfo> getPingShenList();

	// 删除用户
	public int deleteUser(int userId);
}
