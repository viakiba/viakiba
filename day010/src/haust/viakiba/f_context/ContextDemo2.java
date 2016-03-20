package haust.viakiba.f_context;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextDemo2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//得到servletContext对象
		ServletContext servletObject=this.getServletContext();
		//获取对应参数名的配置
		System.out.println("参数"+servletObject.getInitParameter("BBB"));
		//获取所有的参数及配置
	Enumeration<String> enums=servletObject.getInitParameterNames();
	while(enums.hasMoreElements()){
		String name=enums.nextElement();
		String Servletvalue=servletObject.getInitParameter(name);
		System.out.println(name+"="+Servletvalue);
	}
	//尝试得到ConfigDemo中的servlet参数
	String str=this.getServletConfig().getInitParameter("path");
	System.out.println("path"+"="+str);
	}
}
