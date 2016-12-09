package com.willyweather.assignment;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("config.properties")
@ConfigurationProperties(prefix = "com.willyweather.assignment")
public class ApplicationConfiguration {

    private String url;
    private String extractLocation;
    private String filename;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExtractLocation() {
        if ("java.io.tmpdir".equals(extractLocation)) {
            return System.getProperty("java.io.tmpdir");
        }
        return extractLocation;
    }

    public void setExtractLocation(String extractLocation) {
        this.extractLocation = extractLocation;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}