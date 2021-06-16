package com.splashlearn.app.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Properties;

public class SplashLearnAutomationEnvironmentConfig {

    private static SplashLearnAutomationEnvironmentConfig config = null;
    private static final Logger logger = LogManager.getRootLogger();

    private Properties properties;
    private String runType;
    private String deviceConnected;
    private boolean staticSetup;

    private final String configFile = System.getProperty("user.dir") +
            "/src/main/resources/shell/control_center.properties";

    public static synchronized SplashLearnAutomationEnvironmentConfig getInstance() {
        if(config == null)
            config = new SplashLearnAutomationEnvironmentConfig();
        return config;
    }

    private SplashLearnAutomationEnvironmentConfig() {
        loadProperties(PropertiesFileReader.getPropertiesFromFile(configFile));
    }

    private void loadProperties(Properties properties){
        runType = getStringProperty(properties, "run_type", "jenkins");
        deviceConnected = getStringProperty(properties, "device_connected", "pcloudy");
        staticSetup = getBooleanProperty(properties, "static_setup", false);
        logger.debug("Run Type : {}", runType);
        logger.debug("Device Connected : {}", deviceConnected);
        logger.debug("Static Set Up : {}", deviceConnected);
    }

    private String getStringProperty(Properties properties, String propertyName, String defaultValue) {
        String value = properties.getProperty(propertyName);
        if(value == null || value.isEmpty())
            return defaultValue;
        return value;
    }

    private boolean getBooleanProperty(Properties properties, String propertyName, boolean defaultValue) {
        String value = properties.getProperty(propertyName);
        if(value == null || value.isEmpty())
            return defaultValue;
        return Boolean.parseBoolean(value);
    }

    public String getRunType() {
        return runType;
    }

    public String getDeviceConnected() {
        return deviceConnected;
    }

    public boolean getStaticSetup() {
        return staticSetup;
    }
}
