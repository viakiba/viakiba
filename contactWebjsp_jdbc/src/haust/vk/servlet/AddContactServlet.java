package haust.vk.servlet;

import haust.vk.entity.Contact;
import haust.vk.exception.NameRepeatException;
import haust.vk.service.ContactService;
import haust.vk.service.impl.ContactServiceImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author vk
 *
 * 2016年4月21日
 */
public class AddContactServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String name=req.getParameter("name");
		String gender=req.getParameter("gender");
		String age=req.getParameter("age");
		String phone=req.getParameter("phone");
		String email=req.getParameter("email");
		String qq=req.getParameter("qq");
		
		Contact contact=new Contact();
		contact.setName(name);
		contact.setGender(gender);
		contact.setAge(Integer.parseInt(age));
		contact.setPhone(phone);
		contact.setEmail(email);
		contact.setQq(qq);
		
		ContactService service=new ContactServiceImpl();
		
		try {
			service.addContact(contact);
		} catch (NameRepeatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("msg", e.getMessage());
			req.getRequestDispatcher("/addContact.jsp").forward(req, resp);
		}
		
		resp.sendRedirect(req.getContextPath()+"/ListContactServlet");
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
