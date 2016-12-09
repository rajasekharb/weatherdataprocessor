package com.willyweather.assignment.processors;

import com.willyweather.assignment.model.WeatherData;
import com.willyweather.assignment.model.WeatherDataModel;

import java.util.List;

/**
 * @author Rajasekhar
 */
public class MeanDewPointProcessor extends AbstractProcessor {

    @Override
    public String process(WeatherData weatherData) {
        final List<WeatherDataModel> weatherDataModelList = weatherData
                .getWeatherDataModelList();

        StringBuilder stringBuilder = new StringBuilder();

        for (WeatherDataModel weatherDataModel : weatherDataModelList) {
            final String meanDewPoint = weatherDataModel.getMeanDewPoint();
            final String dewPoint = meanDewPoint.split(" ")[0];
            stringBuilder.append(round(Float.parseFloat(dewPoint))).append(" ");
        }

        return stringBuilder.toString();
    }
}
