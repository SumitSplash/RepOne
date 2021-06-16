//this is 5th file

package com.splashlearn.app.library;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseLibrary {

	protected static AppiumDriver<MobileElement> driver;

	protected BaseLibrary(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}

}
