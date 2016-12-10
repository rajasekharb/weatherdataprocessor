package com.willyweather.assignment;

import com.willyweather.assignment.exceptions.DataProcessingException;
import com.willyweather.assignment.exceptions.FileExtractionException;
import com.willyweather.assignment.model.WeatherData;
import com.willyweather.assignment.processors.FieldProcessor;
import com.willyweather.assignment.processors.FieldProcessorFactory;

import java.io.File;

/**
 * @author Rajasekhar
 */
class WeatherDataProcessorImpl implements WeatherDataProcessor {

    private final Downloader fileDownloader;
    private final FileExtractor fileExtractor;
    private final FileReader fileReader;
    private final FieldProcessorFactory fieldProcessorFactory;

    //Constructor injection is preferred over setter injection via xml configuration
    public WeatherDataProcessorImpl(Downloader fileDownloader, FileExtractor fileExtractor,
                                    FieldProcessorFactory fieldProcessorFactory, FileReader
                                            fileReader) {
        this.fileDownloader = fileDownloader;
        this.fileExtractor = fileExtractor;
        this.fieldProcessorFactory = fieldProcessorFactory;
        this.fileReader = fileReader;
    }

    public String getProcessedData() {
        //First download the file
        final File downloadedFile = this.fileDownloader.downloadFile();

        //Extract the file and get the actual file that consists of the weather data
        //with the FileExtractor implementation.
        final File weatherDataFile = this.fileExtractor.unzip(downloadedFile);

        if (!weatherDataFile.exists()) {
            throw new FileExtractionException("File extraction is not successful");
        }

        //Get the field and validate with the Headers enum
        final String argument = getFieldValue();
        validateArgument(argument);

        return processFile(weatherDataFile, argument);
    }

    private String processFile(File weatherDataFile, String argument) {
        WeatherData weatherData = this.fileReader.getWeatherData
                (weatherDataFile);
        final FieldProcessor fieldProcessor = this.fieldProcessorFactory.getProcessor(argument);

        try {
            return fieldProcessor.process(weatherData);
        } catch (NumberFormatException ex) {
            throw new DataProcessingException("Exception occurred while processing data", ex);
        }
    }

    private void validateArgument(String argument) {
        if (argument == null || "".equals(argument.trim())) {
            throw new IllegalArgumentException("Argument can't be null or empty. Please try " +
                    "passing -Dfield={TEMP | DEWP | MIN | MAX} before jar file name in the " +
                    "command. For example:  java -jar -Dfield=DEWP TestProject.jar");
        }

        if (!Headers.isValid(argument)) {
            throw new IllegalArgumentException(String.format("The parameter %s is invalid",
                    argument));
        }
    }

    /**
     * Retrieves the JVM argument 'field' passed as command line argument eg. -Dfield=TEMP
     * <p>
     * If there is no such argument found, then return TEMP
     *
     * @return String Argument field
     */
    private String getFieldValue() {
        return System.getProperty("field");
    }
}