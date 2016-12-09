package com.willyweather.assignment.processors;

import com.willyweather.assignment.model.HistoricalWeatherData;
import com.willyweather.assignment.model.WeatherDataModel;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Rajasekhar
 */
@Component(value = "TEMP")
public class TemperatureProcessor extends AbstractProcessor {

    @Override
    public String process(HistoricalWeatherData historicalWeatherData) {
        final List<WeatherDataModel> weatherDataModelList = historicalWeatherData
                .getWeatherDataModelList();

        StringBuilder stringBuilder = new StringBuilder();

        for (WeatherDataModel weatherDataModel : weatherDataModelList) {
            final String meanMeanTemperature = weatherDataModel.getMeanMeanTemperature();
            final String temperature = meanMeanTemperature.split(" ")[0];
            stringBuilder.append(round(Float.parseFloat(temperature))).append(",");
        }

        return stringBuilder.toString();
    }
}