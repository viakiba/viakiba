package com.example.demo.controller;

import com.example.demo.annotation.UpCacheCallTsmAnnotation;
import org.springframework.stereotype.Component;

@Component
public class DemoController {

    @UpCacheCallTsmAnnotation
    public String string(String x){
        System.out.println(x);
        return x+"???";
    }

}
