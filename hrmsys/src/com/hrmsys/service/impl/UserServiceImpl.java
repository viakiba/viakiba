package com.hrmsys.service.impl;
/**
 * @author sux
 * @date 2011-1-9
 */
import java.util.List;

import net.sf.json.JSONArray;
import com.hrmsys.bean.PageBean;
import com.hrmsys.bean.UserBean;
import com.hrmsys.dao.UserDAO;
import com.hrmsys.enums.StaticValue;
import com.hrmsys.model.User;
import com.hrmsys.service.UserService;

public class UserServiceImpl implements UserService{
	private UserDAO userDAO;

	@Override
	public List<User> validateUser(String username, String password) {		
		List<User> users = userDAO.findByUsernameAndPassword(username, password);
		return users;
	}
	
	@Override
	public String list(String start, String limit) {
		PageBean pageBean = userDAO.findAll(start, limit);
		String json = JSONArray.fromObject(pageBean.getRoot()).toString();
		return "{totalProperty:"+pageBean.getTotalProperty()+",root:"+json+"}";
	}
	
	@Override
	public String getUserByCondition(UserBean userBean, String start, String limit) {
		PageBean pageBean = userDAO.findByCondition(userBean, start, limit);
		String json = JSONArray.fromObject(pageBean.getRoot()).toString();
		return "{totalProperty:"+pageBean.getTotalProperty()+",root:"+json+"}";
	}
	@Override
	public String deleteByIds(String ids) {
		String[] userIds = ids.split(",");
		if(userDAO.deleteByIds(userIds)){
			return StaticValue.DELETE_SUCCESS;
		}
		return StaticValue.DELETE_FAILURE;
	}
	
	@Override
	public String save(User user) {
		if(userDAO.saveOrUpdate(user)){
			return StaticValue.SAVE_SUCCESS;
		}
		return StaticValue.SAVE_FAILURE;
	}
	
	@Override
	public String getById(String userId) {
		List<User> users = userDAO.findById(Integer.parseInt(userId));
		return JSONArray.fromObject(users).toString();
	}
	
	@Override
	public String update(User user) {
		List<User> users = userDAO.findById(user.getUserId());
		if(null != users){
			User newUser = users.get(0);
			newUser.setRole(user.getRole());
			newUser.setUserRemark(user.getUserRemark());
			if(userDAO.update(newUser)){
				return StaticValue.UPDATE_SUCCESS;
			}
		}
		return StaticValue.UPDATE_FAILURE;
	}
	
	@Override
	public void updateIPAndTimeById(Integer userId, String userLastIp,
			String userLastTime) {
		List<User> users = userDAO.findById(userId);
		if(users.size() > 0){
			User user = users.get(0);
			user.setUserLastIp(userLastIp);
			user.setUserLastTime(userLastTime);
			userDAO.saveOrUpdate(user);
		}
	}

	/**follow is getter and setter**/
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
