package com.willyweather.assignment;

/**
 * Enum of all columns of the file
 *
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

    //Checks whether argument is valid column/field value or not
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
