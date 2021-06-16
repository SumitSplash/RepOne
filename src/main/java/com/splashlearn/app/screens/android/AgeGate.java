package com.splashlearn.app.screens.android;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;

import com.splashlearn.app.screens.ios.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AgeGate extends BasePage {

	public AgeGate(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/et_age_verification_first")
	private MobileElement FirstBox;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/et_age_verification_second")
	private MobileElement SecondBox;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/et_age_verification_third")
	private MobileElement ThirdBox;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/et_age_verification_fourth")
	private MobileElement FourthBox;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_grown_up_heading")
	private MobileElement GrownUpText;

	public void FirstBoxIsFilled(String First) throws IOException {
		appiumLibrary.enterText(FirstBox, First);
	}

	public void SecondBoxIsFilled(String Second) throws IOException {
		appiumLibrary.enterText(SecondBox, Second);
	}

	public void ThirdBoxIsFilled(String Third) throws IOException {
		appiumLibrary.enterText(ThirdBox, Third);
	}

	public void FourthBoxIsFilled(String Fourth) throws IOException {
		appiumLibrary.enterText(FourthBox, Fourth);
	}

	public void GrownUpTextIsDisplayed() throws IOException {
		appiumLibrary.isElementPresent(GrownUpText);
	}

	public void AgeGateNumberPad(String number) {
		List<MobileElement> element = appiumLibrary.getElements(By.id(
				"com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_age_verification_numpad_number"));

		for (MobileElement elements : element) {
			if (appiumLibrary.getText(elements).equals(number)) {
				appiumLibrary.click(elements);
				break;
			}
		}
	}
}
