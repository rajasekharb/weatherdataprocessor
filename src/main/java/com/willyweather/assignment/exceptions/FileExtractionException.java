package com.willyweather.assignment.exceptions;

/**
 * @author Rajasekhar
 */
public class FileExtractionException extends RuntimeException {

    public FileExtractionException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileExtractionException(String message) {
        super(message);
    }
}
