package com.splashlearn.app.screens.android;

import com.splashlearn.app.screens.ios.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class And_GetStartedScreen extends BasePage {

	public And_GetStartedScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_privacy_policy")
	private MobileElement PrivacyPolicyBtn;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_already_registered")
	private MobileElement AlreadyRegisteredBtn;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_getting_started")
	private MobileElement GetStartedBtn;

	public void PrivacyPolicyBtnTapped() {
		appiumLibrary.click(PrivacyPolicyBtn);
	}

	public String PrivacyPolicyBtnGetText() {
		String PrivacyBtnText = appiumLibrary.getText(PrivacyPolicyBtn);
		return PrivacyBtnText;
	}

	public void PrivacyPolicyBtnIsDisplayed() {
		appiumLibrary.isElementPresent(PrivacyPolicyBtn);
	}

	public void AlreadyRegisteredBtnTapped() {
		appiumLibrary.click(AlreadyRegisteredBtn);
	}

	public String AlreadyRegisteredBtnGetText() {
		String AlreadyRegisteredBtnText = appiumLibrary.getText(AlreadyRegisteredBtn);
		return AlreadyRegisteredBtnText;
	}

	public void AlreadyRegisteredBtnIsDisplayed() {
		appiumLibrary.isElementPresent(AlreadyRegisteredBtn);
	}

	public void GetStartedBtnTapped() {
		appiumLibrary.click(GetStartedBtn);
	}

	public String GetStartedBtnGetText() {
		String GetStartedBtnText = appiumLibrary.getText(GetStartedBtn);
		return GetStartedBtnText;
	}

	public boolean GetStartedBtnIsDisplayed() {
		return appiumLibrary.isElementPresent(GetStartedBtn);
	}

	/*
	 * public void ScreenshotTaken() throws IOException {
	 * Page_ScreenShot_Capture.ScreenshotTaken("And_GetStartedScreen"); }
	 */
}
