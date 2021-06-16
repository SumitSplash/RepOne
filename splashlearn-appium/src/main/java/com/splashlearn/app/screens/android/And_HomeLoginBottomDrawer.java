package com.splashlearn.app.screens.android;

import java.io.IOException;

import com.splashlearn.app.library.AppiumLibrary;
import com.splashlearn.app.screens.ios.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class And_HomeLoginBottomDrawer extends BasePage {

	public And_HomeLoginBottomDrawer(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup[2]/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView")
	private MobileElement MathGamesIcon;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/iv_dashboard_bottom_sheet_button")
	private MobileElement BottomSheetButton;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_pink_btn")
	private MobileElement LockedPopupOkBtn;
	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_title")
	private MobileElement LockedPopupHeading;

	public void LockedPopupOkBtnIsTapped() throws IOException {
		appiumLibrary.click(LockedPopupOkBtn);
	}

	public boolean MathGamesIconIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(MathGamesIcon);
	}

	public void MathGamesIconIsTapped() throws IOException {
		appiumLibrary.click(MathGamesIcon);
	}

	public void BottomSheetButtonIsTapped() throws IOException {
		appiumLibrary.click(BottomSheetButton);
	}

	public void scrollToIconNameAndClick(String GameName) {

		try {
			MobileElement el = ((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator(
					"new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
							+ "new UiSelector().text(\"" + GameName + "\"));");
			el.click();
		} catch (Exception e) {
			System.out.println("Element Not Found: " + e);
		}
	}

	public boolean scrollToIconName(String GameName) {
		MobileElement el = ((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView(" + "new UiSelector().text(\""
						+ GameName + "\"));");
		return new AppiumLibrary(driver).isElementPresent(el);
	}
}