package haust.viakiba.f_config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigDemo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String path=this.getServletConfig().getInitParameter("path");
		File file=new File(path);
		
		//读取TXT 文件的文本内容
		BufferedReader bf=new BufferedReader(new FileReader(file));
		String str=null;
		while((str=bf.readLine())!=null){
			System.out.println(str);
		}
		
		Enumeration<String>	enums=this.getServletConfig().getInitParameterNames();
		while(enums.hasMoreElements()){
			String name=enums.nextElement();
			String parameter=this.getServletConfig().getInitParameter(name);
			System.out.println(name+"="+parameter);
		}
		
		String servletName=this.getServletConfig().getServletName();
		System.out.println(servletName);
	}
}
