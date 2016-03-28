package gz.itcast.contactSys_web.servlet;

import gz.itcast.contactSys_web.dao.ContactDao;
import gz.itcast.contactSys_web.dao.impl.ContactDaoImpl;
import gz.itcast.contactSys_web.entity.Contact;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 修改联系人的逻辑
 * @author APPle
 *
 */
public class UpdateContactServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//1.接收参数
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String qq = request.getParameter("qq");
		
		//封装成Contact对象
		Contact contact = new Contact();
		contact.setId(id);
		contact.setName(name);
		contact.setGender(gender);
		contact.setAge(Integer.parseInt(age));
		contact.setPhone(phone);
		contact.setEmail(email);
		contact.setQq(qq);
		
		//2.调用dao修改联系人的方法
		ContactDao dao = new ContactDaoImpl();
		dao.updateContact(contact);
		
		//3.跳转到查询联系人的页面
		response.sendRedirect(request.getContextPath()+"/ListContactServlet");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
