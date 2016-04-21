package haust.vk.servlet;

import haust.vk.entity.Contact;
import haust.vk.service.ContactService;
import haust.vk.service.impl.ContactServiceImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author vk
 *
 * 2016年4月21日
 */
public class UpdateContactServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String qq = req.getParameter("qq");
		Contact contact=new Contact();
		contact.setId(id);
		contact.setName(name);
		contact.setGender(gender);
		contact.setAge(Integer.parseInt(age));
		contact.setPhone(phone);
		contact.setEmail(email);
		contact.setQq(qq);
		
		ContactService service=new ContactServiceImpl();
		service.updateContact(contact);
		
		resp.sendRedirect(req.getContextPath()+"/ListContactServlet");
		
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
