package com.willyweather.assignment;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.support.AopUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Rajasekhar
 */
@Aspect
@Component
class LoggerAspect {

    @Before("within(com.willyweather..*)")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println(String.format("Executing : %s() method of %s",
                joinPoint.getSignature().getName(), AopUtils.getTargetClass(joinPoint.getThis())));
        System.out.println("Method arguments are " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "within(com.willyweather..*)", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println(String.format("Completed execution of method %s()", joinPoint
                .getSignature().getName()));
        System.out.println("Method returned value is : " + result);
        System.out.println
                ("******************************************************************************");
    }

    @AfterThrowing(pointcut = "within(com.willyweather..*)", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.println(String.format("Execution of method %s() has thrown an exception.",
                joinPoint.getSignature().getName()));
        System.out.println("Exception Details are : " + error);
        System.out.println
                ("******************************************************************************");
    }
}
