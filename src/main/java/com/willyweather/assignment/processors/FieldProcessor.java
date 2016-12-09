package com.willyweather.assignment.processors;

import com.willyweather.assignment.model.WeatherData;

/**
 * WeatherData Processor interface
 *
 * @author Rajasekhar
 */
public interface FieldProcessor {

    String process(WeatherData weatherData);

}