package com.splashlearn.app.screens.android;

import java.io.IOException;

import com.splashlearn.app.screens.ios.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class And_GooglePlayPurchaseScreen extends BasePage {

	public And_GooglePlayPurchaseScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[3]/android.widget.LinearLayout/android.widget.FrameLayout")
	private MobileElement SubscribeButton;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.EditText")
	private MobileElement EnterPasswordTextField;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_pink_btn")
	private MobileElement LockedPopupOkBtn;
	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_title")
	private MobileElement LockedPopupHeading;

	public void LockedPopupOkBtnIsTapped() throws IOException {
		appiumLibrary.click(LockedPopupOkBtn);
	}

	public void EnterPasswordTextField(String Email) throws IOException {
		appiumLibrary.enterText(EnterPasswordTextField, Email);
	}

	public void SubscribeButtonIsClicked() {
		appiumLibrary.click(SubscribeButton);
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

	public static boolean scrollToText(AndroidDriver<MobileElement> driver, String text) {
		MobileElement el = driver.findElementByAndroidUIAutomator("new UiScrollable("
				+ "new UiSelector().scrollable(true)).scrollIntoView(" + "new UiSelector().text(\"" + text + "\"));");
		return el.isDisplayed();
	}
}
