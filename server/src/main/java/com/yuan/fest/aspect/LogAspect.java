package com.yuan.fest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
//    @Pointcut("@annotation(com.yuan.fest.annotation.Log)")
//    public void log(){}

    @Around("execution(* com.yuan.fest.controller.UserController.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("before ------");
        Object proceed = pjp.proceed();
        System.out.println("after -------");
        return proceed;
    }
}
