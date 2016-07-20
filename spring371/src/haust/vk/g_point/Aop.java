package haust.vk.g_point;

import org.aspectj.lang.ProceedingJoinPoint;
//指定当前类为切面类
public class Aop {
	
	//前置通知  ： 在执行目标方法之前执行
	public void begin(){
		System.out.println("开始事务/异常");
	}
	
	// 后置/最终通知：在执行目标方法之后执行  【无论是否出现异常最终都会执行】
	public void after(){
		System.out.println("提交事务/关闭");
	}
	
	// 返回后通知： 在调用目标方法结束后执行 【出现异常不执行】
	public void afterReturning(){
		System.out.println("afterReturning");
	}
	
	// 异常通知： 当目标方法执行异常时候执行此关注点代码
	public void afterThrowing(){
		System.out.println("AfterThrowing");
	}
	
	// 环绕通知：环绕目标方式执行
	public void around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("环绕前");
		
		pjp.proceed();
		
		System.out.println("环绕后");
	}
}
