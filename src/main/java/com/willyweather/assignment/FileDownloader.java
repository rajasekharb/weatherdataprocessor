package com.willyweather.assignment;

import com.willyweather.assignment.exceptions.FileDownloadException;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Rajasekhar
 */
@Component
public class FileDownloader {

    private final ApplicationConfiguration configuration;

    @Autowired
    public FileDownloader(ApplicationConfiguration configuration) {
        this.configuration = configuration;
    }

    File downloadFile() {
        URL url;
        String downloadUrl = this.configuration.getUrl();
        try {
            url = new URL(downloadUrl);
        } catch (MalformedURLException ex) {
            throw new FileDownloadException(String.format("The URL configured in the properties " +
                    "file %s is malformed.", downloadUrl), ex);
        }

        String extractLocation = this.configuration.getExtractLocation();
        final String filename = this.configuration.getFilename();
        File destination = new File(extractLocation + File.separator + filename);

        try {
            FileUtils.copyURLToFile(url, destination);
        } catch (IOException ex) {
            throw new FileDownloadException(String.format("An exception occurred while " +
                    "downloading the file from %s", downloadUrl), ex);
        }

        return destination;
    }
}