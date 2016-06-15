package haust.vk.d_type;

/**
 * @author vk
 *
 * 2016年6月15日
 */
public class UserAction {
	private User user;
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	public String register(){
		System.out.println(user.getName());
		System.out.println(user.getPwd());
		System.out.println(user.getAge());
		System.out.println(user.getBrith());
		
		return "success";
	}
}
