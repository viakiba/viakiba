package haust.vk.b_action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vk
 *
 * 2016年6月13日
 */
public class HelloAction extends ActionSupport {
	public HelloAction (){
		System.out.println("创建Action实例：HelloAction.HelloAction()");
	}
	
	public String add() throws Exception{
		System.out.println("访问到了action，正在处理请求");
		System.out.println("调用service");
		return "success";
	}
}
