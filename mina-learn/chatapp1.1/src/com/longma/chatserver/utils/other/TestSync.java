package com.longma.chatserver.utils.other;

import java.util.concurrent.CyclicBarrier;

/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月7日
 */

public class TestSync extends TestTemplate{

	/**
	 * @param _id
	 * @param _round
	 * @param _threadNum
	 * @param _cb
	 */
	public TestSync(String _id, int _round, int _threadNum, CyclicBarrier _cb) {
		super(_id, _round, _threadNum, _cb);
		// TODO Auto-generated constructor stub
	}
	
	@Override    
    /**   
     * synchronized关键字不在方法签名里面，所以不涉及重载问题   
     */    
    synchronized long  getValue() {     
        return super.countValue;     
    }     
    @Override    
    synchronized void  sumValue() {     
        super.countValue+=preInit[index++%round];     
    }

}
