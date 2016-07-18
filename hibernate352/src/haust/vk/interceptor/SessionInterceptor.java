package haust.vk.interceptor;

import org.hibernate.Session;

import haust.vk.utils.HibernateUtils;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SessionInterceptor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		try {
			Session session=HibernateUtils.getSf();
			
			session.beginTransaction();
			
			String result = invocation.invoke();
			
			session.beginTransaction().commit();
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
}
