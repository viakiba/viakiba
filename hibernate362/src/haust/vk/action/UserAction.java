package haust.vk.action;

import com.opensymphony.xwork2.ActionSupport;

import haust.vk.service.UserService;

public class UserAction extends ActionSupport{
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String execute() {
		userService.save();
		return SUCCESS;
	}
}
