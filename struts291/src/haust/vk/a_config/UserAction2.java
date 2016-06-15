package haust.vk.a_config;

import com.opensymphony.xwork2.Action;

/**
 * @author vk
 *
 * 2016年6月13日
 */
public class UserAction2 implements Action{
	private String userName;

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String login(){
		System.out.println("UserAction.login()"+userName);
		return "login";
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("");
		return "login";
	}
	public String register(){
		System.out.println("register()"+userName);
		return "register";
	}
}
