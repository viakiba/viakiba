package haust.vk.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import haust.vk.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class TestController {

    @RequestMapping("/")
    public void defaultUrl(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入。。。。。");
        HttpSession s = req.getSession();
        s.setAttribute("sessionname","test");
        User user = new User();
        user.setAge("12");
        user.setUsername("test");
        req.setAttribute("user", user);
        System.out.println(user.toString());
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @RequestMapping("/test")
    public void testUrl(){

    }

}
