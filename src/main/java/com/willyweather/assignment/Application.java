package com.willyweather.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);
    private final WeatherDataProcessor weatherDataProcessor;

    @Autowired
    public Application(WeatherDataProcessor weatherDataProcessor) {
        this.weatherDataProcessor = weatherDataProcessor;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public void run(String... strings) throws Exception {
        final String processedData = this.weatherDataProcessor.getProcessedData();
        if (logger.isInfoEnabled()) {
            logger.info("Result of Processing \n" + processedData);
        }
        System.out.println("Result of Processing \n" + processedData);
    }
}