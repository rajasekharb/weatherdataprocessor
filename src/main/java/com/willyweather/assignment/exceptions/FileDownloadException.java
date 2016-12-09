package com.willyweather.assignment.exceptions;

/**
 * @author Rajasekhar
 */
public class FileDownloadException extends RuntimeException {

    public FileDownloadException(String message, Throwable cause) {
        super(message, cause);
    }
}
