package com.hisoft.xypj.login.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.hisoft.xypj.common.bean.DeleteUserBean;
import com.hisoft.xypj.common.bean.UserInfo;

@Repository
public class UserInfoDaoImp extends SqlSessionDaoSupport implements UserInfoDao {

	@Override
	public UserInfo getUserInfo(UserInfo u) {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectOne("User.getUserInfo", u);

	}

	@Override
	public int addUserInfo(UserInfo u) {
		// TODO Auto-generated method stub
		return this.getSqlSession().insert("User.addUserInfo", u);

	}

	@Override
	public List<DeleteUserBean> getUMR() {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList("User.getUMR");
	}

	@Override
	public int deleteUser(int userId) {

		return this.getSqlSession().delete("User.deleteUser", userId);
	}

	@Override
	public List<UserInfo> getPingShenList() {
		// TODO Auto-generated method stub
		return this.getSqlSession().selectList("User.getPingShenList");
	}

}
