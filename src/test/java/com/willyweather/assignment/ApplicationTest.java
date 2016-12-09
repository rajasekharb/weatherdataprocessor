package com.willyweather.assignment;

import com.willyweather.assignment.exceptions.DataProcessingException;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class ApplicationTest {

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyArgument() {
        System.setProperty("field", "");
        Application.main(new String[1]);
    }

    @Test
    public void testTemp() {
        System.setProperty("field", "TEMP");
        Application.main(new String[1]);
    }

    @Test
    public void testDewp() {
        System.setProperty("field", "DEWP");
        Application.main(new String[1]);
    }

    @Test
    public void testMin() {
        System.setProperty("field", "MIN");
        Application.main(new String[1]);
    }

    @Test
    public void testMAX() {
        System.setProperty("field", "MAX");
        Application.main(new String[1]);
    }

    @Test(expected = DataProcessingException.class)
    public void testSlp() {
        System.setProperty("field", "SLP");
        Application.main(new String[1]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIncorrectData() {
        System.setProperty("field", "junit");
        Application.main(new String[1]);
    }
}
