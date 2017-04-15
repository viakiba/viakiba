package haust.vk.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import haust.vk.service.UserService;

@RestController
public class UserController {
	
	@Resource
	private UserService userServiceImpl;
	
	@RequestMapping(value="/listuser")
	public List<Map> getUser(){
		return userServiceImpl.selectUser("haha");
	}
}
