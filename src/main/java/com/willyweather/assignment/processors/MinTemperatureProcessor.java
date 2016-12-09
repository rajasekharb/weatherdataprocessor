package com.willyweather.assignment.processors;

import com.willyweather.assignment.model.HistoricalWeatherData;
import com.willyweather.assignment.model.WeatherDataModel;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Rajasekhar
 */
@Component(value = "MIN")
public class MinTemperatureProcessor extends AbstractProcessor{

    @Override
    public String process(HistoricalWeatherData historicalWeatherData) {
        final List<WeatherDataModel> weatherDataModelList = historicalWeatherData
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
