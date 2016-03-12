package haust.viakiba;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 案例- content-Type作用
 * @author APPle
 *
 */
public class ResponseDemo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 设置响应实体内容编码
		 */
		//response.setCharacterEncoding("utf-8");
		
		/**
		 * 1. 服务器发送给浏览器的数据类型和内容编码
		 */
		//response.setHeader("content-type", "text/html");
		response.setContentType("text/html;charset=utf-8");//和上面代码等价。推荐使用此方法
		//response.setContentType("text/xml");
		//response.setContentType("image/jpg");

		
		//response.getWriter().write("<html><head><title>this is tilte</title></head><body>中国</body></html>");
		response.getOutputStream().write("<html><head><title>this is tilte</title></head><body>中国</body></html>".getBytes("utf-8"));

		
		/*File file = new File("e:/mm.jpg");
		*//**
		 * 设置以下载方式打开文件
		 *//*
		response.setHeader("Content-Disposition", "attachment; filename="+file.getName());
		*//**
		 * 下载图片
		 *//*
		*//**
		 * 发送图片
		 *//*
		FileInputStream in = new FileInputStream(file);
		byte[] buf = new byte[1024];
		int len = 0;
		
		//把图片内容写出到浏览器
		while( (len=in.read(buf))!=-1 ){
			response.getOutputStream().write(buf, 0, len);
		}*/
	}

}
