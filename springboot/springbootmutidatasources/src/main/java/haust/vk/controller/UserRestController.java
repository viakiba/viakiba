package haust.vk.controller;

import haust.vk.entity.User;
import haust.vk.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(name="/user",method = RequestMethod.GET)
	//@RequestParam用来获得静态的URL请求入参     spring注解时action里用到。
	public User findByName(@RequestParam(value = "userName", required = true) String userName){
		return userService.findByName(userName);
	}
}
