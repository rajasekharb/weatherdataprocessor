package com.willyweather.assignment;

import com.willyweather.assignment.exceptions.DataProcessingException;
import com.willyweather.assignment.exceptions.FileDownloadException;
import com.willyweather.assignment.exceptions.FileExtractionException;
import com.willyweather.assignment.model.WeatherData;
import com.willyweather.assignment.processors.FieldProcessor;
import com.willyweather.assignment.processors.FieldProcessorFactory;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

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
        //First download the file, if the google docs link has expired then try to load the file
        //from the classpath
        File downloadedFile;
        try {
            downloadedFile = this.fileDownloader.downloadFile();
        } catch (FileDownloadException ex) {
            ex.printStackTrace();
            downloadedFile = getFileFromClasspath();
        }


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

    private File getFileFromClasspath() {
        System.out.println("Loading the file from classpath as download is not successful");
        final String name = "007034-99999-2012.op.gz";
        final URL resource = getClass().getClassLoader().getResource(name);

        if (resource == null) {
            throw new FileDownloadException("Failed to load the file from classpath as well");
        }

        try {
            final String tempDirectory = System.getProperty("java.io.tmpdir");
            final File destDir = new File(tempDirectory + File.separator + name);
            FileUtils.copyURLToFile(resource, destDir);
            return destDir;
        } catch (IOException ex) {
            throw new FileDownloadException("IOException while copying file", ex);
        }
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