package com.splashlearn.app.screens.android;

import java.io.IOException;

import com.splashlearn.app.screens.ios.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class And_TermsOfUsePopup extends BasePage {

	public And_TermsOfUsePopup(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_terms_of_use_heading")
	private MobileElement TermsOfUseHeading;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_terms_of_use_permission")
	private MobileElement TermsOfUseSubHeading;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_terms_of_use_confirm")
	private MobileElement TermsOfUseConfirmText;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/cb_terms_of_use")
	private MobileElement ConfirmCheckBox;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_terms_of_use_ok_button")
	private MobileElement OkBtn;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.Toast")
	private MobileElement PleaseAcceptToast;

	public boolean TermsOfUseHeadingisDisplayed() {
		return appiumLibrary.isElementPresent(TermsOfUseHeading);
	}

	public String TermsOfUseHeadingGetText() {
		String TermsOfUseHeadingText = appiumLibrary.getText(TermsOfUseHeading);
		return TermsOfUseHeadingText;
	}

	public String TermsOfUseSubHeadingGetText() {
		String TermsOfUseSubHeadingText = appiumLibrary.getText(TermsOfUseSubHeading);
		return TermsOfUseSubHeadingText;
	}

	public String TermsOfUseConfirmGetText() {
		String TermsOfUseConfirmTextText = appiumLibrary.getText(TermsOfUseConfirmText);
		return TermsOfUseConfirmTextText;
	}

	public void ConfirmCheckBoxIsTapped() throws IOException {
		appiumLibrary.click(ConfirmCheckBox);
	}

	public String OkBtnGetText() {
		String OkBtnText = appiumLibrary.getText(OkBtn);
		return OkBtnText;
	}

	public void OkBtnIsTapped() throws IOException {
		appiumLibrary.click(OkBtn);
	}

	public String PleaseAcceptToastText() {
		String PleaseAcceptToastText = appiumLibrary.getText(PleaseAcceptToast);
		return PleaseAcceptToastText;
	}

}
