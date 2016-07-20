package haust.vk.e_aop_anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//指定当前类为切面类
@Aspect
@Component
public class Aop {
	
	//指定切入点 表单式：拦截哪些方法；即为那些类生成代理对象
	//其上 表示拦截haust.vk.e_aop_anno包下的所有类及其所有public方法
	//切入点
	@Pointcut("execution(* haust.vk.e_aop_anno.*.*(..))")
	public void pointCut_(){
		
	}
	//前置通知  ： 在执行目标方法之前执行
	@Before("pointCut_()")
	public void begin(){
		System.out.println("开始事务/异常");
	}
	
	// 后置/最终通知：在执行目标方法之后执行  【无论是否出现异常最终都会执行】
	@After("pointCut_()")
	public void after(){
		System.out.println("提交事务/关闭");
	}
	
	// 返回后通知： 在调用目标方法结束后执行 【出现异常不执行】
	@AfterReturning("pointCut_()")
	public void afterReturning(){
		System.out.println("afterReturning");
	}
	
	// 异常通知： 当目标方法执行异常时候执行此关注点代码
	@AfterThrowing("pointCut_()")
	public void afterThrowing(){
		System.out.println("AfterThrowing");
	}
	
	// 环绕通知：环绕目标方式执行
	@Around("pointCut_()")
	public void around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("环绕前");
		
		pjp.proceed();
		
		System.out.println("环绕后");
	}
}
