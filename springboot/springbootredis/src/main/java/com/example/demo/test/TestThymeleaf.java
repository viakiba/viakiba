package com.example.demo.test;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月12日
 */

@Controller
@RequestMapping("")
public class TestThymeleaf {
	
	/**
     * 返回html模板.
     */
    @RequestMapping("/hello")
    public String hello(Map<String,Object> map){
        map.put("hello","hello");
        return "/hello";
    }
    
    /**
     * 返回html模板.
     */
    @RequestMapping("/test/hello")
    public String helloHtml(Map<String,Object> map){
        map.put("hello","test.hello");
        return "/test/hello";
    }
}
