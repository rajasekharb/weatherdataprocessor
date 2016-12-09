package com.willyweather.assignment.model;

import java.util.List;

/**
 * @author Rajasekhar
 */
public class HistoricalWeatherData {

    private List<WeatherDataModel> weatherDataModelList;

    public List<WeatherDataModel> getWeatherDataModelList() {
        return weatherDataModelList;
    }

    public void setWeatherDataModelList(List<WeatherDataModel> weatherDataModelList) {
        this.weatherDataModelList = weatherDataModelList;
    }

    @Override
    public String toString() {
        return "HistoricalWeatherData{" +
                "weatherDataModelList=" + weatherDataModelList +
                '}';
    }
}
