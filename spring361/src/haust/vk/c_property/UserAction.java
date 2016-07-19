package haust.vk.c_property;

public class UserAction {
	private UserService userService = new UserService();
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String execute(){
		userService.save();
		return null;
	}
}
