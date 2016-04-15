package haust.vk.servlet;

import java.io.IOException;

import haust.vk.entity.Employee;
import haust.vk.service.IEmployeeService;
import haust.vk.service.impl.EmployeeService;
import haust.vk.utils.PageBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author vk
 *
 * 2016Äê4ÔÂ15ÈÕ
 */
public class IndexServlet extends HttpServlet {
	private IEmployeeService employeeService = new EmployeeService();
	private String uri;
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String currPage= req.getParameter("currentPage");
			
			if(currPage == null || "".equals("currentPage")){
				currPage= "1";
			}
			
			//
			int currentPage = Integer.parseInt(currPage);
			
			//
			PageBean<Employee> pageBean=new PageBean<Employee>();
			pageBean.setCurrentpage(currentPage);
			//
			employeeService.getAll(pageBean);
			
			//
			req.setAttribute("pageBean", pageBean);
			
			//
			uri="/WEB-INF/list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			uri="/index.jsp";
		}
		req.getRequestDispatcher(uri).forward(req, resp);
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
