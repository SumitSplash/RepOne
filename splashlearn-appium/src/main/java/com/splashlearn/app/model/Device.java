package com.splashlearn.app.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Device {

	private final String os;
	private final String type;
	private final AppiumDriver<MobileElement> driver;
	private final String id;
	private final String deviceType;

	private final Logger logger = LogManager.getRootLogger();

	public Device(String os, String type, AppiumDriver<MobileElement> driver) {
		this.os = os.toUpperCase();
		this.type = type;
		this.driver = driver;
		this.id = type.equalsIgnoreCase("local") ? (String) driver.getCapabilities().getCapability("udid") : "";
		this.deviceType = (String) driver.getCapabilities().getCapability("device.type");
	}

	public String getOs() {
		return os;
	}

	public AppiumDriver<MobileElement> getDriver() {
		return driver;
	}

	public String getType() {
		return type;
	}

	public void close() {
		if (driver == null) {
			return;
		}
		driver.quit();
		logger.debug("Closing device {}", getId());
	}

	public String getId() {
		return id;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void reset() {
		driver.resetApp();
	}

	public void launchApp() {
		driver.launchApp();
	}

}
