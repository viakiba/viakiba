package haust.vk.servlet;

import haust.vk.dao.dao.ContactDao;
import haust.vk.entity.Contact;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListContactServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ContactDao dao=new ContactDao();
		List<Contact> list=dao.findAll();
		
		resp.setContentType("text/html;charset=utf-8");
		String html="";
		
		html += "<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>";
		html += "<html xmlns='http://www.w3.org/1999/xhtml'>";
		html += "<head>";
		html += "<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />";
		html += "<title>查询所有联系人</title>";
		html += "<style type='text/css'>";
		html += "	table td{";
		html += "		/*文字居中*/";
		html += "		text-align:center;";
		html += "	}";
		html += "	";
		html += "	/*合并表格的边框*/";
		html += "	table{";
		html += "		border-collapse:collapse;";
		html += "	}";
		html += "</style>";
		html += "</head>";
		html += "";
		html += "<body>";
		html += "<center><h3>查询所有联系人</h3></center>";
		html += "<table align='center' border='1' width='800px'>";
		html += "	<tr>";
		html += "    	<th>编号</th>";
		html += "        <th>姓名</th>";
		html += "        <th>性别</th>";
		html += "        <th>年龄</th>";
		html += "        <th>电话</th>";
		html += "        <th>邮箱</th>";
		html += "        <th>QQ</th>";
		html += "        <th>操作</th>";
		html += "    </tr>";
		
		if(list!=null){
			for (Contact contact : list) {
				html += "    <tr>";
				html += "    	<td>"+contact.getId()+"</td>";
				html += "        <td>"+contact.getName()+"</td>";
				html += "        <td>"+contact.getGender()+"</td>";
				html += "        <td>"+contact.getAge()+"</td>";
				html += "        <td>"+contact.getPhone()+"</td>";
				html += "        <td>"+contact.getEmail()+"</td>";
				html += "        <td>"+contact.getQq()+"</td>";
				html += "        <td><a href='"+req.getContextPath()+"/QueryContactServlet?id="+contact.getId()+"'>修改</a>&nbsp;<a href='"+req.getContextPath()+"/DeleteContactServlet?id="+contact.getId()+"'>删除</a></td>";
				html += "    </tr>";
			}
		}
		
		html += "    <tr>";
		html += "    	<td colspan='8' align='center'><a href='"+req.getContextPath()+"/addContact.html'>[添加联系人]</a></td>";
		html += "    </tr>";
		html += "</table>";
		html += "</body>";
		html += "</html>";
		
		for(Contact c:list){
			
		}
		
		PrintWriter writer=resp.getWriter();
		writer.write(html);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
