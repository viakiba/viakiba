package haust.vk.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import haust.vk.dao.UserDao;
import haust.vk.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserDao userDao;
	
	@Override
	public List<Map> selectUser(String name) {
		return userDao.selectUser(name);
	}
	
}
