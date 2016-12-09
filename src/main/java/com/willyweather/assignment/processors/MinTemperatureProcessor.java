package com.willyweather.assignment.processors;

import com.willyweather.assignment.model.WeatherData;
import com.willyweather.assignment.model.WeatherDataModel;

import java.util.List;

/**
 * @author Rajasekhar
 */
public class MinTemperatureProcessor extends AbstractProcessor {

    @Override
    public String process(WeatherData weatherData) {
        final List<WeatherDataModel> weatherDataModelList = weatherData
                .getWeatherDataModelList();

        StringBuilder stringBuilder = new StringBuilder();

        for (WeatherDataModel weatherDataModel : weatherDataModelList) {
            String minTemperature = weatherDataModel.getMinTemperature();
            //Remove the last asterisk
            minTemperature = minTemperature.substring(0, minTemperature.length() - 1);
            stringBuilder.append(round(Float.parseFloat(minTemperature))).append(" ");
        }

        return stringBuilder.toString();
    }
}
