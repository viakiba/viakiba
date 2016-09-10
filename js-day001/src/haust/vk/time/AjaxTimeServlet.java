package haust.vk.time;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxTimeServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd");
		String time = req.getParameter("time");
		
		System.out.println(sdf.format(new Date()));
		
		//以流的方式将结果响应到AJAX异步对象中
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		pw.write(time);
		pw.flush();
		pw.close();
	}
}
