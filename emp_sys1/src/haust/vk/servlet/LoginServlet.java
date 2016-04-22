package haust.vk.servlet;

import haust.vk.entity.Admin;
import haust.vk.service.IAdminService;
import haust.vk.service.impl.AdminService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author vk
 *
 * 2016年4月22日
 */
public class LoginServlet extends HttpServlet {
	private IAdminService ia=new AdminService();
	private String uri="";
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userName=req.getParameter("userName");
		String pwd=req.getParameter("pwd");
		Admin admin=new Admin();
		admin.setPwd(pwd);
		admin.setUserName(userName);
		try {
			Admin loginInfo = ia.findByNameAndPwd(admin);
			if(loginInfo == null){
				uri="/login.jsp";
			}else{
				req.getSession().setAttribute("loginInfo", loginInfo);
				
				uri="/index";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			uri="/error.jsp";
		}
		req.getRequestDispatcher(uri).forward(req, resp);
	}
}
