package com.willyweather.assignment;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.support.AopUtils;
import org.springframework.stereotype.Component;

/**
 * @author Rajasekhar
 */
@Aspect
@Component
class LoggerAspect {

    @Before("within(com.willyweather..*)")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println(String.format("Before Advice: Executing : %s() method of %s",
                joinPoint.getSignature().getName(), AopUtils.getTargetClass(joinPoint.getThis())));
    }
}
