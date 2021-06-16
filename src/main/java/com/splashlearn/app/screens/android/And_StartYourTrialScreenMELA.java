package com.splashlearn.app.screens.android;

import com.splashlearn.app.screens.ios.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class And_StartYourTrialScreenMELA extends BasePage {

	public And_StartYourTrialScreenMELA(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_ela_start_trial_title")
	private MobileElement StartYourFreeTrialHeading;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_ela_start_free_trial")
	private MobileElement StartYourFreeTrialButton;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/iv_ela_purchase_cancel")
	private MobileElement CloseButton;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/ela_yearly_switch")
	private MobileElement YearlyTab;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/ela_monthly_switch")
	private MobileElement MonthlyTab;

	public String StartYourFreeTrialHeadingText() {
		String StartYourFreeTrialHeadingText = appiumLibrary.getText(StartYourFreeTrialHeading);
		return StartYourFreeTrialHeadingText;
	}

	public static boolean scrollToText(AndroidDriver<MobileElement> driver, String text) {
		MobileElement el = driver.findElementByAndroidUIAutomator("new UiScrollable("
				+ "new UiSelector().scrollable(true)).scrollIntoView(" + "new UiSelector().text(\"" + text + "\"));");
		return el.isDisplayed();
	}

	public void StartYourFreeTrialButtonIsClicked() {
		appiumLibrary.click(StartYourFreeTrialButton);
	}

	public void CloseButtonIsClicked() {
		appiumLibrary.click(CloseButton);
	}

	public void YearlyTabIsClicked() {
		appiumLibrary.click(YearlyTab);
	}

	public void MonthlyTabIsClicked() {
		appiumLibrary.click(MonthlyTab);
	}

	public String ElementGetText(AndroidDriver<MobileElement> driver, String text) {
		MobileElement el = driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ text + "\").instance(0))"));

		return el.getText();
	}

}
