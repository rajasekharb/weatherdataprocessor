package com.willyweather.assignment.model;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * A simple data structure to hold all the file data
 *
 * @author Rajasekhar
 */
@Component
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
