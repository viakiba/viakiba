package com.hrmsys.service;

import java.util.List;

import com.hrmsys.bean.UserBean;
import com.hrmsys.model.User;

public interface UserService {
	/**
	 * 对登录用户进行校验
	 * @param username
	 * @param password
	 * @return 返回查询到的用户
	 */
	List<User> validateUser(String username, String password);
	/**
	 * 用户列表
	 * @return
	 */
	String list(String start, String limit);
	/**
	 * 按条件查询
	 * @param userBean
	 * @return
	 */
	String getUserByCondition(UserBean userBean, String start, String limit);
	/**
	 * 按id删除
	 * @param ids
	 * @return
	 */
	String deleteByIds(String ids);
	/**
	 * 保存
	 * @param user
	 * @return
	 */
	String save(User user);
	/**
	 * 按userId查询
	 * @param userId
	 * @return
	 */
	String getById(String userId);
	/**
	 * 修改
	 * @param user
	 * @return
	 */
	String update(User user);
	/**
	 * 修改登录时间及IP
	 * @param userId
	 * @param remoteAddr
	 * @param stringDateAndTime
	 */
	void updateIPAndTimeById(Integer userId, String userLastIp,
			String userLastTime);

}
