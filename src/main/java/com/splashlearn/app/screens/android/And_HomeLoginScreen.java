package com.splashlearn.app.screens.android;

import java.io.IOException;

import com.splashlearn.app.screens.ios.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class And_HomeLoginScreen extends BasePage {

	public And_HomeLoginScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_parent_login_heading")
	private MobileElement HomeLoginHeading;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/iv_parent_login_cross_button")
	private MobileElement HomeCrossButton;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/et_parent_login_email")
	private MobileElement EmailTextField;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/et_parent_login_password")
	private MobileElement PasswordTextField;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_forgot_password")
	private MobileElement ForgotPasswordLink;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_new_user_registration")
	private MobileElement NewUserRegistraionLink;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_common_button")
	private MobileElement LoginBtn;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_classroom_account")
	private MobileElement ClassroomAccountBtn;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_parent_login_privacy_policy")
	private MobileElement PrivacyPolicyBtn;

	/*
	 * public void ScreenshotTaken() throws IOException {
	 * Page_ScreenShot_Capture.ScreenshotTaken("And_HomeLoginScreen"); }
	 */
	public void HomeLoginHeadingIsDisplayed() throws IOException {
		appiumLibrary.isElementPresent(HomeLoginHeading);
	}

	public String HomeLoginHeadingGetText() {
		String HomeLoginHeadingText = appiumLibrary.getText(HomeLoginHeading);
		return HomeLoginHeadingText;
	}

	public void HomeCrossButtonIsDisplayed() throws IOException {
		appiumLibrary.isElementPresent(HomeCrossButton);
	}

	public boolean EmailTextFieldisDIsplayed() throws IOException {
		return appiumLibrary.isElementPresent(EmailTextField);
	}

	public boolean PasswordTextFieldIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(PasswordTextField);
	}

	public void ForgotPasswordLinkIsDisplayed() throws IOException {
		appiumLibrary.isElementPresent(ForgotPasswordLink);
	}

	public String ForgotPasswordLinkGetText() {
		String ForgotPasswordLinkText = appiumLibrary.getText(ForgotPasswordLink);
		return ForgotPasswordLinkText;
	}

	public void NewUserRegistraionLinkIsDisplayed() throws IOException {
		appiumLibrary.isElementPresent(NewUserRegistraionLink);
	}

	public String NewUserRegistraionLinkGetText() {
		String NewUserRegistraionLinkText = appiumLibrary.getText(NewUserRegistraionLink);
		return NewUserRegistraionLinkText;
	}

	public void LoginBtnIsDisplayed() throws IOException {
		appiumLibrary.isElementPresent(LoginBtn);
	}

	public String LoginBtnGetText() {
		String LoginBtnText = appiumLibrary.getText(LoginBtn);
		return LoginBtnText;
	}

	public void ClassroomAccountBtnIsDisplayed() throws IOException {
		appiumLibrary.isElementPresent(ClassroomAccountBtn);
	}

	public String ClassroomAccountBtnGetText() {
		String ClassroomAccountBtnText = appiumLibrary.getText(ClassroomAccountBtn);
		return ClassroomAccountBtnText;
	}

	public void PrivacyPolicyBtnIsDisplayed() throws IOException {
		appiumLibrary.isElementPresent(PrivacyPolicyBtn);
	}

	public String PrivacyPolicyBtnGetText() {
		String PrivacyPolicyBtnText = appiumLibrary.getText(PrivacyPolicyBtn);
		return PrivacyPolicyBtnText;
	}

	public void HomeCrossButtonIsTapped() throws IOException {
		appiumLibrary.click(HomeCrossButton);
	}

	public void EnterInEmailTextField(String Email) throws IOException {
		appiumLibrary.enterText(EmailTextField, Email);
	}

	public void EnterInPasswordTextField(String Password) throws IOException {
		appiumLibrary.enterText(PasswordTextField, Password);
	}

	public void LoginBtnisTapped() throws IOException {
		appiumLibrary.click(LoginBtn);
	}

	public void ForgotPasswordLinkIsTapped() throws IOException {
		appiumLibrary.click(ForgotPasswordLink);
	}

	public void NewUserRegistraionLinkIsTapped() throws IOException {
		appiumLibrary.click(NewUserRegistraionLink);
	}

	public void ClassroomAccountBtnisTapped() throws IOException {
		appiumLibrary.click(ClassroomAccountBtn);
	}

	public void PrivacyPolicyBtnisTapped() throws IOException {
		appiumLibrary.click(PrivacyPolicyBtn);
	}

	public void LoginUser(String username, String password) throws IOException

	{
		EnterInEmailTextField(username);
		EnterInPasswordTextField(password);
		LoginBtnisTapped();
	}
}
