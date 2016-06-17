package haust.vk.ongl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vk
 *
 * 2016年6月17日
 */
public class OnglDemo2 extends ActionSupport {
	 	private User user = new User(100,"Jacks");
	    public User getUser() {
			return user;
		}
	    public void setUser(User user) {
			this.user = user;
		}
	
	public String login() throws Exception {
		//测试迭代标签
		List<User> list = new ArrayList<User>();
		Map<Integer,User> map = new HashMap<Integer,User>();
		
		//初始化
		for(int i=1; i<11 ;i++){
			User user=new User(i,"jack"+i);
			list.add(user);
			map.put(user.getId(), user);
		}
		
		//保存
		ActionContext.getContext().getContextMap().put("list", list);
		ActionContext.getContext().getContextMap().put("map", map);
		
		return "success";
	}
	
	
	
}
