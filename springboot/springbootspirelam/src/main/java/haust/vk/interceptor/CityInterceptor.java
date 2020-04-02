package haust.vk.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CityInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String city = request.getParameter("city");
		if("1".equals(city)){
			request.setAttribute("city", "cityisok");
			System.out.println("city ok");
			return true;
		}else{
			System.out.println("city not ok");
			request.setAttribute("city", "citynotok");
			PrintWriter pw = response.getWriter();
			pw.write("city not ok");
			return false;
		}
	}
	
}
