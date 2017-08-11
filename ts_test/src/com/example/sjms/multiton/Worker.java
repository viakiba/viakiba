package com.example.sjms.multiton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** 
 * @description: 
 * @author viakiba
 * @date 2017年7月26日
 */

public class Worker {
	
	private static final int maxWorkerNum = 2;//规定多例模式 最大数量
	private static List workList = new ArrayList<>(maxWorkerNum);//设置例子的存放位置
	private static List workListInfo = new ArrayList<>(maxWorkerNum);//存放例子的名字
	private static int nowWorker = 0;
	
	static{
		for(int i=0;i<maxWorkerNum;i++){
			workList.add(new Worker("工人"+i));
		}
	}
	
	//私有化构造函数
	private Worker(){
		super();
	}
	
	//私有化构造函数
	private Worker(String info){
		System.out.println(info);
		workListInfo.add(info);
	}
	
	//获取实例
	public static Worker getInstance(){
		Random random = new Random();
		nowWorker = random.nextInt(maxWorkerNum);
		return (Worker) workList.get(nowWorker);
	}
	
	//获取实例信息
	public String getInstanceInfo(){
		return (String) workListInfo.get(nowWorker);
	}
}
