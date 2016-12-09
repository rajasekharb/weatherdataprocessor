package com.willyweather.assignment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext
                ("applicationContext.xml");
        final WeatherDataProcessor dataProcessor = applicationContext.getBean
                (WeatherDataProcessor.class);
        final String processedData = dataProcessor.getProcessedData();
        System.out.println("Processed result is " + processedData);

        ((ClassPathXmlApplicationContext) applicationContext).close();
    }
}