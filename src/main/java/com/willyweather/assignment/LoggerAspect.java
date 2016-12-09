package com.willyweather.assignment;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Rajasekhar
 */
@Aspect
@Component
public class LoggerAspect {

    @Before("within(com.willyweather..*)")
    public void beforeAdvice() {
        System.out.println("Before execution");
    }
}
