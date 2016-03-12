package haust.viakiba;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 案例- 防止非法链接
 * 这是需要下载的资源
 * @author APPle
 *
 */
public class RequestDemo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		//得到referer头
		String referer = request.getHeader("referer");
		System.out.println("referer="+referer);
		
		/**
		 * 判断非法链接：
		 * 	1）直接访问的话referer=null
		 *  2）如果当前请求不是来自广告   
		 */
		if(referer==null || !referer.contains("/day09/adv.html")){
			response.getWriter().write("当前是非法链接，请回到首页。<a href='/day09/adv.html'>首页</a>");
		}else{
			//正确的链接
			response.getWriter().write("资源正在下载...");
		}
	
	}

}
