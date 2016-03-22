package haust.vk.session;

import java.io.IOException;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html;utf-8");
		String name=req.getParameter("user");
		String pass=req.getParameter("password");
		//System.out.println(name+pass);//测试
		
		/*分析，这里可以有几个域可以使用
		 * context域：特点，公用的有覆盖的风险，存在服务器端。
		 * request域：智能依靠转发技术来传递登陆信息（尝试）
		 * session域：
		 */
		if("eric".equals(name)&&"123456".equals(pass)){
			/*req.setAttribute("Loginname", name);
			
			req.getRequestDispatcher("/Index").forward(req, resp);//转发才行
*/			
			//resp.sendRedirect(req.getContextPath()+"/Index");  重定向传不出去
			
			HttpSession session=req.getSession();
			session.setAttribute("name", name);
			resp.sendRedirect(req.getContextPath()+"/Index");
			
			System.out.println(req.getContextPath());
		}else{
			resp.sendRedirect(req.getContextPath()+"/Fail.html");
		}
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
