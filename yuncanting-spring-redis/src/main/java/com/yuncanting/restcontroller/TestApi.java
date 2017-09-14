package com.yuncanting.restcontroller;

import com.yuncanting.entity.TestEntity;
import com.yuncanting.service.TestService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping()
public class TestApi {


    @Resource
    private TestService testServiceImpl;

    /**
     * 测试json接口 返回json
     * @return
     */
    @RequestMapping("testApi")
    public Map testApi(){
        Map map = new HashMap();
        map.put("test","test");
        return map;
    }

    /**
     * 测试缓存与数据库查询
     * @param name
     * @return
     */
    @RequestMapping("testCache")
    public Map testCache(@RequestParam("name") String name){
        System.out.println(name);
        testServiceImpl.queryMethod(name);
        Map map = new HashMap();
        map.put("test","test");
        return map;
    }

}
