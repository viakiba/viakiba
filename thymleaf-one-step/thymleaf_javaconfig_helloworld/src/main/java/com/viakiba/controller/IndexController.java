package com.viakiba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("indexs")
    public String indexs(Model model) {
        System.out.println("hello world>>>>>>>>>>>>>>>>>>>>>>>>>>");
        model.addAttribute("index", "Hello World!");
        return "indexs";
    }

    @RequestMapping("index")
    public String index(Model model) {
        System.out.println("hello world<<<<<<<<<<<<<<<<<<<<<<<<<<");
        model.addAttribute("index", "Hello World!");
        return "index";
    }

}
