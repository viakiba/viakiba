package com.example.demo;

import com.example.demo.controller.DemoController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
        DemoController demoController = run.getBean("demoController", DemoController.class);
        String dasda = demoController.string("dasda");
        System.out.println(dasda);
    }

}

