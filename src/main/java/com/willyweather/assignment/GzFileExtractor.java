package com.willyweather.assignment;

import com.willyweather.assignment.exceptions.FileExtractionException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 * Extracts op.gz files
 *
 * @author Rajasekhar
 */
class GzFileExtractor implements FileExtractor {

    @Override
    public File unzip(File source) {
        final File destination = getDestination(source);

        byte[] buffer = new byte[1024];

        try (final GZIPInputStream inputStream = new GZIPInputStream(new FileInputStream(source));
             final FileOutputStream outputStream = new FileOutputStream(destination)) {

            int len;
            while ((len = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, len);
            }
        } catch (IOException ex) {
            throw new FileExtractionException("Failed to unzip the gz file", ex);
        }

        return destination;
    }

    private File getDestination(File downloadedFile) {
        String inputGzipFilePath = downloadedFile.getAbsolutePath();
        String outputFilePath = inputGzipFilePath.substring(0, inputGzipFilePath.lastIndexOf("."));
        return new File(outputFilePath);
    }
}
