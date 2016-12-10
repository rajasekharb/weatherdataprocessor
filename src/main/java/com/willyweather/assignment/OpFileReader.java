package com.willyweather.assignment;

import com.willyweather.assignment.exceptions.DataProcessingException;
import com.willyweather.assignment.model.WeatherData;
import com.willyweather.assignment.model.WeatherDataModel;
import com.willyweather.assignment.utils.ApplicationContextProvider;
import org.springframework.context.ApplicationContext;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Parses and reads the .op model file
 *
 * @author Rajasekhar
 */
class OpFileReader implements FileReader {

    private final ApplicationContextProvider contextProvider;

    public OpFileReader(ApplicationContextProvider contextProvider) {
        this.contextProvider = contextProvider;
    }

    //Reads one line at a time ignoring the header. Populates a list of all rows
    @Override
    public WeatherData getWeatherData(File weatherDataFile) {
        final ApplicationContext applicationContext = this.contextProvider.getApplicationContext();
        WeatherData weatherData = applicationContext.getBean(WeatherData.class);

        List<WeatherDataModel> weatherDataModelList = new ArrayList<>();
        weatherData.setWeatherDataModelList(weatherDataModelList);

        //Streams are closed by try with resources block.
        try (InputStream inputStream = new FileInputStream(weatherDataFile);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,
                     StandardCharsets.UTF_8))) {
            String line = bufferedReader.readLine();

            System.out.println("Header of the file being processed is ");
            System.out.println(line);

            while ((line = bufferedReader.readLine()) != null) {
                final String[] values = line.split("\\s+");

                if (values.length != 22) {
                    throw new IllegalStateException("Expecting 22 values per line. One or more " +
                            "lines of the input is incorrect.");
                }

                WeatherDataModel weatherDataModel = applicationContext.getBean(WeatherDataModel
                        .class);

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

                weatherDataModel = weatherDataModel.setStationNumber(stationNumber)
                        .setWeatherBureauAirForceNavy(weatherBureauAirForceNavy)
                        .setYearMonthDay(yearMonthDay).setMeanTemperature(meanTemperature)
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
        return weatherData;
    }
}
