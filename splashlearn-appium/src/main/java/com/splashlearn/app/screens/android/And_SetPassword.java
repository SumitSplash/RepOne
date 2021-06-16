package com.splashlearn.app.screens.android;

import java.io.IOException;

import com.splashlearn.app.screens.ios.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class And_SetPassword extends BasePage {

	public And_SetPassword(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_set_password_page_heading")
	private MobileElement SetPasswordHeading;
	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/et_password")
	private MobileElement SetPasswordField;
	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/checkbox_show_password")
	private MobileElement ShowPasswordCheckBox;
	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_show_password")
	private MobileElement ShowPasswordCheckBoxDescription;
	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_done_button")
	private MobileElement DoneButton;

	public boolean SetPasswordHeadingIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(SetPasswordHeading);
	}

	public boolean ShowPasswordCheckBoxDescriptionIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(ShowPasswordCheckBoxDescription);
	}

	public boolean DoneButtonIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(DoneButton);
	}

	public String SetPasswordHeadingText() {
		String SetPasswordHeadingText = appiumLibrary.getText(SetPasswordHeading);
		return SetPasswordHeadingText;
	}

	public String ShowPasswordCheckBoxDescriptionText() {
		String ShowPasswordCheckBoxDescriptionText = appiumLibrary.getText(ShowPasswordCheckBoxDescription);
		return ShowPasswordCheckBoxDescriptionText;
	}

	public String DoneButtonText() {
		String DoneButtonText = appiumLibrary.getText(DoneButton);
		return DoneButtonText;
	}

	public void SetPasswordFieldEnter(String password) {
		appiumLibrary.enterText(SetPasswordField, password);
	}

	public void DoneButtonIsClicked() {
		appiumLibrary.click(DoneButton);
	}

}
