package com.company.bean;

import com.company.ReflectionTest;

import java.lang.reflect.Field;

public class GroovyDemo1 {

    public void main(String[] str) throws IllegalAccessException, NoSuchFieldException {
        Field demoMethod = ReflectionTest.class.getDeclaredField("demoMethod");
        demoMethod.setAccessible(true);
        demoMethod.set(null,new DemoMethod(){
            public void prePrint(String args){
                System.out.println("前置打印 reset"+args);
            }
        });
    }

}
