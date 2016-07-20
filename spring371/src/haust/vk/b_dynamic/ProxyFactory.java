package haust.vk.b_dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 给所有的dao创建代理对象【动态代理】
 * 代理对象，不需要实现接口
 */
public class ProxyFactory {
	private Object target;

	public ProxyFactory(Object target) {
		super();
		this.target = target;
	}
	
	public Object getProxyInstance() {
		
		return Proxy.newProxyInstance(
				target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						System.out.println("开启事务。。。。");
						
						//执行目标程序
						Object returnValue = method.invoke(target, args);
						
						System.out.println("提交事务。。。。");
						
						return returnValue;
					}
				});
	}
}
