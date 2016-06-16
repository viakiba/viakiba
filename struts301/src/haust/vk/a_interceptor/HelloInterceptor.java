package haust.vk.a_interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * @author vk
 * 自定义拦截器
 * 2016年6月16日
 */
public class HelloInterceptor implements Interceptor{
	public HelloInterceptor(){
		System.out.println("创建了拦截器");
	}
	@Override
	public void init() {
		System.out.println("拦截器进行初始化");
	}
	
	public String intercept(ActionInvocation invocation)	throws Exception{
		System.out.println("2.  执行拦截器之前");
		
		String resultFlag = invocation.invoke();
		System.out.println("4. 拦截器，业务处理-结束" + resultFlag);
		
		return resultFlag;
		
	}
	
	
	@Override
	public void destroy() {
		System.out.println("拦截器销毁。。。。。。");
		
	}

	

}
