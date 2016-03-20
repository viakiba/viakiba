package haust.viakiba.f_context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 保存数据
 * @author APPle
 *
 */

public class ContextDemo3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//得到域对象
		ServletContext context=this.getServletContext();
		//存数据
		context.setAttribute("stu", new Student("eric",20));
		System.out.println("放入成功");
	}
}

class Student{
	private String name;
	private int age;
	
	public Student(String str,int age){
		super();
		this.age=age;
		this.name=str;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	
}
