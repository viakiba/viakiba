package haust.viakiba;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		requestHeader(request, response);
		
		requestHead(request);
	
	}

	public void requestHead(HttpServletRequest request) {
		/**
		 * 3.2 请求头
		 */
		String host = request.getHeader("Host"); //根据头名称的到头的内容
		System.out.println(host);
		
		//遍历所有请求头
		Enumeration<String> enums = request.getHeaderNames(); //得到所有的请求头名称列表
		while(enums.hasMoreElements()){//判断是否有下一个元素
			String headerName = enums.nextElement(); //取出下一个元素
			String headerValue = request.getHeader(headerName);
			System.out.println(headerName+":"+headerValue);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * 请求实体内容
		 */
		InputStream in=request.getInputStream();
		byte[] buf=new byte[1024];
		int len=0;
		while((len=in.read(buf))!=-1){
			String str=new String(buf,0,len);
			System.out.println(str);
		}
	}
	public void requestHang(HttpServletRequest request) {
		/**
		 * 3.1 请求行   格式：（GET /day09/hello HTTP/1.1）
		 */
		System.out.println("请求方式："+request.getMethod());//请求方式
		System.out.println("URI:"+request.getRequestURI());//请求资源
		System.out.println("URL:"+request.getRequestURL());
		System.out.println("http协议版本："+request.getProtocol());//http协议
	}

	public void requestHeader(HttpServletRequest request,
			HttpServletResponse response) {
		/*
		 * 请求头
		 */
		response.setContentType("text/html");
		String host = request.getHeader("host");
		System.out.println(host);
		
		Enumeration<String> enums=request.getHeaderNames();
		while(enums.hasMoreElements()){
			String headerName=enums.nextElement();
			String headerValue=request.getHeader(headerName);
			System.out.println(headerName+"="+headerValue);
		}
	}

}
