package haust.vk.b_config;

/**
 * @author vk
 *
 * 2016年6月14日
 */
public class UserAction {
	private String userName;
	
	public void setUserName(String userName){
		this.userName=userName;
	}
	
	public String login(){
		System.out.println("UserAction.login");
		return "success";
	}
	
	public String register(){
		System.out.println("UserAction.register");
		return "success";
	}
}
