package com.splashlearn.app.screens.android;

import java.io.IOException;

import com.splashlearn.app.screens.ios.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class And_StartYouFreeTrialScreenMathOnlyGrades extends BasePage {

	public And_StartYouFreeTrialScreenMathOnlyGrades(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[1]")
	private MobileElement StartYourFreeTrialHeading;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[2]")
	private MobileElement StartYourFreeTrialSubHeading;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_start_trial_bullet1")
	private MobileElement StartYourFreeTrialFirstPoint;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_start_trial_bullet2")
	private MobileElement StartYourFreeTrialSecondPoint;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_start_trial_bullet3")
	private MobileElement StartYourFreeTrialThirdPoint;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_view_plans")
	private MobileElement ViewPlanBtn;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/iv_close_start_trial")
	private MobileElement CloseBtn;

	public boolean StartYourFreeTrialHeadingIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(StartYourFreeTrialHeading);
	}

	public String StartYourFreeTrialHeadingText() {
		String StartYourFreeTrialHeadingText = appiumLibrary.getText(StartYourFreeTrialHeading);
		return StartYourFreeTrialHeadingText;
	}

	public String StartYourFreeTrialSubHeadingText() {
		String StartYourFreeTrialSubHeadingText = appiumLibrary.getText(StartYourFreeTrialSubHeading);
		return StartYourFreeTrialSubHeadingText;
	}

	public String StartYourFreeTrialFirstPointText() {
		String StartYourFreeTrialFirstPointText = appiumLibrary.getText(StartYourFreeTrialFirstPoint);
		return StartYourFreeTrialFirstPointText;
	}

	public String StartYourFreeTrialSecondPointText() {
		String StartYourFreeTrialSecondPointText = appiumLibrary.getText(StartYourFreeTrialSecondPoint);
		return StartYourFreeTrialSecondPointText;
	}

	public String StartYourFreeTrialThirdPointText() {
		String StartYourFreeTrialThirdPointText = appiumLibrary.getText(StartYourFreeTrialThirdPoint);
		return StartYourFreeTrialThirdPointText;
	}

	public String ViewPlanBtnText() {
		String ViewPlanBtnText = appiumLibrary.getText(ViewPlanBtn);
		return ViewPlanBtnText;
	}

	public void ViewPlanBtnIsClicked() {
		appiumLibrary.click(ViewPlanBtn);
	}

	public void CloseBtnIsClicked() {
		appiumLibrary.click(CloseBtn);
	}

	public static boolean scrollToText(AndroidDriver<MobileElement> driver, String text) {
		MobileElement el = driver.findElementByAndroidUIAutomator("new UiScrollable("
				+ "new UiSelector().scrollable(true)).scrollIntoView(" + "new UiSelector().text(\"" + text + "\"));");
		return el.isDisplayed();
	}
}
