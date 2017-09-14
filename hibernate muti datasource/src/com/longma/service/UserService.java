package com.longma.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import com.longma.dao.UserDao;
import com.longma.entity.User;
import com.longma.entity.User2;
import com.longma.utils.JdbcUtil;

@Service
public class UserService {
	
	private static final Map<String,Integer> maps = new HashMap<String,Integer>();
	
	static{
		maps.put("user", 1);
		maps.put("user2", 2);
	}
	@Resource
	private SessionFactory sessionFactory1;
	@Resource
	private SessionFactory sessionFactory2;
	@Resource
	private JdbcUtil jdbcUtil;
	@Resource
	private UserDao userDao;
	
	public Map transPort(int age) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		String queryTableSql = "select table_name from information_schema.tables where table_schema='test1' ";
		List<String> tables = null;
		try {
			tables = jdbcUtil.exquerySql(queryTableSql);
			System.out.println(tables);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map map = new HashMap<>();
		for(String ta : tables){
			String entity = "com.longma.entity."+ta.substring(0, 1).toUpperCase()+ta.substring(1,ta.length());
			Class<?> forName = Class.forName(entity);
			Object o = forName.newInstance();
			Integer flag = maps.get(ta);
			switch (flag) {
			case 1:
				User user = (User) o;
				user.setAge(age);
				user = userDao.queryUser(sessionFactory1, user);
				userDao.addUser(sessionFactory2, user);
				map.put(entity, user);
				break;
			case 2:
				User2 user2 = (User2) o;
				user2.setAge(age);
				map.put(entity, user2);
				break;
			default:
				System.out.println("没有相关的类");
				break;
			}
		}
		return map;
	}
}
