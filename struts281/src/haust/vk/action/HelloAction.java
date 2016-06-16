package haust.vk.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vk
 *
 * 2016年6月13日
 */
public class HelloAction extends ActionSupport{
	
	public String execute()throws Exception {
		
		System.out.println("访问到了action，正在处理请求");
		System.out.println("调用seervice");
		
		return "success";
	}
}
