package haust.vk.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import haust.vk.service.ContactService;
import haust.vk.service.impl.ContactServiceImpl;

/**
 * @author vk
 *
 * 2016年4月21日
 */
public class DeleteContactServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String id=req.getParameter("id");
		ContactService service=new ContactServiceImpl();
		service.deleteContact(id);
		resp.sendRedirect(req.getContextPath()+"/ListContactServlet");
		
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
