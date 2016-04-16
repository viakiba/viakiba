package haust.vk.b_cases;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author vk
 *
 * 2016年4月16日
 */
public class LoginTag extends SimpleTagSupport{
	private String username;
	private String password;
	
	
	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void doTag() throws javax.servlet.jsp.JspException ,java.io.IOException {
		
		HttpServletResponse response=(HttpServletResponse)((PageContext)this.getJspContext()).getResponse();
		response.setContentType("text/html;charset=utf-8");
		String html="";
		html+="<table border='1' align='center'>                                       ";
	    html+="	<tr>                                                                  ";
	    html+="		<th>用户名</th>                                                    ";
	    html+="		<td><input type='text' username='"+username+"'/></td>                      ";
	    html+="	</tr>                                                                  ";
	    html+="	<tr>                                                                   ";
	    html+="		<th>密码</th>                                                     ";
	    html+="	<td><input type='password' password='"+password+"'/></td>                 ";
	    html+="	</tr>                                                                 ";
	    html+="	<tr >                                                                  ";
	    html+="	<td colspan='2' align='center'><input type='submit' value='提交'/>  ";
	    html+="		&nbsp; &nbsp;<input type='reset' name='重置'/></td>                 ";
	    html+="	</tr>                                                                  ";
	    html+="</table>   ";
	    JspWriter out=this.getJspContext().getOut();
	    out.write(html);
		
	}
}
