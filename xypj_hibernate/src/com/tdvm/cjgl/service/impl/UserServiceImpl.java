package com.tdvm.cjgl.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tdvm.bean.PageInfo;
import com.tdvm.cjgl.bean.UserBean;
import com.tdvm.cjgl.dao.UserDao;
import com.tdvm.cjgl.entity.BaseUser;
import com.tdvm.cjgl.service.UserService;
import com.tdvm.tool.HelpFunctions;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public List<UserBean> getUserList(UserBean userBean, PageInfo pageInfo) {
		return userDao.getUserList(userBean, pageInfo);
	}

	@Transactional
	public String insertUser(BaseUser user) {
		String md5Password = HelpFunctions.getStringMD5(user.getPassword());
		user.setPassword(md5Password);
		user.setCreateTime(new Date());
		return (String) userDao.create(user);
	}

	@Override
	public void updateUser(UserBean userBean) {
		BaseUser user = userDao.getUserById(userBean.getUserId());
		user.setUserName(userBean.getUserName());
		userDao.update(user);
	}

	@Override
	public void deleteUser(UserBean userBean) {
		userDao.delete(userBean);		
	}
	
	public UserBean getUserById(String id) {
		BaseUser user = userDao.getUserById(id);
		UserBean userBean = new UserBean();
		BeanUtils.copyProperties(user, userBean);
		return userBean;
	}

}
