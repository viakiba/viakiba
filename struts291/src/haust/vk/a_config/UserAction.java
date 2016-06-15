package haust.vk.a_config;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vk
 *
 * 2016年6月13日
 */
public class UserAction extends ActionSupport{
	private String userName;

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String login(){
		System.out.println("UserAction.login()"+userName);
		return "login";
	}
	
	public String register(){
		System.out.println("register()"+userName);
		return "register";
	}
}
