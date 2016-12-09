package com.willyweather.assignment.processors;

import com.willyweather.assignment.model.HistoricalWeatherData;

/**
 * @author Rajasekhar
 */
public interface FieldProcessor {

    String process(HistoricalWeatherData historicalWeatherData);

}
