package com.willyweather.assignment.processors;

import com.willyweather.assignment.ApplicationContextProvider;
import com.willyweather.assignment.exceptions.DataProcessingException;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.ApplicationContext;

/**
 * @author Rajasekhar
 */
public class FieldProcessorFactory {

    private final ApplicationContextProvider contextProvider;

    public FieldProcessorFactory(ApplicationContextProvider contextProvider) {
        this.contextProvider = contextProvider;
    }

    public FieldProcessor getProcessor(String argument) {
        final ApplicationContext applicationContext = this.contextProvider.getApplicationContext();
        final Object bean = applicationContext.getBean(argument.toLowerCase());
        if (bean == null) {
            throw new DataProcessingException("No such processor defined in the spring context.");
        }

        //Make sure the beans are of type AbstractProcessor
        if (!(AbstractProcessor.class.isAssignableFrom(AopUtils.getTargetClass(bean)))) {
            throw new IllegalStateException(String.format("The bean %s is not of type " +
                    "AbstractProcessor", argument));
        }

        return (FieldProcessor) bean;
    }
}