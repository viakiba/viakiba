package haust.vk.servlet;

import haust.vk.dao.dao.ContactDao;
import haust.vk.entity.Contact;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteContactServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id=req.getParameter("id");
		ContactDao dao=new ContactDao();
		dao.deleteContact(id);
		
		resp.sendRedirect(req.getContextPath()+"/ListContactServlet");
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
