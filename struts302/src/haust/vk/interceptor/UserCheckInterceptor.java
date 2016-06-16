package haust.vk.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * @author vk
 *
 * 2016年6月16日
 */
public class UserCheckInterceptor extends AbstractInterceptor{

	/**
	 * 拦截器业务处理方法
	 */
	public String intercept(ActionInvocation invocation) throws Exception {
		// 拿到当前执行的方法名：判断，只有当前方法名不是login,就进行验证
		
		// 获取ActionContext对象
		ActionContext ac = invocation.getInvocationContext();
		
		//获取action的代理对象
		ActionProxy proxy = invocation.getProxy();
		//获取当前方法
		String methodName = proxy.getMethod();
		//判断
		if(!"login".equals(methodName)){
			//先获取当前登陆的用户
			Object obj = ac.getSession().get("userInfo");
			if(obj == null){
				//m欸有登陆
				return "input";
			}else{
				//有用户登录
				return invocation.invoke();
			}
		}else{
			//说明当前用户正在登陆
			return invocation.invoke();
		}
		
		
	}
}

