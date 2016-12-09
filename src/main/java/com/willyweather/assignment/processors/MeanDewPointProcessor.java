package com.willyweather.assignment.processors;

import com.willyweather.assignment.model.HistoricalWeatherData;
import com.willyweather.assignment.model.WeatherDataModel;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Rajasekhar
 */
@Component(value = "DEWP")
public class MeanDewPointProcessor extends AbstractProcessor {

    @Override
    public String process(HistoricalWeatherData historicalWeatherData) {
        final List<WeatherDataModel> weatherDataModelList = historicalWeatherData
                .getWeatherDataModelList();

        StringBuilder stringBuilder = new StringBuilder();

        for (WeatherDataModel weatherDataModel : weatherDataModelList) {
            final String meanDewPoint = weatherDataModel.getMeanDewPoint();
            final String dewPoint = meanDewPoint.split(" ")[0];
            stringBuilder.append(round(Float.parseFloat(dewPoint))).append(",");
        }

        return stringBuilder.toString();
    }
}
