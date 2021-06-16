package com.splashlearn.app.screens.android;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Dimension;

import com.splashlearn.app.library.AppiumLibrary;
import com.splashlearn.app.screens.ios.BasePage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class And_ParentDashboardScreen extends BasePage {

	public String ElementNotFound = "Element Not Found";

	public And_ParentDashboardScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	public Dimension windowSize;
	public static Duration SCROLL_DUR = Duration.ofMillis(1000);
	public static double SCROLL_RATIO = 0.8;
	public static int ANDROID_SCROLL_DIVISOR = 3;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/iv_menu")
	private MobileElement MenuButton;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_milestone_title_selected")
	private MobileElement FirstMilestone;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/iv_child_avatar")
	private MobileElement ChildAvatar;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_child_full_name")
	private MobileElement ChildName;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_current_subject")
	private MobileElement CurrentSubject;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_total_stars_earned")
	private MobileElement TotalStarEarned;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/iv_dashboard_bottom_sheet_button")
	private MobileElement BottomSheetButton;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_pink_btn")
	private MobileElement PopupYesButton;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_card_title")
	private MobileElement BottomDrawerElement;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/iv_dashboard_unlock_character")
	private MobileElement UnlockButton;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_title")
	private MobileElement LockedPopupHeading;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_subtitle")
	private MobileElement LockedPopupSubHeading;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_pink_btn")
	private MobileElement LockedPopupOkBtn;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/iv_cross_button")
	private MobileElement LockedPopupCloseButton;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/bt_pause")
	private MobileElement WorksheetPauseButton;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/ivMath")
	private MobileElement MathToggleButton;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/ivEla")
	private MobileElement ElaToggleButton;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/iv_playable_card")
	private MobileElement PlayableCardCommon;

	public boolean MenuButtonIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(MenuButton);

	}

	public boolean LockedPopupHeadingIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(LockedPopupHeading);

	}

	public boolean PlayableCardIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(PlayableCardCommon);

	}

	public boolean FirstMilestoneIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(FirstMilestone);

	}

	public boolean LockedPopupSubHeadingsIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(LockedPopupSubHeading);

	}

	public boolean MathToggleButtonIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(MathToggleButton);

	}

	public boolean ElaToggleButtonIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(ElaToggleButton);

	}

	public boolean UnlockButtonIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(UnlockButton);

	}

	public boolean ChildAvatarIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(ChildAvatar);

	}

	public boolean ChildNameIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(ChildName);

	}

	public boolean CurrentSubjectIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(CurrentSubject);

	}

	public boolean TotalStarEarnedIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(TotalStarEarned);

	}

	public boolean BottomSheetButtonIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(BottomSheetButton);

	}

	public boolean WorksheetPauseButtonIsDisplayed() throws IOException {
		return appiumLibrary.isElementPresent(WorksheetPauseButton);

	}

	public void WorksheetPauseButtonIsTapped() throws IOException {
		appiumLibrary.click(WorksheetPauseButton);
	}

	public String ElementGetText(AndroidDriver<MobileElement> driver, String text)
			throws InterruptedException, IOException {
		try {
			MobileElement el = driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
							+ text + "\").instance(0))"));

			Thread.sleep(2000);

			return el.getText();

		} catch (Exception e) {
			Thread.sleep(3000);
			if (LockedPopupHeadingIsDisplayed() == true) {
				LockedPopupOkBtnIsTapped();
				return "Element Not Found";
			}

			else if (LockedPopupHeadingIsDisplayed() == false) {
				return "Element Not Found";
			}
			return "Element Not Found";
		}

	}

	public void GoBackToParticularScreenText(String TargetedScreenText) throws InterruptedException {

		if (driver
				.findElements(
						MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + TargetedScreenText + "\")"))
				.isEmpty()) {
			do {
				AppiumLibrary.PressDeviceBackButton();
				Thread.sleep(1000);
			}

			while (driver
					.findElements(MobileBy
							.AndroidUIAutomator("new UiSelector().textContains(\"" + TargetedScreenText + "\")"))
					.isEmpty());
		}

		else {

			System.out.println("We are on the Targeted screen");

		}

	}

	public void GoBackToParticularScreenElement(Boolean TargetedScreenElement) throws InterruptedException {

		if (TargetedScreenElement == true) {
			System.out.println("We are on the Targeted screen");
		}

		else

		{

			for (int i = 0; i <= 7; i++) {
				appiumLibrary.PressDeviceBackBtn();
				Thread.sleep(2000);
				if (TargetedScreenElement == true) {
					break;
				}
				break;
			}
		}

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

	public void MenuButtonIsTapped() throws IOException {
		appiumLibrary.click(MenuButton);
	}

	public void ChildAvatarIsTapped() throws IOException {
		appiumLibrary.click(ChildAvatar);

	}

	public void BottomSheetButtonIsTapped() throws IOException {
		appiumLibrary.click(BottomSheetButton);
	}

	public void PopupYesButtonIsTapped() throws IOException {
		appiumLibrary.click(PopupYesButton);
	}

	public String ChildNameText() {
		String ChildNameTextText = appiumLibrary.getText(ChildName);
		return ChildNameTextText;
	}

	public String FirstMilestoneText() {
		String ChildNameTextText = appiumLibrary.getText(FirstMilestone);
		return ChildNameTextText;
	}

	public String CurrentSubjectText() {
		String CurrentSubjectText = appiumLibrary.getText(CurrentSubject);
		return CurrentSubjectText;
	}

	public String TotalStarEarnedText() {
		String TotalStarEarnedText = appiumLibrary.getText(TotalStarEarned);
		return TotalStarEarnedText;
	}

	public String LockedPopupHeadingText() {
		String LockedPopupHeadingText = appiumLibrary.getText(LockedPopupHeading);
		return LockedPopupHeadingText;
	}

	public String LockedPopupSubHeadingText() {
		String LockedPopupSubHeadingText = appiumLibrary.getText(LockedPopupSubHeading);
		return LockedPopupSubHeadingText;
	}

	public void LockedPopupOkBtnIsTapped() throws IOException {
		appiumLibrary.click(LockedPopupOkBtn);
	}

	public void LockedPopupCloseButtonIsTapped() throws IOException {
		appiumLibrary.click(LockedPopupCloseButton);
	}

	public void UserIsSendToPreviousScreen() throws IOException {
		appiumLibrary.PressDeviceBackBtn();
	}

	public void UnlockButtonIsTapped() throws IOException {
		appiumLibrary.click(UnlockButton);

	}

	public void ElaToggleIsTapped() throws IOException {
		appiumLibrary.click(ElaToggleButton);
	}

	public void MathToggleIsTapped() throws IOException {
		appiumLibrary.click(MathToggleButton);
	}

	/*
	 * public void ScreenshotTaken() throws IOException {
	 * Page_ScreenShot_Capture.ScreenshotTaken("And_ParentHomeScreen"); }
	 */
}
