package com.willyweather.assignment.processors;

import com.willyweather.assignment.model.WeatherData;
import com.willyweather.assignment.model.WeatherDataModel;

import java.util.List;

/**
 * @author Rajasekhar
 */
public class TemperatureProcessor extends AbstractProcessor {

    @Override
    public String process(WeatherData weatherData) {
        final List<WeatherDataModel> weatherDataModelList = weatherData
                .getWeatherDataModelList();

        StringBuilder stringBuilder = new StringBuilder();

        for (WeatherDataModel weatherDataModel : weatherDataModelList) {
            final String meanMeanTemperature = weatherDataModel.getMeanMeanTemperature();
            final String temperature = meanMeanTemperature.split(" ")[0];
            stringBuilder.append(round(Float.parseFloat(temperature))).append(" ");
        }

        return stringBuilder.toString();
    }
}