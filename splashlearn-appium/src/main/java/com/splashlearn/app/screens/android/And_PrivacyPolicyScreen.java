package com.splashlearn.app.screens.android;

import com.splashlearn.app.screens.ios.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class And_PrivacyPolicyScreen extends BasePage {

	public And_PrivacyPolicyScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_done")
	private MobileElement DoneBtn;

	public void DoneBtnIsDisplayed() {
		appiumLibrary.isElementPresent(DoneBtn);
	}

	public void DoneBtnTapped() {
		appiumLibrary.click(DoneBtn);
	}

	public String DoneBtnGetText() {
		String DoneBtnText = appiumLibrary.getText(DoneBtn);
		return DoneBtnText;
	}
}
