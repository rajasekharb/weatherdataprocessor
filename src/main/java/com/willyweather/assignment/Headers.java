package com.willyweather.assignment;

/**
 * @author Rajasekhar
 */
enum Headers {

    STN("STN"), WBAN("WBAN"), YEARMODA("YEARMODA"), TEMP("TEMP"), DEWP("DEWP"),
    SLP("SLP"), STP("STP"), VISIB("VISIB"),
    WDSP("WDSP"), MXSPD("MXSPD"), GUST("GUST"), MAX("MAX"), MIN("MIN"),
    PRCP("PRCP"), SNDP("SNDP"), FRSHTT("FRSHTT");

    private final String name;

    Headers(String name) {
        this.name = name;
    }

    public static boolean isValid(String argument) {
        for (Headers header : Headers.values()) {
            if (header.getName().equalsIgnoreCase(argument)) {
                return true;
            }
        }
        return false;
    }

    private String getName() {
        return name;
    }
}
