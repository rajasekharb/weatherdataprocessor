package com.willyweather.assignment.processors;

import com.willyweather.assignment.model.WeatherData;
import com.willyweather.assignment.model.WeatherDataModel;

import java.util.List;

/**
 * Processes the TEMP field. Ignores the value that comes after space in the TEMP column
 *
 * @author Rajasekhar
 */
public class TemperatureProcessor extends AbstractProcessor {

    @Override
    public String process(WeatherData weatherData) {
        final List<WeatherDataModel> weatherDataModelList = weatherData
                .getWeatherDataModelList();

        StringBuilder stringBuilder = new StringBuilder();

        for (WeatherDataModel weatherDataModel : weatherDataModelList) {
            final String meanTemperature = weatherDataModel.getMeanTemperature();
            final String temperature = meanTemperature.split(" ")[0];
            stringBuilder.append(round(Float.parseFloat(temperature))).append(" ");
        }

        return stringBuilder.toString();
    }
}