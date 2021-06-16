package com.splashlearn.app.screens.android;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;

import com.splashlearn.app.screens.ios.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class And_MathGamesScreen extends BasePage {

	public And_MathGamesScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/iv_common_background_back_button")
	private MobileElement BackButton;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_common_background_heading")
	private MobileElement GamesPageHeading;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_game_card_title")
	private MobileElement GamesNameID;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_pink_btn")
	private MobileElement LockedPopupOkBtn;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_title")
	private MobileElement LockedPopupHeading;

	public void LockedPopupOkBtnIsTapped() throws IOException {
		appiumLibrary.click(LockedPopupOkBtn);
	}

	public void BackButtonIsClicked() {
		appiumLibrary.click(BackButton);
	}

	public void GamePageHeadingPresent() {
		appiumLibrary.isElementPresent(GamesPageHeading);
	}

	public void MathGames(String GameName) {
		if (appiumLibrary.getText(GamesNameID).equals(GameName)) {
			System.out.println("GameNameIS: " + GameName);
			appiumLibrary.click(GamesNameID);
		}
	}

	public void ScrollUptoElement(String GameName) {
		if (appiumLibrary.getText(GamesNameID).equals(GameName)) {
			appiumLibrary.ScrollUptoElement(GamesNameID);
		}
	}

	public void GameName(String GameName) {
		List<MobileElement> element = appiumLibrary.getElements(By.id(
				"com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_game_card_title"));
		for (MobileElement elements : element) {
			if (appiumLibrary.getText(elements).equals(GameName)) {
				appiumLibrary.click(elements);
				break;
			}
		}
	}

	public static void scrollToText(AndroidDriver<MobileElement> driver, String text) {
		MobileElement el = driver.findElementByAndroidUIAutomator("new UiScrollable("
				+ "new UiSelector().scrollable(true)).scrollIntoView(" + "new UiSelector().text(\"" + text + "\"));");
	}

	public void scrollToGameNameAndClick(AndroidDriver<MobileElement> driver, String Text) {
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

	public String GetTextGame(AndroidDriver<MobileElement> driver, String GradeName)
			throws InterruptedException, IOException {
		try {
			MobileElement el = driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
							+ GradeName + "\").instance(0))"));

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

}
