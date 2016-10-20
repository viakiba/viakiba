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
		req.setCharacterEncoding("UTF-8");
		System.out.println("进入get");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		String tip = "images/MsgSent.gif";
		
		if("哈哈".equals(username) && "123".equals(password)){
			tip="images/MsgErrot.gif";
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
		System.out.println("进入post");
		doGet(req, resp);
	}
}
