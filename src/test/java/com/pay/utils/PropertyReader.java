package com.pay.utils;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static Properties properties;

    private static void readProperties() {
        properties = new Properties();
        try {
            properties.load(PropertyReader.class.getClassLoader().
                    getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        if (properties == null) {
            readProperties();
        }
        return properties.getProperty(key);
    }
}