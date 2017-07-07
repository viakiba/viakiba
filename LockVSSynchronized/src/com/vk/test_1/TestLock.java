package com.vk.test_1;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

/** 
 * @description: 测试lock
 * @author viakiba
 * @date 2017年7月7日
 */

public class TestLock extends TestTemplate{

	ReentrantLock lock=new ReentrantLock();  
	/**
	 * @param _id
	 * @param _round
	 * @param _threadNum
	 * @param _cb
	 */
	public TestLock(String _id, int _round, int _threadNum, CyclicBarrier _cb) {
		super(_id, _round, _threadNum, _cb);
	}
	
	/**   
     * synchronized关键字不在方法签名里面，所以不涉及重载问题   
     */    
    @Override    
    long getValue() {     
        try{     
            lock.lock();     
            return super.countValue;     
        }finally{     
            lock.unlock();     
        }     
    }     
    @Override    
    void sumValue() {     
        try{     
            lock.lock();     
            super.countValue+=preInit[index++%round];     
        }finally{     
            lock.unlock();     
        }     
    }   
}
