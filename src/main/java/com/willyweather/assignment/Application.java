package com.willyweather.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final WeatherDataProcessor weatherDataProcessor;

    @Autowired
    public Application(WeatherDataProcessor weatherDataProcessor) {
        this.weatherDataProcessor = weatherDataProcessor;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public void run(String... strings) throws Exception {
        System.out.println(this.weatherDataProcessor.getProcessedData());
    }
}