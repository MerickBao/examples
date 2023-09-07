package com.example.mysql.controller;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @desc:
 * @author: merickbao
 * @since: 2023/9/5 22:49
 */
@Aspect
@Component
@Order(1)
@Slf4j
public class DemoAspect {

    // 切点
    @Pointcut("@annotation(com.example.mysql.aop.DemoAnnotation)")
    public void demoPointcut() {
//        System.out.println("demoPointcut");
//        log.info("demoPointcut");
    }

    // 前置通知
    @Before("demoPointcut()")
    public void demoBefore(JoinPoint joinPoint) {  // JoinPoint 连接点
        System.out.println("demoBefore " + joinPoint.getSignature().getName());
        System.out.println(joinPoint.toString());
        log.info("demoBefore");
    }

    // 环绕通知
//    @Around(value = "demoPointcut()")
//    public void demoAround(JoinPoint joinPoint) {
//        System.out.println("demoAround");
//        log.info("demoAround");
//    }

//    // 后置通知
//    @After(value = "demoPointcut()")
//    public void demoAfter(JoinPoint joinPoint) {
//        System.out.println("demoAfter");
//        log.info("demoAfter");
//    }
//
//    // 返回通知
//    @AfterReturning(value = "demoPointcut()", returning = "result")
//    public void demoAfterReturning(JoinPoint joinPoint, Object result) {
//        System.out.println("demoAfterReturning " + result);
//        log.info("demoAfterReturning " + result);
//    }
//
//    // 异常通知
//    @AfterThrowing(value = "demoPointcut()", throwing = "e")
//    public void demoAfterThrowing(JoinPoint joinPoint, Exception e) {
//        System.out.println("demoAfterThrowing " + e.getMessage());
//        log.info("demoAfterThrowing " + e.getMessage());
//    }
}
