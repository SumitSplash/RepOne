package com.splashlearn.app.library;

import static com.splashlearn.app.util.PropertiesFileReader.getPropertiesFromFile;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.splashlearn.app.util.SplashMathConstants;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverInitializer {

	final Logger logger = LogManager.getRootLogger();

	private final String pcloudDefaultProperties = System.getProperty("user.dir")
			+ "/src/main/resources/default/pcoudy_default.properties";

	protected AppiumDriver<MobileElement> setIOsDriver(Properties p, String target) throws MalformedURLException {
		logger.debug("Starting IOS device {}", p.getProperty(DeviceFactory.Property.UDID.toString()));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		AppiumDriver<MobileElement> driver;
		if (target.equalsIgnoreCase("pcloudy")) {
			driver = new IOSDriver<>(new URL(SplashMathConstants.PCLOUDY_URL), setPCloudyCapabilities(p, false));
		} else { // local
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
					p.getProperty(DeviceFactory.Property.PLATFORMVERSION.toString()));
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Test Device");
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
			capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, false);
			capabilities.setCapability(MobileCapabilityType.NO_RESET,
					p.getProperty(DeviceFactory.Property.USENEWWDA.toString()));
			capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 3000);
			capabilities.setCapability("deviceType", p.getProperty(DeviceFactory.Property.DEVICETYPE.toString()));
			capabilities.setCapability(MobileCapabilityType.UDID,
					p.getProperty(DeviceFactory.Property.UDID.toString()));
			capabilities.setCapability(MobileCapabilityType.APP, getIOSAppPath());
			capabilities.setCapability("bundleId", "com.studypadinc.splashmath.universal.omni.lite");
			capabilities.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT, p.getProperty("wdaLocalPort"));
			driver = new IOSDriver<>(new URL(SplashMathConstants.APPIUM_SERVER), capabilities);
		}
		logger.debug("IOS Driver started for device {}", p.getProperty(DeviceFactory.Property.UDID.toString()));
		return driver;
	}

	protected AppiumDriver<MobileElement> setAndroidDriver(Properties p, String target, int number)
			throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		if (target.equalsIgnoreCase("pcloudy")) {
			return new AndroidDriver<>(new URL(SplashMathConstants.PCLOUDY_URL), setPCloudyCapabilities(p, true));
		} else { // local
			// TODO: Add capabilities for Android Local Devices
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
					p.getProperty(DeviceFactory.Property.PLATFORMVERSION.toString()));
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
					p.getProperty(DeviceFactory.Property.PLATFORMNAME.toString()));
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
					p.getProperty(DeviceFactory.Property.DEVICENAME.toString()));
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,
					p.getProperty(DeviceFactory.Property.AUTOMATIONNAME.toString()));
			capabilities.setCapability(MobileCapabilityType.APP, getAndroidAppPath());
			capabilities.setCapability("systemPort", number);
			capabilities.setCapability("appActivity", p.getProperty(DeviceFactory.Property.APPACTIVITY.toString()));
			capabilities.setCapability("appPackage", p.getProperty(DeviceFactory.Property.APPPACKAGE.toString()));
			capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 3000);
			return new AndroidDriver<>(new URL(SplashMathConstants.APPIUM_SERVER), capabilities);
		}
	}

	protected DesiredCapabilities setPCloudyCapabilities(Properties p, boolean isAndroid) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// Setting default PCloudy capabilities from pcloudy_default.properties file

		Properties defaultProperties = getPropertiesFromFile(pcloudDefaultProperties);
		capabilities.setCapability("username", defaultProperties.getProperty("username"));
		capabilities.setCapability("pCloudy_ApiKey", defaultProperties.getProperty("apiKey"));
		capabilities.setCapability("pCloudy_DurationInMinutes",
				Integer.parseInt(defaultProperties.getProperty("durationInMinutes")));
		capabilities.setCapability("newCommandTimeout", defaultProperties.getProperty("newCommandTimeout"));
		capabilities.setCapability("launchTimeout", defaultProperties.getProperty("launchTimeout"));
		capabilities.setCapability("automationName", isAndroid ? "uiautomator2" : "XCUITest");
		capabilities.setCapability("appPackage", "com.pcloudy.appiumdemo");
		capabilities.setCapability("appActivity", "com.ba.mobile.LaunchActivity");

		// Below properties are device specific, hence picked from properties file from
		// test/resources/devices
		capabilities.setCapability("pCloudy_ApplicationName", p.getProperty("applicationName"));

		if (!(p.getProperty("deviceName") == null || p.getProperty("deviceName").isBlank())) {
			capabilities.setCapability("pCloudy_DeviceManafacturer", p.getProperty("deviceName"));
		} else {
			capabilities.setCapability("pCloudy_DeviceVersion", p.getProperty("deviceVersion"));
			capabilities.setCapability("pCloudy_DeviceFullName", p.getProperty("deviceFullName"));
		}
		return capabilities;
	}

	private String getIOSAppPath() {
		File folder = new File(SplashMathConstants.IOS_APP_PATH);
		for (File f : folder.listFiles()) {
			if (f.getName().endsWith(".app") || f.getName().endsWith(".ipa")) {
				return f.getAbsolutePath();
			}
		}
		return null;
	}

	private String getAndroidAppPath() {
		File folder = new File(SplashMathConstants.ANDROID_APP_PATH);
		for (File f : folder.listFiles()) {
			if (f.getName().endsWith(".apk")) {
				return f.getAbsolutePath();
			}
		}
		return null;
	}

}
