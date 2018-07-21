package org.dubbo.learn.consumer.service_2;

import com.alibaba.dubbo.config.annotation.Reference;
import org.dubbo.learn.provider.service_1.HelloService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author viakiba
 * @Date Create in 17:09 2018/6/18
 */
@Component
@RestController
public class HelloServiceConsumer1 implements CommandLineRunner {

    @Reference(version = "1.0.0")
    private HelloService helloService;

    @Override
    public void run(String... strings) throws Exception {
        helloService.sayHello("jjj");
    }

    @RequestMapping(value = "service2")
    public Map getMap(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        helloService.sayHello(name);
        Map map =new HashMap();
        map.put("hello","world"+name);
        return map;
    }

}