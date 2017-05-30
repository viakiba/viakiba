package haust.vk.controller;

/**
 * Created by viakiba on 2017/5/23.
 */
public class Base {
    public Base(){
        System.out.println("Base 构造器");
    }

    {System.out.println("Base 普通代码块");}

    static{
        System.out.println("Base 静态代码块");
    }

    public void test(){
        System.out.println("Base 普通方法");
    }
    public static void main(String[] args){
        Base base = new Base();
        base.test();
    }
}
