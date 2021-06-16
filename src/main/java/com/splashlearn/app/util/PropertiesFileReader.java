package com.splashlearn.app.util;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.io.*;
import java.util.Properties;

public class PropertiesFileReader {

    private static final Logger logger = LogManager.getRootLogger();
    private PropertiesFileReader() {

    }

    public static Properties getProperty(String fileName) {
        Properties prop = new Properties();
        if(!fileName.endsWith(".properties"))
            fileName += fileName + ".properties";

        try {
            prop.load(new FileInputStream(SplashMathConstants.CONFIG_PATH + "/" + fileName));
        } catch (Exception e) {
            logger.error(String.format("Could not fetch value from given property file  : %s", fileName));
            logger.error(String.format("Error message here %n%s", ExceptionUtils.getStackTrace(e)));
            Assert.fail("Could not fetch value from given property file");
        }
        return prop;
    }

    public static String getProperty(String fileName, String key) {
        return getProperty(fileName).getProperty(key).trim();
    }

    public static Properties getPropertiesFromFile(String propsFile) {
        logger.debug("Reading Properties file {}", propsFile);
        Properties properties = new Properties();
        try {
            InputStream propertiesFile = new FileInputStream(new File(propsFile));
            properties.load(propertiesFile);
        } catch (FileNotFoundException e) {
            logger.error("File not found {}", propsFile);
        } catch (IOException e) {
            logger.error("Got IO Exception while reading file {}", propsFile);
        }
        return properties;
    }

}
