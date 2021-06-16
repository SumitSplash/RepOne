package com.splashlearn.app.screens.android;

import java.io.IOException;

import org.decimal4j.util.DoubleRounder;

import com.splashlearn.app.screens.ios.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class And_SignupScreen extends BasePage {
	AgeGate AG = new AgeGate(driver);

	public And_SignupScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_sign_up_heading")
	private MobileElement SignUpScreenHeading;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_sign_up_sub_heading")
	private MobileElement SignUpScreenSubHeading;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_access_subscription")
	private MobileElement USPpoint1;
	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_save_child_learning")
	private MobileElement USPpoint2;
	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_child_weekly_report")
	private MobileElement USPpoint3;
	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/et_parent_email_sign_up")
	private MobileElement SignUpTextField;
	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_common_button")
	private MobileElement SignUpButton;
	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_classroom_account")
	private MobileElement ClassRoomAccountText;
	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_sign_up_terms_and_privacy")
	private MobileElement TermsAndPrivacyText;
	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/iv_sign_up_cross_button")
	private MobileElement CloseButton;

	public boolean SignUpScreenHeadingIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(SignUpScreenHeading);
	}

	public String SignUpScreenHeadingText() {
		String SignUpScreenHeadingText = appiumLibrary.getText(SignUpScreenHeading);
		return SignUpScreenHeadingText;
	}

	public String SignUpScreenSubHeadingText() {
		String SignUpScreenSubHeadingText = appiumLibrary.getText(SignUpScreenSubHeading);
		return SignUpScreenSubHeadingText;
	}

	public String USPpoint1Text() {
		String USPpoint1Text = appiumLibrary.getText(USPpoint1);
		return USPpoint1Text;
	}

	public String USPpoint2Text() {
		String USPpoint2Text = appiumLibrary.getText(USPpoint2);
		return USPpoint2Text;
	}

	public String USPpoint3Text() {
		String USPpoint3Text = appiumLibrary.getText(USPpoint3);
		return USPpoint3Text;
	}

	public String SignUpButtonText() {
		String SignUpButtonText = appiumLibrary.getText(SignUpButton);
		return SignUpButtonText;
	}

	public String ClassRoomAccountText() {
		String ClassRoomAccountTexts = appiumLibrary.getText(ClassRoomAccountText);
		return ClassRoomAccountTexts;
	}

	public String TermsAndPrivacyTexts() {
		String TermsAndPrivacyTexts = appiumLibrary.getText(TermsAndPrivacyText);
		return TermsAndPrivacyTexts;
	}

	public void SignUpButtonIsClicked() {
		appiumLibrary.click(SignUpButton);
	}

	public void CloseButtonIsClicked() {
		appiumLibrary.click(CloseButton);
	}

	public void SignUpTextFieldEnter(String Email) {
		appiumLibrary.enterText(SignUpTextField, Email);
	}

	public void SignupEmail(String Email) throws InterruptedException {
		SignUpTextFieldEnter(Email);
		SignUpButtonIsClicked();
		Thread.sleep(2000);

	}

	public String randomEmail() {
		double a = 1 + (Math.random() * 100);
		double b = 101 + (Math.random() * 200);
		double c = 201 + (Math.random() * 301);
		double result = a * b * c;
		double EmailNumber = DoubleRounder.round(result, 3);
		String email = "sb+tc" + EmailNumber + "@splashlearn.com";
		return email;
	}
}
