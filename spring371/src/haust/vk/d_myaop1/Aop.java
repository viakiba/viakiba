package haust.vk.d_myaop1;

import org.springframework.stereotype.Component;
@Component
public class Aop {
	//重复执行的代码
	public void begin() {
		System.out.println("开始事务");
	}
	public void commit() {
		System.out.println("提交事务事务");
	}
}
