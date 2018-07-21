package com.longma.chatserver.utils.other;

import java.util.concurrent.CyclicBarrier;

/** 
 * @description: http://hanhailong.com/2016/12/10/Synchronized%E4%B8%8ELock%E9%94%81%E7%9A%84%E5%8C%BA%E5%88%AB/
 * @author viakiba
 * @date 2017年7月7日
 */

public class AppTest {
	public static void test(int round,int threadNum,CyclicBarrier cyclicBarrier){     
        new TestSync("Sync",round,threadNum,cyclicBarrier).testTime();     
        new TestLock("Lock",round,threadNum,cyclicBarrier).testTime();     
        new TestAtomic("Atom",round,threadNum,cyclicBarrier).testTime();     
    }     

    public static void main(String args[]){     
        for(int i=0;i<5;i++){     
            int round=100000*(i+1);     
            int threadNum=5*(i+1);     
            CyclicBarrier cb=new CyclicBarrier(threadNum*2+1);     
            System.out.println("==========================");     
            System.out.println("round:"+round+" thread:"+threadNum);     
            test(round,threadNum,cb);     

        }     
    }  
}
