package haust.viakiba.f_context;


import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextDemo1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//ServletContext 对象的获取
		ServletContext servletPath=this.getServletContext();
		
		//得到web的应用路径
		String str=servletPath.getContextPath();
		System.out.println(str);
		//应用到重定向
		resp.sendRedirect(str+"/index.html");
	}
}
