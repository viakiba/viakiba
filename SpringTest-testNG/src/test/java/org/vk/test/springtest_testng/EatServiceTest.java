package org.vk.test.springtest_testng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import org.vk.demo.EatCompentConfig;
import org.vk.demo.PeopleEatService;
import org.vk.demo.PeopleEatServiceImpl;

/**
 * @author viakiba
 *  classes需要注入的类
 * @description
 * @date Create in 20:38 2018/7/22
 */

@SpringBootTest(classes = { PeopleEatServiceImpl.class , EatCompentConfig.class })
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class EatServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private PeopleEatService peopleEatServiceImpl;
    @Test(groups = "eatOne")
    public void test1(){
        int i = peopleEatServiceImpl.eatService();
        System.out.println(i * 1);
    }

    @Test(groups = "eatTen")
    public void test2(){
        int i = peopleEatServiceImpl.eatService();
        System.out.println(i*10);
    }
}
