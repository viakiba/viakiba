package haust.vk.servlet;

import java.io.IOException;
import java.util.List;

import haust.vk.entity.Employee;
import haust.vk.service.IEmployeeService;
import haust.vk.service.impl.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author vk
 *
 * 2016年4月22日
 */
public class IndexServlet extends HttpServlet {
	private IEmployeeService ie=new EmployeeService();
	private String uri;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			List<Employee> list=ie.getAll();
			req.setAttribute("listEmp", list);
			uri="/list.jsp";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			uri="/error.jsp";
		}
		//
		req.getRequestDispatcher(uri).forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
