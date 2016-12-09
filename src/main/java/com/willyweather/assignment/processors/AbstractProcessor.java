package com.willyweather.assignment.processors;

/**
 * Consists of the logic to round the numerical values to nearest integer
 *
 * @author Rajasekhar
 */
public abstract class AbstractProcessor implements FieldProcessor {

    int round(float value) {
        final double ceil = Math.round(value);
        return (int) ceil;
    }
}
