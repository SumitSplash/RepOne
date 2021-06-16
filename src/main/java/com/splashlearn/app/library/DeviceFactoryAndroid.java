//package com.splashlearn.app.library;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//import io.appium.java_client.MobileElement;
//import io.appium.java_client.android.AndroidDriver;
//
//public class DeviceFactoryAndroid {
//	private static ThreadLocal<AndroidDriver<MobileElement>> driver = new ThreadLocal<>();
//	private static DeviceFactoryAndroid deviceFactoryAndroid = null;
//	public static DeviceFactoryAndroid getInstance() {
//		if (deviceFactoryAndroid == null) {
//			deviceFactoryAndroid = new DeviceFactoryAndroid();
//		}
//		return deviceFactoryAndroid;
//	}
//	public DesiredCapabilities PcloudyCapabilities(String device) {
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		capabilities.setCapability("pCloudy_Username", "tppurchase@splashlearn.com");
//		capabilities.setCapability("pCloudy_ApiKey", "t5v6j27rspw4wyszjh9rbmbp");
//		capabilities.setCapability("pCloudy_DurationInMinutes", "3");
//		capabilities.setCapability("newCommandTimeout", "600");
//		capabilities.setCapability("launchTimeout", "90000");
//		capabilities.setCapability("pCloudy_DeviceFullName", device);
//		capabilities.setCapability("automationName", "uiautomator2");
//		capabilities.setCapability("appPackage",
//				"com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath");
//		capabilities.setCapability("appActivity",
//				"com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath.gettingStarted.activities.GettingStartedActivity");
////  capabilities.setCapability("pCloudy_WildNet", deviceName);
//		capabilities.setCapability("autoGrantPermissions", true);
//		capabilities.setCapability("pCloudy_ApplicationName", "app-prod-debug.apk");
////    capabilities.setCapability("xcodeSigningId", "iPhone Developer");
////    capabilities.setCapability("idleTimeout", 15000);
//		return capabilities;
//	}
//	public void setAndroidriver(String device) throws MalformedURLException {
//		driver.set(new AndroidDriver<MobileElement>(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"),
//				PcloudyCapabilities(device)));
//	}
//	public AndroidDriver<MobileElement> getDriver() {
//		return driver.get();
//	}
//	public static void tearDown() {
//		driver.remove();
//	}
//	public void close() {
//		if (driver.get() != null) {
//			driver.get().closeApp();
//			driver.get().quit();
//		}
//
//	}
//}
