package haust.vk.d_session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionDemo2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		if(session==null){
			System.out.println("没有相应的session");
			
		}
		resp.addCookie(new Cookie("JSESSION",session.getId()));
		System.out.println("添加成功");
		
		Cookie[] cookies=req.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies){
			System.out.println(cookie.getName()+cookie.getValue());
			}
		}
		String str=(String)session.getAttribute("ha");
		System.out.println(str);
	}
}
