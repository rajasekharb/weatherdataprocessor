package com.willyweather.assignment;

import com.willyweather.assignment.model.WeatherData;

import java.io.File;

/**
 * FileReader interface to read files
 *
 * @author Rajasekhar
 */
public interface FileReader {

    WeatherData getWeatherData(File weatherDataFile);
}
