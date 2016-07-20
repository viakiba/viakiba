package haust.vk.d_myaop1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
	private static Object target;
	private static Aop aop;
	
	public static Object getProxyInstance(Object target_,Aop aop_){
		target=target_;
		aop=aop_;
		
		return Proxy.newProxyInstance(
					target.getClass().getClassLoader(), 
					target.getClass().getInterfaces(),
					new InvocationHandler() {
						
						@Override
						public Object invoke(Object proxy, Method method, Object[] args)
								throws Throwable {
							aop.begin();
							
							Object returnValue = method.invoke(target, args);
							
							aop.commit();
							
							
							return returnValue;
						}
					});
	}
}
