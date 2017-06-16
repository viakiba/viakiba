package com.tdvm.cjgl.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tdvm.base.UpdateConst;
import com.tdvm.cjgl.bean.UserBean;
import com.tdvm.cjgl.service.LoginService;
import com.tdvm.tool.ControlUtil;

@Controller
@Scope("session")
public class LoginControl {

	private static final Logger log = LoggerFactory.getLogger(LoginControl.class);

	@Autowired
	private LoginService loginService;

	@RequestMapping("/Login/index.do")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		return "login/login";
	}

	@RequestMapping("/Login/checkUserInfo.do")
	public String checkUserInfo(HttpServletRequest request, HttpServletResponse response, UserBean bean,ModelMap model) {

		log.info("收到[" + bean.getUserName() + "]用户登录系统请求");

		log.debug("LoginInfo:" + ControlUtil.toJsonStr(bean));
	//	bean.setUserType(UpdateConst.DICT_USERINFO_TYPE_ADMIN);
		UserBean ub = loginService.checkUserInfo(bean);
		if (UpdateConst.RESULT_BEAN_STATE_PASS.equals(ub.getState())) {
			HttpSession session = request.getSession();
			if (session.getAttribute(UpdateConst.SESSION_USER_NAME) != null) {
				session.removeAttribute(UpdateConst.SESSION_USER_NAME);
			}
			session.setAttribute(UpdateConst.SESSION_USER_NAME, ub);
		} else {
			model.put("msg", ub.getData());
			return "login/login";
		}
		    model.put("ub", ub);
		    return "main/main";
		   
		//ControlUtil.writeJsonData(response, ControlUtil.toJsonStr(ub));
	}
    
    public static String convert(long second){
    	long h = 0;
    	long d = 0;
    	long s = 0;
    	long temp = second%3600;
    	       if(second>3600){
    	         h= second/3600;
    	              if(temp!=0){
    	         if(temp>60){
    	         d = temp/60;
    	      if(temp%60!=0){
    	         s = temp%60;
    	      }
    	      }else{
    	         s = temp;
    	      }
    	     }
    	    }else{
    	        d = second/60;
    	     if(second%60!=0){
    	        s = second%60;
    	     }
    	    }

    	   return h+"时"+d+"分"+s+"秒";
    	}
}
