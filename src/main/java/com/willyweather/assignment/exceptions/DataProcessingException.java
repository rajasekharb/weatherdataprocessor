package com.willyweather.assignment.exceptions;

/**
 * @author Rajasekhar
 */
public class DataProcessingException extends RuntimeException {

    public DataProcessingException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataProcessingException(String message) {
        super(message);
    }
}
