package com.willyweather.assignment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    // The Aspect itself is also a bean
    public LoggerAspect loggerAspect() {
        return new LoggerAspect();
    }
}