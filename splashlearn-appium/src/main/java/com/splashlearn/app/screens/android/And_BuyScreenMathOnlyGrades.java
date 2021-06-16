package com.splashlearn.app.screens.android;

import java.io.IOException;

import com.splashlearn.app.screens.ios.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class And_BuyScreenMathOnlyGrades extends BasePage {

	public And_BuyScreenMathOnlyGrades(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tvBuyPageTitle")
	private MobileElement BuyScreenHeading;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tvBuyPageSubtitle")
	private MobileElement BuyScreenSubHeading;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_monthly_plan")
	private MobileElement MonthlyPack;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_yearly_plan")
	private MobileElement YearlyPack;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_monthly_current_price")
	private MobileElement MonthlyPrice;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_yearly_current_price")
	private MobileElement YearlyPrice;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_splash_math_saying")
	private MobileElement SplashMathSayingText;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_panel2_title")
	private MobileElement KeyFeatureText;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/iv_purchase_cancel")
	private MobileElement CloseBtn;

	public static void scrollToText(AndroidDriver<MobileElement> driver, String text) {
		MobileElement el = driver.findElementByAndroidUIAutomator("new UiScrollable("
				+ "new UiSelector().scrollable(true)).scrollIntoView(" + "new UiSelector().text(\"" + text + "\"));");
	}

	public boolean BuyScreenHeadingIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(BuyScreenHeading);
	}

	public String BuyScreenHeadingText() {
		String BuyScreenHeadingText = appiumLibrary.getText(BuyScreenHeading);
		return BuyScreenHeadingText;
	}

	public String BuyScreenSubHeadingText() {
		String BuyScreenSubHeadingText = appiumLibrary.getText(BuyScreenSubHeading);
		return BuyScreenSubHeadingText;
	}

	public String MonthlyPackText() {
		String MonthlyPackText = appiumLibrary.getText(MonthlyPack);
		return MonthlyPackText;
	}

	public String MonthlyPriceText() {
		String MonthlyPriceText = appiumLibrary.getText(MonthlyPrice);
		return MonthlyPriceText;
	}

	public String YearlyPriceText() {
		String YearlyPriceText = appiumLibrary.getText(YearlyPrice);
		return YearlyPriceText;
	}

	public String SplashMathSayingTextText() {
		String SplashMathSayingTextText = appiumLibrary.getText(SplashMathSayingText);
		return SplashMathSayingTextText;
	}

	public String KeyFeatureText() {
		String KeyFeatureTexts = appiumLibrary.getText(KeyFeatureText);
		return KeyFeatureTexts;
	}

	public String YearlyPackText() {
		String YearlyPackText = appiumLibrary.getText(YearlyPack);
		return YearlyPackText;
	}

	public void CloseBtnClicked() {
		appiumLibrary.click(CloseBtn);
	}

}
