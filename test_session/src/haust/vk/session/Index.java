package haust.vk.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Index extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession name=request.getSession(false);
		
		if(name==null){
			
			response.sendRedirect("/test_session/Login.html");
			return ;
		}
		
		String user=(String)name.getAttribute("name");
		if(user==null){
			response.sendRedirect("/test_session/Login.html");
			return ;
		}
		
		
		//String pass=(String)request.getAttribute("Loginname");
		//System.out.println(pass);//测试
		String html="";
		html+="<html>";
		
		html+="<head>";
		html+="<title>";
		html+="主页";
		html+="</title>";
		html+="<body>";
		html+="</h1>欢迎你的到来："+user+"</h1>";
		html+="<h2><a href='"+request.getContextPath()+"/Logout'>退出</a></h2>";
		html+="</body>";
		html+="</head>";
		
		html+="</html>";
		
		PrintWriter writer=response.getWriter();
		writer.write(html);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}

}
