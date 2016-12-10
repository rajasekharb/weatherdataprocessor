package com.willyweather.assignment.model;

import java.util.List;

/**
 * A simple data structure to hold all the file data
 *
 * @author Rajasekhar
 */
public class WeatherData {

    private List<WeatherDataModel> weatherDataModelList;

    public List<WeatherDataModel> getWeatherDataModelList() {
        return weatherDataModelList;
    }

    public void setWeatherDataModelList(List<WeatherDataModel> weatherDataModelList) {
        this.weatherDataModelList = weatherDataModelList;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "weatherDataModelList=" + weatherDataModelList +
                '}';
    }
}
