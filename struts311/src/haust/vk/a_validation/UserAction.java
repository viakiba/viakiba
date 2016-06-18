package haust.vk.a_validation;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vk
 * 注意：如果要想用struts的数据效验功能，必须继承ActionSupport或实现相关接口
 * 2016年6月17日
 */
public class UserAction extends ActionSupport{
	//数据的自动封装
	private User user=new User();

	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	public String register(){
		System.out.println(user);
		System.out.println(user.getBirth());
		System.out.println(1);
		
		return SUCCESS;
	}
	
	public String list(){
		return SUCCESS;
	}
	
}
