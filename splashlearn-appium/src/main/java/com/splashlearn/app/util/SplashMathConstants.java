package com.splashlearn.app.util;

public class SplashMathConstants {

	private SplashMathConstants() {
	}

	public static final int DEFAULT_TIMEOUT = 20;
	public static final int DEFAULT_MAX_TIMEOUT = 40;
	public static final String DEFAULT_GRADE = "Grade 1";
	public static final String DEFAULT_TOPIC = "Addition and Subtraction";

	public static final String DEFAULT_AGE_FOR_PASSCODE = "1963";
	public static final String APPIUM_SERVER = "http://localhost:4723/wd/hub";

	// Path
	public static final String CONFIG_PATH = System.getProperty("user.dir") + "/src/main/resources";
	public static final String OUTPUT_PATH = System.getProperty("user.dir") + "/test-output";
	public static final String APP_PATH = System.getProperty("user.dir") + "/app";
	public static final String IOS_APP_PATH = APP_PATH + "/ios";
	public static final String ANDROID_APP_PATH = APP_PATH + "/android";

	public static final String SCREENSHOT_PATH = OUTPUT_PATH + "/screenshots";
	public static final String EXTENT_REPORT_PATH = OUTPUT_PATH + "/reports";

	public static final String PCLOUDY_URL = "";

	public enum OSType {
		IOS, ANDROID
	}

}
