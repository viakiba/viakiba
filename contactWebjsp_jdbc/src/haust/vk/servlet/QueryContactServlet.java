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
public class QueryContactServlet extends HttpServlet {
@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id=req.getParameter("id");
		
		ContactService service=new ContactServiceImpl();
		Contact contact=service.findById(id);
		
		req.setAttribute("contact", contact);
		
		req.getRequestDispatcher("/updateContact.jsp").forward(req, resp);
}

	@Override
		public void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			doGet(req, resp);
		}
	
}
