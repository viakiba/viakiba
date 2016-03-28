package gz.itcast.contactSys_web.servlet;

import gz.itcast.contactSys_web.dao.ContactDao;
import gz.itcast.contactSys_web.dao.impl.ContactDaoImpl;
import gz.itcast.contactSys_web.entity.Contact;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 修改前查询联系人的逻辑
 * @author APPle
 *
 */
public class QueryContactServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.接收id
		String id = request.getParameter("id");
		
		//2.调用dao根据id查询联系人的方法
		ContactDao dao = new ContactDaoImpl();
		Contact contact = dao.findById(id);
		
		//3.把联系人显示到浏览器中
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		String html = "";
		
		html += "<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>";
		html += "<html xmlns='http://www.w3.org/1999/xhtml'>";
		html += "<head>";
		html += "<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />";
		html += "<title>修改联系人</title>";
		html += "</head>";
		html += "";
		html += "<body>";
		html += "<center><h3>修改联系人</h3></center>";
		html += "<form action='"+request.getContextPath()+"/UpdateContactServlet' method='post'>";
		//注意：添加id的隐藏域
		html += "<input type='hidden' name='id' value='"+contact.getId()+"'/>";
		html += "<table align='center' border='1' width='300px'>";
		html += "    <tr>";
		html += "    	<th>姓名</th>";
		html += "        <td><input type='text' name='name' value='"+contact.getName()+"'/></td>";
		html += "    </tr>";
		html += "    <tr>";
		html += "    	<th>性别</th>";
		html += "        <td>";
		
		if(contact.getGender().equals("男")){
			html += "        <input type='radio' name='gender' value='男' checked='checked'/>男";
			html += "        <input type='radio' name='gender' value='女'/>女";
		}else if(contact.getGender().equals("女")){
			html += "        <input type='radio' name='gender' value='男'/>男";
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

		
		
		writer.write(html);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
