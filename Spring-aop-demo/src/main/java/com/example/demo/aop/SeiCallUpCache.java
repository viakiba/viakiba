package com.example.demo.aop;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SeiCallUpCache {

    @After(value = "within(com.example.demo.controller..*) && @annotation(com.example.demo.annotation.UpCacheCallTsmAnnotation)")
    public void upCache() throws Exception {
        System.out.println("打算大苏打");
    }
}
