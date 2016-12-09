package com.willyweather.assignment.processors;

import com.willyweather.assignment.model.HistoricalWeatherData;
import com.willyweather.assignment.model.WeatherDataModel;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Rajasekhar
 */
@Component
public class MaxTemperatureProcessor extends AbstractProcessor {

    @Override
    public String process(HistoricalWeatherData historicalWeatherData) {
        final List<WeatherDataModel> weatherDataModelList = historicalWeatherData
                .getWeatherDataModelList();

        StringBuilder stringBuilder = new StringBuilder();

        for (WeatherDataModel weatherDataModel : weatherDataModelList) {
            String maxTemperature = weatherDataModel.getMaxTemperature();
            //Remove the last asterisk
            maxTemperature = maxTemperature.substring(0, maxTemperature.length() - 1);
            stringBuilder.append(round(Float.parseFloat(maxTemperature))).append(",");
        }

        return stringBuilder.toString();
    }
}
