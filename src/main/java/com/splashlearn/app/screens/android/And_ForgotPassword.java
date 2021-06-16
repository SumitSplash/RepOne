package com.splashlearn.app.screens.android;

import java.io.IOException;

import com.splashlearn.app.screens.ios.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class And_ForgotPassword extends BasePage {

	public And_ForgotPassword(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_reset_password_heading")
	private MobileElement ResetPasswordHeading;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/et_parent_email")
	private MobileElement ParentEmailTextField;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_send_instruction_button")
	private MobileElement SendMeInstructionButton;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_back_to_login")
	private MobileElement BackToLoginButton;

	public void ResetPasswordHeadingIsDisplayed() {
		appiumLibrary.isElementPresent(ResetPasswordHeading);
	}

	public String ResetPasswordHeadingGetText() {
		String ResetPasswordHeadingText = appiumLibrary.getText(ResetPasswordHeading);
		return ResetPasswordHeadingText;
	}

	public void ParentEmailTextFieldIsDisplayed() {
		appiumLibrary.isElementPresent(ParentEmailTextField);
	}

	public void ParentEmailTextFieldTapped() {
		appiumLibrary.click(ParentEmailTextField);
	}

	public void EnterInParentEmailTextField(String Email) throws IOException {
		appiumLibrary.enterText(ParentEmailTextField, Email);
	}

	public void SendMeInstructionButtonIsDisplayed() {
		appiumLibrary.isElementPresent(SendMeInstructionButton);
	}

	public void SendMeInstructionButtonTapped() {
		appiumLibrary.click(SendMeInstructionButton);
	}

	public String SendMeInstructionButtonGetText() {
		String SendMeInstructionButtonText = appiumLibrary.getText(SendMeInstructionButton);
		return SendMeInstructionButtonText;
	}

	public void BackToLoginButtonIsDisplayed() {
		appiumLibrary.isElementPresent(BackToLoginButton);
	}

	public void BackToLoginButtonTapped() {
		appiumLibrary.click(BackToLoginButton);
	}

	public String BackToLoginButtonGetText() {
		String BackToLoginButtonText = appiumLibrary.getText(BackToLoginButton);
		return BackToLoginButtonText;
	}
}
