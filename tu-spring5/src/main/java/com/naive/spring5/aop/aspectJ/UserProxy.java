package com.naive.spring5.aop.aspectJ;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/5/28
 * Description:
 */
@Component
@Aspect
@Order(1)
public class UserProxy {

    @Pointcut(value = "execution(* com.naive.spring5.aop.aspectJ.User.add(..))")
    public void point() {

    }

    @Before(value = "point()")
    public void before() {
        System.out.println("before..........");
    }

    @AfterReturning(value = "point()")
    public void afterReturning() {
        System.out.println("after returning...........");
    }

    @After(value = "point()")
    public void after() {
        System.out.println("after..............");
    }

    @AfterThrowing(value = "point()")
    public void afterThrowing() {
        System.out.println("after throwing..........");
    }

    @Around(value = "point()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕之前.............");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕之后.............");
        return proceed;
    }

}
