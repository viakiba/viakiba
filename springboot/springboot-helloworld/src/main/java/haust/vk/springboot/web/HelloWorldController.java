package haust.vk.springboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/44")
    public String sayHello() {
    	System.out.println("haha");
        return "Hello,World! 11sa1";
    }
}
