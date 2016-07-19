package haust.vk.service;

import haust.vk.dao.UserDao;

public class UserService {
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public void save() {
		userDao.save();
	}
}
