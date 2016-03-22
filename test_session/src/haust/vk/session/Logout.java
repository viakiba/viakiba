package haust.vk.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		HttpSession	session=req.getSession();
		if(session!=null){
		session.removeAttribute("name");
		}
		
		String html="";
		html+="<html>";
		
		html+="<head>";
		html+="<title>";
		html+="主页";
		html+="</title>";
		html+="<body>";
		html+="</h1>已经退出</h1>";
		html+="<h2><a href='"+req.getContextPath()+"/Login.html'>退出</a></h2>";
		html+="</body>";
		html+="</head>";
		
		html+="</html>";
		
		PrintWriter writer=resp.getWriter();
		writer.write(html);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
