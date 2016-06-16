package haust.vk.c_action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vk
 *
 * 2016年6月13日
 */
public class UserAction extends ActionSupport{
	
	public UserAction(){
		System.out.println("UserAction.enclosing_method()");
	}
	
	private User user=new User();
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
	public String login()throws Exception{
		System.out.println(user.getUserName());
		System.out.println(user.getPwd());
		
		//把数据保存到域中
		ActionContext ac = ActionContext.getContext();
		
		//得到代表request的map
		Map<String, Object> request = ac.getContextMap();
		//得到代表session的map
		Map<String, Object> session = ac.getSession();
		//得到代表servletContext的map
		Map<String, Object> application = ac.getApplication();
		
		//保存
		request.put("request_data", "request_data");
		session.put("session_data", "session_data");
		application.put("application_data", "application_data");
		
		return "login";
	}
}
