package com.longma.restcontroller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.longma.service.UserService;

@Controller
@RequestMapping("")
public class UserApi {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/getuser")
	public @ResponseBody Map getMap(int age) throws Exception, InstantiationException, ReflectiveOperationException{
		return userService.transPort(age);
	}
	
	
}
