package viakiba.haust.e_thread;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThreadDemo extends HttpServlet {
	int count =0 ;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			resp.setContentType("text/html;charset=utf-8");			
			synchronized (ThreadDemo.class) {//锁对象必须唯一。建议使用类对象
				resp.getWriter().write("你现在是当前网站的第"+count+"个访客");   //线程1执行完  ， 线程2执行
			}
	}
}
