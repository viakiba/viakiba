package com.example.demo.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UserinfoDao;

/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月12日
 */

@RestController
@RequestMapping("")
public class TestMybatis {
	@Resource
	private UserinfoDao userinfoDao;
	
	@RequestMapping("/getuser")
	public String getUserinfo() {
		String map = userinfoDao.selectUser();
		System.out.println(map);
		return "/hello";
	}
}
