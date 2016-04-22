package haust.vk.servlet;

import haust.vk.entity.Contact;
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
public class ListContactServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		ContactService service=new ContactServiceImpl();
		List<Contact> list = service.findAll();
		
		req.setAttribute("contacts", list);
		
		req.getRequestDispatcher("/listContact.jsp").forward(req, resp);
		
		
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
