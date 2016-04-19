package day021;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author vk
 *
 * 2016年4月19日
 */
public class HelloFilter2 implements Filter {

	public void init(FilterConfig filterconfig) throws ServletException {
		System.out.println("01.初始化filter");
		String encoding=filterconfig.getInitParameter("encoding");
		
		Enumeration<String> value=filterconfig.getInitParameterNames();
		
		while(value.hasMoreElements()){
			String name=filterconfig.getInitParameter(value.nextElement());
			System.out.println(value.nextElement()+"---"+name);
		}
		System.out.println("02.加载filter参数信息");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("03.使用filter进行处理请求");
		
		chain.doFilter(request, response);
		
		System.out.println("04.第二个过滤器执行结束");
		
	}
	
	public void destroy() {
		System.out.println("6.filter被销毁");
	}
}
