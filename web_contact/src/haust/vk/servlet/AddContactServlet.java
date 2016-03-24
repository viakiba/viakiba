package haust.vk.servlet;

import haust.vk.dao.dao.ContactDao;
import haust.vk.entity.Contact;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddContactServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		Contact contact=new Contact();
		
		contact.setAge(Integer.parseInt(req.getParameter("age")));
		contact.setEmail(req.getParameter("email"));
		contact.setGender(req.getParameter("gender"));
		
		contact.setName(req.getParameter("name"));
		contact.setPhone(req.getParameter("phone"));
		contact.setQq(req.getParameter("qq"));
		
		ContactDao dao=new ContactDao();
		dao.addContact(contact);
		
		resp.sendRedirect(req.getContextPath()+"/ListContactServlet");
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
