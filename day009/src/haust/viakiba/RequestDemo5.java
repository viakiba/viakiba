package haust.viakiba;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 获取GET方式和Post方式提交的参数
 * @author APPle
 *
 */
public class RequestDemo5 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 设置参数查询的编码
		 * 该方法只能对请求实体内容的数据编码起作用。POST提交的数据在实体内容中，所以该方法对POST方法有效！
		 * GET方法的参数放在URI后面，所以对GET方式无效！！！
		 */
		request.setCharacterEncoding("utf-8");
		
		
	/*	System.out.println("GET方式");
		//接收GET方式提交的参数
		String value = request.getQueryString();
		System.out.println(value);*/
		
		
		/**
		 * 统一方便地获取请求参数的方法
		 */
		System.out.println(request.getMethod()+"方式");
		//getParameter(name): 根据参数名得到参数值(只能获取一个值的参数)
		String name = request.getParameter("name");
		
		/**
		 * 手动重新解码(iso-8859-1 字符串-> utf-8 字符串)
		 */
		/*if("GET".equals(request.getMethod())){
			name = new String(name.getBytes("iso-8859-1"),"utf-8");
		}*/
		
		String password = request.getParameter("password");
		
		/*if("GET".equals(request.getMethod())){
			password = new String(password.getBytes("iso-8859-1"),"utf-8");
		}*/
		
		System.out.println(name+"="+password);
		
		System.out.println("=============================");
		Enumeration<String> enums = request.getParameterNames();
		while( enums.hasMoreElements() ){
			String paramName = enums.nextElement();
			
			//如果参数名是hobit，则调用getParameterValues
			if("hobit".equals(paramName)){
				/**
				 * getParameterValues(name): 根据参数名获取参数值（可以获取多个值的同名参数）
				 */
				System.out.println(paramName+":");
				String[] hobits = request.getParameterValues("hobit");
				for(String h: hobits){
				/*	if("GET".equals(request.getMethod())){
						h = new String(h.getBytes("iso-8859-1"),"utf-8");
					}*/
					System.out.print(h+",");
				}
				System.out.println();
				//如果不是hobit，则调用getParameter
			}else{
				String paramValue = request.getParameter(paramName);
				/*
				if("GET".equals(request.getMethod())){
					paramValue = new String(paramValue.getBytes("iso-8859-1"),"utf-8");
				}*/
				
				System.out.println(paramName+"="+paramValue);
			}
		}
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*System.out.println("POST方式");
		InputStream in = request.getInputStream();
		byte[] buf = new byte[1024];
		int len = 0;
		while(  (len=in.read(buf))!=-1 ){
			System.out.println(new String(buf,0,len));
		}*/
		
		/**
		 * 统一方便地获取请求参数的方法
		 */
		/*System.out.println("POST方式");
		//根据参数名得到参数值
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println(name+"="+password);
		
		System.out.println("=============================");
		Enumeration<String> enums = request.getParameterNames();
		while( enums.hasMoreElements() ){
			String paramName = enums.nextElement();
			String paramValue = request.getParameter(paramName);
			System.out.println(paramName+"="+paramValue);
		}*/
		
		//一定调用doGet方式
		this.doGet(request, response);
	}

}
