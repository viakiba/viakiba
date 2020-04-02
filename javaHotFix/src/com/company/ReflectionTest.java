package com.company;

import com.company.bean.DemoMethod;
import groovy.lang.GroovyShell;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

public class ReflectionTest {

    public static DemoMethod demoMethod ;

    public ReflectionTest(){
        demoMethod = new DemoMethod();
    }

    @Test
    public void test1() throws NoSuchFieldException, IllegalAccessException {
        ReflectionTest timePrint = new ReflectionTest();
        //10秒钟输出一次
        System.out.println("输入 exit 即可停止");
        int i= 0;
        while (i<10){
            timePrint.demoMethod.prePrint(i+"");
            if(i==10){
                break;
            }
            if(i==5){
                Field demoMethod = ReflectionTest.class.getDeclaredField("demoMethod");
                demoMethod.setAccessible(true);
                demoMethod.set(null,new DemoMethod(){
                    public void prePrint(String args){
                        System.out.println("前置打印 reset"+args);
                    }
                });
            }
            System.out.println("后置打印"+i);
            i++;
        }
    }

    @Test
    public void test2() throws NoSuchFieldException, IllegalAccessException, IOException {
        ReflectionTest timePrint = new ReflectionTest();
        //10秒钟输出一次
        System.out.println("输入 exit 即可停止");
        int i= 0;
        while (i<10){
            timePrint.demoMethod.prePrint(i+"");
            if(i==10){
                break;
            }
            if(i==5){
                GroovyShell groovyShell = new GroovyShell();
                groovyShell.evaluate(new File("C:\\Users\\89264\\Desktop\\hotload\\src\\com\\company\\GroovyDemo1.java"));
            }
            System.out.println("后置打印"+i);
            i++;
        }
    }

}
