package com.willyweather.assignment.processors;

import org.springframework.stereotype.Component;

/**
 * @author Rajasekhar
 */
@Component
public abstract class AbstractProcessor implements FieldProcessor {

    int round(float value) {
        final double ceil = Math.round(value);
        return (int) ceil;
    }
}
