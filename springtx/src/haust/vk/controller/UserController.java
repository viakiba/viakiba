package haust.vk.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import haust.vk.service.UserService;

@RestController
public class UserController {
	@Resource
	private UserService userServiceImpl;
	
	@RequestMapping("/")
	public Map test(HttpServletRequest req,HttpServletResponse resp){
		Map map = new HashMap<>();
		
		map.put("username", "测试test");
		map.put("uid", 1);
		
		resp.setHeader("test", "tests");
		return map;
	}
	
	/**
	 * test1  与  test2  比对了  read-only  标签的作用  
	 * @Author : viakiba
	 * @return
	 * 2017-04-14
	 */
	@RequestMapping("/test1")
	public List<Map> test1(){
		return userServiceImpl.selectListUser1();
	}
	
	@RequestMapping("/test2")
	public Map test2(){
		Map map = new HashMap<>();
		map.put("username", "测试test");
		map.put("uid", 1);
		userServiceImpl.selectListUser2(map);
		return map;
	}
	
	
	/**
	 * （这个还没重现） isolation-level(隔离级别 ):  http://blog.csdn.net/kiwi_coder/article/details/20448769
	 * @Author : viakiba
	 * @return
	 * 2017-04-14
	 */
	@RequestMapping("/test3")
	public Map test3(){
		Map map = new HashMap<>();
		map.put("username", "测试test");
		map.put("uid", 1);
		userServiceImpl.selectListUser2(map);
		return map;
	}
	
	/**
	 * rollback-for:回滚指定的异常
	 * @Author : viakiba
	 * @return
	 * 2017-04-14
	 */
	@RequestMapping("/test4")
	public Map test4(){
		Map map = new HashMap<>();
		map.put("username", "测试test");
		map.put("uid", 1);
		try {
			userServiceImpl.deleteUserById("3");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * propagation:事务传播方式    never  事务失效参考  test1
	 * @Author : viakiba
	 * @return
	 * 2017-04-14
	 * @throws Exception 
	 */
	@RequestMapping("/test5")
	public Map test5(){
		try {
			userServiceImpl.findListUser1();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map map = new HashMap<>();
		map.put("username", "测试test");
		map.put("uid", 1);
		return map;
	}
}
