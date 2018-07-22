package org.vk.test.testng;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author viakiba
 *  testNG 样例
 * @description
 * @date Create in 17:56 2018/7/22
 */
public class SequenceTest {

    int i ;

    @BeforeClass(groups = "before")
    public void beforeTest0(){
        i = 10;
        System.out.println("beforeTest0");
    }

    @Test(priority = 1,groups = {"sequence"})
    public void test1(){
        System.out.println("test1 + sequence ");
    }

    @Test(priority = 3,groups = {"sequence","filter1"})
    public void test2(){
        System.out.println("test3 + sequence + filter1 ");
    }

    @Test(priority = 2,groups = {"sequence","filter2"})
    public void test3(){
        System.out.println("test2+ sequence + filter2");
    }

    @Test(priority = 4,groups = {"sequence","filter1","filter3"})
    public void test4(){
        System.out.println("test4 + sequence + filter1");
    }

    @Parameters({"testParam"})
    @Test(priority = 5,groups = {"sequence","param"})
    public void test5(int testParam){
        System.out.println(testParam);
        System.out.println("test5+sequence+param");
    }

    @Test(priority = 5,groups = {"before"})
    public void test5( ){
        System.out.println(i);
        System.out.println("test5+sequence+param");
    }

    @AfterGroups(groups = {"before"})
    public void afterTest0(){
        i = -1;
        System.out.println("afterTest0" + i);
    }
}
