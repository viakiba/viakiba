package com.hrmsys.dao;

import java.util.List;

import com.hrmsys.bean.PageBean;
import com.hrmsys.bean.UserBean;
import com.hrmsys.model.User;

public interface UserDAO {
	/**
	 * 依据用户名与密码进行查询
	 * @param username
	 * @param password
	 */
	public List<User> findByUsernameAndPassword(String username, String password);
	/**
	 * 查询所有
	 * @return
	 */
	public PageBean findAll(String start, String limit);
	/**
	 * 按条件查询
	 * @param userBean
	 * @return
	 */
	public PageBean findByCondition(UserBean userBean, String start, String limit);
	/**
	 * 按id删除
	 * @param userId
	 * @return
	 */
	public boolean deleteByIds(String[] userIds);
	/**
	 * 保存或修改
	 * @param user
	 * @return
	 */
	public boolean saveOrUpdate(User user);
	/**
	 * 按id查询
	 * @param userId
	 * @return
	 */
	public List<User> findById(int userId);
	/**
	 * 修改
	 * @param user
	 * @return
	 */
	public boolean update(User user);
	/**
	 * 删除
	 * @param roleId
	 */
	public void deleteByRole(Integer roleId);
}
