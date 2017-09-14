package com.yuncanting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class TestPage {
    @RequestMapping("testPage")
    public String testHtml(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("hello world<>");
        HttpSession session = req.getSession();
        session.setAttribute("test","session>hello world");
        return "test";
    }
}
