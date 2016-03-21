package haust.vk.b_resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReaourseDemo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/**
		 *  . 代表java命令运行目录。java运行命令在哪里？？ 在tomcat/bin目录下
		 *   结论： 在web项目中， . 代表在tomcat/bin目录下开始，所以不能使用这种相对路径。
		 */
		
		
		//读取文件。在web项目下不要这样读取。因为.表示在tomcat/bin目录下
		

		
		//读取文件。在web项目下不要这样读取。因为.表示在tomcat/bin目录下
		/*File file = new File("./src/db.properties");
		FileInputStream in = new FileInputStream(file);*/
		
		/**
		 * 使用web应用下加载资源文件的方法
		 */
		/**
		 * 1. getRealPath读取,返回资源文件的绝对路径
		 */
		/*String path=this.getServletContext().getRealPath("/WEB_INF/classes/db.propertues");
		System.out.println(path);
		File file=new File(path);
		FileInputStream in = new FileInputStream(file);*/
		
		/**
		 * 2. getResourceAsStream() 得到资源文件，返回的是输入流
		 */
		InputStream in = this.getServletContext().getResourceAsStream("/WEB_INF/classes/db.propertues");
		Properties p=new Properties();
		
		p.load(in);
		
		String name=p.getProperty("user");
		String pass=p.getProperty("password");
		
		System.out.println("user"+name);
		System.out.println("password"+pass);
		
		
		
		
	}
}
