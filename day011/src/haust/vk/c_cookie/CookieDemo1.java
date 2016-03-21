package haust.vk.c_cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieDemo1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cookie cookie=new Cookie("haha","papapa");
		
		Cookie cookie1=new Cookie("hoho","sadad");
		
		cookie.setPath("/day011");
		cookie1.setPath("/day011");
		
		/*resp.addCookie(cookie);		
		String name=req.getHeader("Cookie");*/
//		resp.setHeader("set-cookie", cookie.getName()+"="+cookie.getValue());
		
		resp.addCookie(cookie1);
		resp.addCookie(cookie);
		
		Cookie[] cookies=req.getCookies();
		if(cookies!=null)
		{
			for(int i=0;i<cookies.length;i++){		
			System.out.println(cookies[i].getName()+"="+cookies[i].getValue());
			}
		}else{
			System.out.println("没有");
		}
		
		//System.out.println("添加成功");
		
		
		
		
	}
}
