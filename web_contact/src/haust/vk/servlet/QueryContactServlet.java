package haust.vk.servlet;

import haust.vk.dao.dao.ContactDao;
import haust.vk.entity.Contact;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QueryContactServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String uuid=req.getParameter("id");
		
		ContactDao dao=new ContactDao();
		Contact contact=dao.findById(uuid);
				
		String html="";
		html+="<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' ' http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>";
		html+=" <html xmlns='http://www.w3.org/1999/xhtml'> ";
		html+=" <head> ";	
		html+="<meta http-equiv='Content-Type' content='text/html; charset=utf-8' /> ";	
		html+="<title>修改联系人</title> ";	
		html+="</head>  ";	
		html+="   ";	
		html+="<body> ";	
		html+=" <center><h3>修改联系人</h3></center> ";	
		html+="<form action='"+req.getContextPath()+"/UpdataContactServlet"+"' method='post'> ";	
		html+="<input type='hidden' name='id' value='"+req.getParameter(uuid)+"'/>  ";	
		
		html+=" <table align='center' border='1' width='300px'> ";	
		html+=" <tr><th>姓名</th><td><input type='text' name='name' value='"+contact.getName()+"'/></td></tr>";	
		html += "    <tr>";
		html += "    	<th>性别</th>";
		html += "        <td>";
		if(contact.getGender().equals("男")){
			html += "        <input type='radio' name='gender' value='男' checked='checked'/>男";
			html += "        <input type='radio' name='gender' value='女'/>女";
		}else if(contact.getGender().equals("女")){
			html += "        <input type='radio' name='gender' value='男' />男";
			html += "        <input type='radio' name='gender' value='女' checked='checked'/>女";	
		}else{
			html += "        <input type='radio' name='gender' value='男' checked='checked'/>男";
			html += "        <input type='radio' name='gender' value='女'/>女";		
		}
		
		html += "        </td>";
		html += "    </tr>";
		html += "    <tr>";
		html += "    	<th>年龄</th>";
		html += "        <td><input type='text' name='age' value='"+contact.getAge()+"'/></td>";
		html += "    </tr>";
		html += "    <tr>";
		html += "    	<th>电话</th>";
		html += "        <td><input type='text' name='phone' value='"+contact.getPhone()+"'/></td>";
		html += "    </tr>";
		html += "    <tr>";
		html += "    	<th>邮箱</th>";
		html += "        <td><input type='text' name='email' value='"+contact.getEmail()+"'/></td>";
		html += "    </tr>";
		html += "    <tr>";
		html += "    	<th>QQ</th>";
		html += "        <td><input type='text' name='qq' value='"+contact.getQq()+"'/></td>";
		html += "    </tr>";
		
		html += "    <tr>";
		html += "        <td colspan='2' align='center'>";
		html += "        <input type='submit' value='保存'/>&nbsp;";
		html += "        <input type='reset' value='重置'/></td>";
		html += "    </tr>";
		html += "</table>";
		html += "</form>";
		html += "</body>";
		html += "</html>";
		PrintWriter writer=resp.getWriter();
		writer.write(html);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
