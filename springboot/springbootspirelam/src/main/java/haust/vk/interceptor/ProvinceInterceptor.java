package haust.vk.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ProvinceInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String province = request.getParameter("province");
		if("1".equals(province)){
			request.setAttribute("province", "provinceisok");
			System.out.println("province ok");
			return true;
		}else{
			System.out.println("province not ok");
			request.setAttribute("province", "provincenotok");
			PrintWriter pw = response.getWriter();
			pw.write("province not ok");
			return false;
		}
	}
	
	
}
