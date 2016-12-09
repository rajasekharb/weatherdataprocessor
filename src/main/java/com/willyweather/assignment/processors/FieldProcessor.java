package com.willyweather.assignment.processors;

import com.willyweather.assignment.model.WeatherData;

/**
 * @author Rajasekhar
 */
public interface FieldProcessor {

    String process(WeatherData weatherData);

}
