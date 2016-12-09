package com.willyweather.assignment;

import com.willyweather.assignment.exceptions.FileDownloadException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Rajasekhar
 */
class FileDownloader implements Downloader {

    private final String url;
    private final String filename;
    private final int connectionTimeout;
    private final int readTimeout;
    private String extractLocation;

    public FileDownloader(String url, String extractLocation, String filename, int
            connectionTimeout, int readTimeout) {
        this.url = url;
        this.extractLocation = extractLocation;
        this.filename = filename;
        this.connectionTimeout = connectionTimeout;
        this.readTimeout = readTimeout;
    }

    //Downloads from internet
    @Override
    public File downloadFile() {
        URL downloadUrl;
        try {
            downloadUrl = new URL(this.url);
        } catch (MalformedURLException ex) {
            throw new FileDownloadException(String.format("The URL configured in the properties " +
                    "file %s is malformed.", this.url), ex);
        }

        if ("java.io.tmpdir".equals(this.extractLocation)) {
            this.extractLocation = System.getProperty("java.io.tmpdir");
        }
        File destination = new File(this.extractLocation + File.separator + this.filename);

        try {
            FileUtils.copyURLToFile(downloadUrl, destination, this.connectionTimeout, this
                    .readTimeout);
        } catch (IOException ex) {
            throw new FileDownloadException(String.format("An exception occurred while " +
                    "downloading the file from %s", this.url), ex);
        }

        return destination;
    }
}