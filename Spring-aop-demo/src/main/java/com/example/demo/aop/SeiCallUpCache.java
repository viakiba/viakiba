package com.example.demo.aop;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SeiCallUpCache {

    @AfterReturning(value = "within(com.example.demo.controller..*) && @annotation(com.example.demo.annotation.UpCacheCallTsmAnnotation)" , returning = "str")
    public void upCache(JoinPoint joinPoint, Object str) throws Exception {
        UpCacheCallTsmAnnotation upCacheCallTsmAnnotation = ((MethodSignature)joinPoint.getSignature()).getMethod().getAnnotation(UpCacheCallTsmAnnotation.class);
        String type = systemLog.type();
        System.out.println("类型"+type+"str"+str);
    }
}
