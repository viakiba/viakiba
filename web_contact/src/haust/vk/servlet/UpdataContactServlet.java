package haust.vk.servlet;

import haust.vk.dao.dao.ContactDao;
import haust.vk.entity.Contact;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdataContactServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		ContactDao dao=new ContactDao();
		Contact contact=new Contact();
		
		contact.setEmail(req.getParameter("eamil"));
		contact.setGender(req.getParameter("gender"));
		contact.setId(req.getParameter("id"));
		contact.setAge(Integer.parseInt( req.getParameter("age")));
		contact.setName(req.getParameter("name"));
		contact.setPhone(req.getParameter("phone"));
		contact.setQq(req.getParameter("qq"));
		
		
		resp.sendRedirect(req.getContextPath()+"/ListContactServlet");
		
		dao.updateContact(contact);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
