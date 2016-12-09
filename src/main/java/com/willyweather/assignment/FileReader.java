package com.willyweather.assignment;

import com.willyweather.assignment.exceptions.DataProcessingException;
import com.willyweather.assignment.model.HistoricalWeatherData;
import com.willyweather.assignment.model.WeatherDataModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Rajasekhar
 */
@Component
public class FileReader {

    private static final Logger logger = LoggerFactory.getLogger(FileReader.class);

    HistoricalWeatherData getHistoricalWeatherData(File weatherDataFile) {
        HistoricalWeatherData historicalWeatherData = new HistoricalWeatherData();
        List<WeatherDataModel> weatherDataModelList = new ArrayList<>();
        historicalWeatherData.setWeatherDataModelList(weatherDataModelList);

        //Streams are closed by try with resources block.
        try (InputStream inputStream = new FileInputStream(weatherDataFile);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,
                     StandardCharsets.UTF_8))) {
            String line = bufferedReader.readLine();


            if (logger.isInfoEnabled()) {
                logger.info("Parsing the file with the header \n" + line);
            }

            while ((line = bufferedReader.readLine()) != null) {
                final String[] values = line.split("\\s+");

                if (values.length != 22) {
                    throw new IllegalStateException("Expecting 22 values per line. One or more " +
                            "lines of the input is incorrect.");
                }

                WeatherDataModel weatherDataModel = new WeatherDataModel();

                final String stationNumber = values[0];
                final int weatherBureauAirForceNavy = Integer.parseInt(values[1]);
                final int yearMonthDay = Integer.parseInt(values[2]);

                final String meanTemperature = values[3] + " " + values[4];
                final String meanDewPoint = values[5] + " " + values[6];
                final String seaLevelPressure = values[7] + " " + values[8];
                final String meanStationPressure = values[9] + " " + values[10];
                final String visibility = values[11] + " " + values[12];
                final String meanWindSpeed = values[13] + " " + values[14];

                final float maximumSustainedWindSpeed = Float.parseFloat(values[15]);
                final float maximumWindGust = Float.parseFloat(values[16]);
                final String maxTemperature = values[17];
                final String minTemperature = values[18];
                final String precipitation = values[19];
                final float snowDepth = Float.parseFloat(values[20]);
                final String fogRainSnowHailThunderTornado = values[21];

                weatherDataModel.setStationNumber(stationNumber)
                        .setWeatherBureauAirForceNavy(weatherBureauAirForceNavy)
                        .setYearMonthDay(yearMonthDay).setMeanMeanTemperature(meanTemperature)
                        .setMeanDewPoint(meanDewPoint).setSeaLevelPressure(seaLevelPressure)
                        .setMeanStationPressure(meanStationPressure).setVisibility(visibility)
                        .setMeanWindSpeed(meanWindSpeed)
                        .setMaximumSustainedWindSpeed(maximumSustainedWindSpeed)
                        .setMaximumWindGust(maximumWindGust)
                        .setMaxTemperature(maxTemperature)
                        .setMinTemperature(minTemperature)
                        .setPrecipitation(precipitation)
                        .setSnowDepth(snowDepth)
                        .setFogRainSnowHailThunderTornado(fogRainSnowHailThunderTornado);

                weatherDataModelList.add(weatherDataModel);
            }
        } catch (IOException exception) {
            throw new DataProcessingException("Failed to parse the file", exception);
        }
        return historicalWeatherData;
    }
}
