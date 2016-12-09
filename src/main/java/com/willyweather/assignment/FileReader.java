package com.willyweather.assignment;

import com.willyweather.assignment.model.WeatherData;

import java.io.File;

/**
 * @author Rajasekhar
 */
public interface FileReader {

    WeatherData getWeatherData(File weatherDataFile);
}
