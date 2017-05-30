package haust.vk.controller;

import haust.vk.entity.User;
import haust.vk.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by viakiba on 2017/5/30.
 */
@Controller
public class TestController {
    @Resource
    private TestService testServiceImpl;

    @RequestMapping("/scqsb")
    public @ResponseBody
    Map testMap() {
        HashMap map = new HashMap();
        map.put("test", "test");
        return map;
    }

    @RequestMapping("/code")
    public String code(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession s = req.getSession();
        String code = (String) s.getAttribute("code");
        String code1 = req.getParameter("code");
        System.out.println(code1 + "############");

        List<Map> maps = testServiceImpl.selectTest();
        System.out.println(maps+"dsadsadasdsa*************^^^^^^^^^^^^^^^^^^^^^^^6");


        String kaptchaExpected = (String) req.getSession().getAttribute("kap");
        System.out.println(kaptchaExpected + "&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        System.out.println("进入");
        User user = new User();
        user.setAge("sda");
        user.setUsername("阿四实打实");
        System.out.println(user.toString());
        req.setAttribute("user", user);
        req.setAttribute("age", "12");
        req.setAttribute("username", "dada");
        return "index";
    }

    @RequestMapping("/test")
    public String testMapHaha(HttpServletRequest req, HttpServletResponse resp) {
        User user = new User();
        user.setAge("sda");
        user.setUsername("阿四实打实");
        System.out.println(user.toString());
        req.setAttribute("user", user);
        req.setAttribute("age", "12");
        req.setAttribute("username", "dada");
        return "index";
    }

    @RequestMapping("/")
    public String welcomelist(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入");
        User user = new User();
        user.setAge("sda");
        user.setUsername("阿四实打实");
        System.out.println(user.toString());
        req.setAttribute("user", user);
        req.setAttribute("age", "12");
        req.setAttribute("username", "dada");
        return "index";
    }
}
