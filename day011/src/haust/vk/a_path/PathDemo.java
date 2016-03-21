package haust.vk.a_path;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PathDemo extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码
		response.setContentType("text/html;charset=utf-8");
		/*
		 * 转发
		 */
		
		//request.getRequestDispatcher("/target.html").forward(request, response);
		
		/*
		 * 请求重定向
		 */
		
		//response.sendRedirect("/day011/target.html");
		
		/*
		 * html的超链接
		 */
		
		//response.getWriter().write("<html><head><title>target</title></head><body> <a href='/day11/target.html'>目标链接</a> </body>  </html>  ");
		
		/*
		 * html 的form 提交
		 */
		
		//response.getWriter().write("<html><body><form action='/day011/target.html'> <input type='submit' />  </form></body></html>");
		
		/*
		 * 
		 */
	}
}
