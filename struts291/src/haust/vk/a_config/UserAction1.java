package haust.vk.a_config;


/**
 * @author vk
 *
 * 2016年6月13日
 */
public class UserAction1{
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
