package haust.vk.a_interceptor;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author vk
 *
 * 2016年6月16日
 */
public class HelloAction extends ActionSupport{
	public HelloAction(){
		System.out.println("1.  action实例已经创建");
		
	}
	
	
	@Override
	public String execute() throws Exception {
		System.out.println("3.  执行请求处理的 方法");
		return super.execute();
	}
}
