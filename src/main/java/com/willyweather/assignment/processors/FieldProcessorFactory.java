package com.willyweather.assignment.processors;

import com.willyweather.assignment.exceptions.DataProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author Rajasekhar
 */
@Component
public class FieldProcessorFactory {

    private final ApplicationContext context;

    @Autowired
    public FieldProcessorFactory(ApplicationContext context) {
        this.context = context;
    }

    public FieldProcessor getProcessor(String argument) {
        final Object bean = this.context.getBean(argument);
        if (bean == null) {
            throw new DataProcessingException("No such processor defined in the spring context.");
        }

        //Make sure the beans extend AbstractProcessor and have same round() method
        if (!(bean instanceof AbstractProcessor)) {
            throw new IllegalStateException(String.format("The bean %s is not of type " +
                    "AbstractProcessor", argument));
        }

        return (FieldProcessor) bean;
    }
}
