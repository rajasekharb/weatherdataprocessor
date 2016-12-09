package com.willyweather.assignment.processors;

/**
 * @author Rajasekhar
 */
public abstract class AbstractProcessor implements FieldProcessor {

    int round(float value) {
        final double ceil = Math.round(value);
        return (int) ceil;
    }
}
