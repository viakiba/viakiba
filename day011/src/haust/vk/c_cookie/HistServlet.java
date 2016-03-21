package haust.vk.c_cookie;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HistServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String curTime=format.format(new Date());
		
		Cookie[] cookies=req.getCookies();
		String lastTime=null;
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if(cookie.getName().equals("lastTime")){
					lastTime=cookie.getValue();
					resp.getWriter().write("上一次访问时间是："+lastTime+"本次访问时间是"+curTime);
					break;
					
				}
			}
		}
		
		if(cookies==null){
			Cookie cookie=new Cookie("lastTime",curTime+"");
			resp.getWriter().write("你当前访问时间是"+curTime);
			cookie.setMaxAge(1*24*60*60*30);
			resp.addCookie(cookie);
			
		}
	}
}
