package haust.vk.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import haust.vk.dao.cluster.CityDao;
import haust.vk.dao.master.UserDao;
import haust.vk.entity.User;
import haust.vk.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CityDao cityDao;
	
	@Override
	public User findByName(String userName) {
		User user = userDao.findByName(userName);
		user.setCity(cityDao.findByName("温岭市"));
		return user;
	}

}
