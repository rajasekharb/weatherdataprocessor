package com.willyweather.assignment;

import java.io.File;

/**
 * FileExtractor interface to extract compressed files
 *
 * @author Rajasekhar
 */
interface FileExtractor {

    File unzip(File source);

}
