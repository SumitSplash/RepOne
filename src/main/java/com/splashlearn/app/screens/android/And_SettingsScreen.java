package com.splashlearn.app.screens.android;

import java.io.IOException;

import com.splashlearn.app.screens.ios.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class And_SettingsScreen extends BasePage {

	public And_SettingsScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/account_title")
	private MobileElement AccountTitle;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_player_one")
	private MobileElement FirstChild;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_home")
	private MobileElement SettingsBackButton;

	@AndroidFindBy(id = "android:id/alertTitle")
	private MobileElement SignoutpopupHeading;
	@AndroidFindBy(id = "android:id/message")
	private MobileElement SignoutPopupText;
	@AndroidFindBy(id = "android:id/button1")
	private MobileElement SignoutPopupSignoutButton;
	@AndroidFindBy(id = "android:id/button2")
	private MobileElement SignoutPoupCancelButton;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_pink_btn")
	private MobileElement LockedPopupOkBtn;
	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_title")
	private MobileElement LockedPopupHeading;

	public void LockedPopupOkBtnIsTapped() throws IOException {
		appiumLibrary.click(LockedPopupOkBtn);
	}

	public void SignoutPopupSignoutButtonIsTapped() throws IOException {
		appiumLibrary.click(SignoutPopupSignoutButton);
	}

	public void SignoutPoupCancelButtonIsTapped() throws IOException {
		appiumLibrary.click(SignoutPoupCancelButton);
	}

	public void FirstChildIsTapped() throws IOException {
		appiumLibrary.click(FirstChild);
	}

	public void AccountTitleIsDisplayed() throws IOException {
		appiumLibrary.isElementPresent(AccountTitle);
	}

	public void SettingsBackButtonIsTapped() throws IOException {
		appiumLibrary.click(SettingsBackButton);
	}

	public String ElementGetText(AndroidDriver<MobileElement> driver, String text)
			throws InterruptedException, IOException {
		try {
			MobileElement el = driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
							+ text + "\").instance(0))"));

			Thread.sleep(4000);

			return el.getText();

		} catch (Exception e) {
			Thread.sleep(3000);
			if (LockedPopupHeading.isDisplayed() == true) {
				LockedPopupOkBtnIsTapped();
			}

			else if (LockedPopupHeading.isDisplayed() == false) {
				return "Element Not Found";
			}
			return "Element Not Found";
		}

	}

	public boolean ElementGetDisplay(AndroidDriver<MobileElement> driver, String text) {
		MobileElement el = driver.findElement(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ text + "\").instance(0))"));

		return el.isDisplayed();
	}

	public void scrollToTextAndClick(AndroidDriver<MobileElement> driver, String Text) {
		try {
			MobileElement el = driver.findElementByAndroidUIAutomator(
					"new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
							+ "new UiSelector().text(\"" + Text + "\"));");

			el.click();

		}

		catch (Exception e) {
			System.out.println("Element Not Found: " + e);
		}
	}

}
