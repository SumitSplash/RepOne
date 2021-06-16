package com.splashlearn.app.screens.android;

import java.io.IOException;

import com.splashlearn.app.screens.ios.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class And_MathGamesLevelScreen extends BasePage {

	public And_MathGamesLevelScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/iv_common_background_back_button")
	private MobileElement BackButton;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/iv_common_background_title")
	private MobileElement PageHeading;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_game_cluster_chapter_number")
	private MobileElement LeveleId;

	@AndroidFindBy(id = "game-cont")
	private MobileElement RandomGameId1;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/action_bar_root")
	private MobileElement RandomGameId2;

	@AndroidFindBy(id = "android:id/content")
	private MobileElement RandomGameId3;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/drawer_web_activity")
	private MobileElement RandomGameId4;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.ImageView[2]")
	private MobileElement LevelIDX;

	@AndroidFindBy(id = "android:id/alertTitle")
	private MobileElement NoInternetpopupHeading;

	@AndroidFindBy(id = "android:id/button1")
	private MobileElement NoInternetpopupOkButton;

	@AndroidFindBy(id = "android:id/alertTitle")
	private MobileElement SomethingWentWrongPopupHeading;

	@AndroidFindBy(id = "android:id/button1")
	private MobileElement SomethingWentWrongPopupOkButton;

	public void TaponLevel(String text) {

		try {
			MobileElement el = ((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator(
					"new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
							+ "new UiSelector().text(\"" + text + "\"));");
			el.click();
		}

		catch (Exception e) {
			System.out.println("Element Not Found: " + e);
		}
	}

	public void PageHeadingisDisplayed() throws IOException {
		appiumLibrary.isElementPresent(PageHeading);

	}

	public String PageHeadingGetText() throws IOException {
		return appiumLibrary.getText(PageHeading);

	}

	public void LeveleIdisDisplayed() throws IOException {
		appiumLibrary.isElementPresent(LeveleId);
	}

	public void GameIDisDisplayed() throws IOException {
		appiumLibrary.isElementPresent(RandomGameId1);
		System.out.println("GameIDisDisplayed");

	}

	public void BackButtonIsTapped() throws IOException {
		appiumLibrary.click(BackButton);
	}

	public void TapOnGameLevelX() {
		appiumLibrary.click(LevelIDX);
	}

	public void scrollToLevelAndClick(String Level) {

		try {
			MobileElement el = ((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator(
					"new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
							+ "new UiSelector().text(\"" + Level + "\"));");
			el.click();
		}

		catch (Exception e) {
			System.out.println("Element Not Found: " + e);
		}
	}

	public boolean alertIsDisplayed() {
		return appiumLibrary.isElementPresent(NoInternetpopupHeading);
	}

	public void tapOnAlertOkButton() {
		appiumLibrary.click(NoInternetpopupOkButton);
	}

}
