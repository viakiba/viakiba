package org.dubbo.learn.provider.service_1;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * @Description
 * @Author viakiba
 * @Date Create in 17:06 2018/6/18
 */
@Service(version="1.0.0")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        System.out.println(name);
        return name;
    }
}
