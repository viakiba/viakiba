package haust.vk.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String username = req.getParameter("username");
		byte[] buf = username.getBytes("ISO8859-1");
		System.out.print("username="+username);
		String tip = "<font color='green'>可以注册</font>";
		if("杰克".equals(username)){
			tip="<font color='red'>该用户已存在</font>";
		}
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		pw.write(tip);
		pw.flush();
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		System.out.print("username="+username);
		String tip = "<font color='green'>可以注册</font>";
		if("杰克".equals(username)){
			tip="<font color='red'>该用户已存在</font>";
		}
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		pw.write(tip);
		pw.flush();
		pw.close();
	}
}
