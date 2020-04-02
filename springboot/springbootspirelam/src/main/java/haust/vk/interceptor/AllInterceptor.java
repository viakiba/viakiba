package haust.vk.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AllInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String all = request.getParameter("all");
		//信息模拟
		if("1".equals(all)){
			request.setAttribute("all", "allisok");
			System.out.println("all    1");
			return true;
		}else{
			request.setAttribute("all", "allnotok");
			System.out.println("all    0");
			PrintWriter pw = response.getWriter();
			pw.write("all not ok");
			return false;
		}
	}
}
