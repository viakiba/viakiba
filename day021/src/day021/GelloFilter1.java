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
 * 过滤器的初步探索
 * 
 * @author vk
 *
 * 2016年4月19日
 */
public class GelloFilter1 implements Filter {
	
	public GelloFilter1(){
		System.out.println("1.过滤器的实例已经创建");
	}

	public void destroy() {
		System.out.println("实例被销毁");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		System.out.println("3.执行过滤器业务处理方法");
		//放行（去到servlet）
		//如果有下一个过滤器，进入下一个过滤器，否则就执行访问servlet
		chain.doFilter(request, response);
		
		System.out.println("5.Servlet处理完成又回到过滤器");
	}

	public void init(FilterConfig filterConfig) throws ServletException {

		System.out.println("2.执行过滤器的初始化方法");
		//获取过滤器在web.xml中的配置的初始化参数
		String encoding=filterConfig.getInitParameter("encoding");
		System.out.println(encoding);
		
		//获取过滤器在web.xml中配置的初始化参数的名称
		Enumeration<String> enums=filterConfig.getInitParameterNames();
		while(enums.hasMoreElements()){
			String name=enums.nextElement();
			String value=filterConfig.getInitParameter(name);
			
			System.out.println(name+"\t"+value);
		}
	}

}
