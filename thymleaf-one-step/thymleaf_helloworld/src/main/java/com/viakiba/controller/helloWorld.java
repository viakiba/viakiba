package com.viakiba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class helloWorld {

    @RequestMapping("index")
    public ModelAndView index(ModelAndView modelAndView){

        modelAndView.addObject("index","hello world");
        modelAndView.setViewName("index");

        return modelAndView;
    }
}
