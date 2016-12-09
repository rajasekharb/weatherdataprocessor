package com.willyweather.assignment.processors;

import com.willyweather.assignment.model.WeatherData;
import com.willyweather.assignment.model.WeatherDataModel;

import java.util.List;

/**
 * @author Rajasekhar
 */
public class MaxTemperatureProcessor extends AbstractProcessor {

    @Override
    public String process(WeatherData weatherData) {
        final List<WeatherDataModel> weatherDataModelList = weatherData
                .getWeatherDataModelList();

        StringBuilder stringBuilder = new StringBuilder();

        for (WeatherDataModel weatherDataModel : weatherDataModelList) {
            String maxTemperature = weatherDataModel.getMaxTemperature();
            //Remove the last asterisk
            maxTemperature = maxTemperature.substring(0, maxTemperature.length() - 1);
            stringBuilder.append(round(Float.parseFloat(maxTemperature))).append(" ");
        }

        return stringBuilder.toString();
    }
}
