package haust.vk.provincecity;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProvinceCityServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String province = req.getParameter("province");
		//
		System.out.println(province);
		PrintWriter pw = resp.getWriter();
		pw.write("<?xml version='1.0' encoding='UTF-8'?>");
		pw.write("<root>");
		
		if("广东".equals(province)){
			pw.write("<city>广州</city>");
			pw.write("<city>深圳</city>");
			pw.write("<city>中山</city>");
		}else if("湖南".equals(province)){
			pw.write("<city>长沙</city>");
			pw.write("<city>株洲</city>");
			pw.write("<city>湘潭</city>");
			pw.write("<city>岳阳</city>");
		}
		
		pw.write("</root>");
		pw.flush();
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String province = req.getParameter("province");
		//
		resp.setContentType("text/xml;charset=UTF-8");
		System.out.println(province);
		PrintWriter pw = resp.getWriter();
		pw.write("<?xml version='1.0' encoding='UTF-8'?>");
		pw.write("<root>");
		
		if("广东".equals(province)){
			pw.write("<city>广州</city>");
			pw.write("<city>深圳</city>");
			pw.write("<city>中山</city>");
		}else if("湖南".equals(province)){
			pw.write("<city>长沙</city>");
			pw.write("<city>株洲</city>");
			pw.write("<city>湘潭</city>");
			pw.write("<city>岳阳</city>");
		}
		
		pw.write("</root>");
		pw.flush();
		pw.close();
	}
}
