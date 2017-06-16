package com.hisoft.xypj.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hisoft.xypj.common.bean.UserInfo;
import com.hisoft.xypj.login.service.UserInfoService;

@Controller
@RequestMapping(value = "/users")
public class UsersController {
	@Autowired
	private UserInfoService infoService;

    @RequestMapping("/getUsers")
    public String getUsers(HttpServletRequest req, HttpServletResponse res,ModelMap model) {
        System.out.println("21231213213");
        UserInfo bean = new UserInfo();
        UserInfo info = infoService.getUserInfo(bean);
        model.addAttribute("name", "2111111111");
        return "user/list";
    }
}
