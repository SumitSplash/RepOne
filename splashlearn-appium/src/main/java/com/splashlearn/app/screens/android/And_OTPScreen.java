package com.splashlearn.app.screens.android;

import java.io.IOException;

import com.splashlearn.app.screens.ios.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class And_OTPScreen extends BasePage {

	public And_OTPScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_verify_email_heading")
	private MobileElement VerifyYourEmailHeading;
	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_enter_verification_code")
	private MobileElement EmailSubHeading;
	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/et_first_otp")
	private MobileElement FirstOTPField;
	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/et_second_otp")
	private MobileElement SecondOtpField;
	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/et_third_otp")
	private MobileElement ThirdOtpField;
	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/et_fourth_otp")
	private MobileElement FourthOtpField;
	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_contact_us")
	private MobileElement ContactUs;
	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_verify_email_button")
	private MobileElement VerifyButton;
	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_resend_verification_email")
	private MobileElement ResendVerificationButton;
	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_verify_email_privacy_policy")
	private MobileElement PrivacyPolicyButton;
	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/iv_verify_email_cross_button")
	private MobileElement CloseBtn;

	public boolean VerifyYourEmailHeadingIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(VerifyYourEmailHeading);
	}

	public String VerifyYourEmailHeadingText() {
		String VerifyYourEmailHeadingText = appiumLibrary.getText(VerifyYourEmailHeading);
		return VerifyYourEmailHeadingText;
	}

	public String EmailSubHeadingText() {
		String EmailSubHeadingText = appiumLibrary.getText(EmailSubHeading);
		return EmailSubHeadingText;
	}

	public String ContactUsText() {
		String ContactUsText = appiumLibrary.getText(ContactUs);
		return ContactUsText;
	}

	public String VerifyButtonText() {
		String VerifyButtonText = appiumLibrary.getText(VerifyButton);
		return VerifyButtonText;
	}

	public String ResendVerificationButtonText() {
		String ResendVerificationButtonText = appiumLibrary.getText(ResendVerificationButton);
		return ResendVerificationButtonText;
	}

	public String PrivacyPolicyButtonText() {
		String PrivacyPolicyButtonText = appiumLibrary.getText(PrivacyPolicyButton);
		return PrivacyPolicyButtonText;
	}

	public void CloseBtnIsClicked() {
		appiumLibrary.click(CloseBtn);
	}

	public void VerifyBtnIsClicked() {
		appiumLibrary.click(VerifyButton);
	}

	public void FirstOTPFieldEnter(String Email) {
		appiumLibrary.enterText(FirstOTPField, Email);
	}

	public void SecondOtpFieldEnter(String Email) {
		appiumLibrary.enterText(SecondOtpField, Email);
	}

	public void ThirdOtpFieldEnter(String Email) {
		appiumLibrary.enterText(ThirdOtpField, Email);
	}

	public void FourthOtpFieldEnter(String Email) {
		appiumLibrary.enterText(FourthOtpField, Email);
	}

	public void EnterOTP(int OTP1, int OTP2, int OTP3, int OTP4) throws InterruptedException {
		String RealOTP1 = Integer.toString(OTP1);
		String RealOTP2 = Integer.toString(OTP2);
		String RealOTP3 = Integer.toString(OTP3);
		String RealOTP4 = Integer.toString(OTP4);
		FirstOTPFieldEnter(RealOTP1);
		SecondOtpFieldEnter(RealOTP2);
		ThirdOtpFieldEnter(RealOTP3);
		FourthOtpFieldEnter(RealOTP4);
		Thread.sleep(2000);
	}
}
