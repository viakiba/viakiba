package haust.vk.controller;

/**
 * Created by viakiba on 2017/5/23.
 */
public class Baseone extends Base {
    public Baseone(){
        System.out.println("Baseone 构造器");
    }

    {System.out.println("Baseone 普通代码块");}

    static {
        System.out.println("Baseone 静态代码块");
    }

    public void test(){
        System.out.println("Baseone 普通方法");
    }

    public static void main(String[] args){
        Baseone extendBase = new Baseone();
        //extendBase.test();
    }
}
