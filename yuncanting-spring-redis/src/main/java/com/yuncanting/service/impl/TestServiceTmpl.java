package com.yuncanting.service.impl;

import com.yuncanting.dao.TestEntityDao;
import com.yuncanting.entity.TestEntity;
import com.yuncanting.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Description
 * @Author viakiba
 * @Date ${date}
 */
@Service
public class TestServiceTmpl implements TestService{

    @Resource
    private TestEntityDao testEntityDao;

    @Override
    public TestEntity queryMethod(String name) {
        Map map = testEntityDao.queryOne(name);
        System.out.println(map);
        map = testEntityDao.queryOnes(name);
        System.out.println(map);
        TestEntity testEntity = new TestEntity();
        testEntity.setId("1");
        testEntity.setName("hhaha哈哈");
        return testEntity;
    }

}
