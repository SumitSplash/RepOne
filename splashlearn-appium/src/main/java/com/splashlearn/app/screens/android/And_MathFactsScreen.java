package com.splashlearn.app.screens.android;

import java.io.IOException;

import com.splashlearn.app.screens.ios.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class And_MathFactsScreen extends BasePage {

	public And_MathFactsScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_start")
	private MobileElement StartButton;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_title")
	private MobileElement MathFactsHeading;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/iv_math_facts_back_button")
	private MobileElement BackButton;

	public boolean MathFactsHeadingIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(MathFactsHeading);

	}

	public void StartButtonIsTapped() throws IOException {
		appiumLibrary.click(StartButton);
	}

	public void BackButtonIsTapped() throws IOException {
		appiumLibrary.click(BackButton);
	}

	public String MathFactsHeadingText() {
		String MathFactsHeadingText = appiumLibrary.getText(MathFactsHeading);
		return MathFactsHeadingText;
	}
}
