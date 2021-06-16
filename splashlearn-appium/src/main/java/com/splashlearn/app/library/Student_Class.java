package com.splashlearn.app.library;

import java.io.IOException;

import org.testng.ITestContext;

import com.splashlearn.app.screens.android.AgeGate;
import com.splashlearn.app.screens.android.And_EditProfileScreen;
import com.splashlearn.app.screens.android.And_GetStartedScreen;
import com.splashlearn.app.screens.android.And_HomeLoginBottomDrawer;
import com.splashlearn.app.screens.android.And_HomeLoginScreen;
import com.splashlearn.app.screens.android.And_MathGamesLevelScreen;
import com.splashlearn.app.screens.android.And_MathGamesScreen;
import com.splashlearn.app.screens.android.And_MenuDrawer;
import com.splashlearn.app.screens.android.And_ParentDashboardScreen;
import com.splashlearn.app.screens.android.And_SettingsScreen;
import com.splashlearn.app.screens.ios.BasePage;
import com.splashlearn.app.util.Page_ScreenShot_Capture;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Student_Class extends BasePage {

	public String GAMES = "Games";
	public String Result;
	public And_GetStartedScreen GSS;
	public And_HomeLoginScreen HLS;
	public And_ParentDashboardScreen PDS;
	public And_HomeLoginBottomDrawer HLBD;
	public ITestContext context;
	public And_MathGamesScreen MGS;
	public And_MenuDrawer MD;
	public And_SettingsScreen SS;
	public And_EditProfileScreen EP;

	public AgeGate AG;
	public And_MathGamesLevelScreen MGLS;
//	public Logger log = Logger.getLogger("devpinoyLogger");

	public Student_Class(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(id = "android:id/alertTitle")
	private MobileElement NoInternetpopupHeading;

	@AndroidFindBy(id = "android:id/button1")
	private MobileElement NoInternetpopupOkButton;

	@AndroidFindBy(id = "com.splash.kids.education.learning.games.free.multiplication.reading.math.grade.app.splashmath:id/tv_common_background_heading")
	private MobileElement PageTitle;

	public boolean alertIsDisplayed() {
		return appiumLibrary.isElementPresent(NoInternetpopupHeading);
	}

	public void tapOnAlertOkButton() {
		appiumLibrary.click(NoInternetpopupOkButton);
	}

	public String PageTitleText() {
		return appiumLibrary.getText(PageTitle);
	}

	public void ChangeGradeFromDashboardAndLandingOnDashboard(String ChildName, String Grade, String Result,
			AndroidDriver<MobileElement> driver) throws IOException {

		GSS = new And_GetStartedScreen(driver);
		HLS = new And_HomeLoginScreen(driver);
		PDS = new And_ParentDashboardScreen(driver);
		HLBD = new And_HomeLoginBottomDrawer(driver);
		MGS = new And_MathGamesScreen(driver);
		MGLS = new And_MathGamesLevelScreen(driver);
		MD = new And_MenuDrawer(driver);
		SS = new And_SettingsScreen(driver);
		EP = new And_EditProfileScreen(driver);
		AG = new AgeGate(driver);
		PDS.MenuButtonIsTapped();

		Page_ScreenShot_Capture.ScreenshotTaken("Side_Menu_Screen", Result);
		MD.ChangeProfileAndLoginButtonIsDisplayed();

		MD.SettingsButtonIsTapped();

		AG.GrownUpTextIsDisplayed();

		Page_ScreenShot_Capture.ScreenshotTaken("Age_Gate_Screen", Result);
		AG.AgeGateNumberPad("1");
		AG.AgeGateNumberPad("9");
		AG.AgeGateNumberPad("9");
		AG.AgeGateNumberPad("1");

		SS.AccountTitleIsDisplayed();

		Page_ScreenShot_Capture.ScreenshotTaken("Settings_Screen", Result);
		AppiumLibrary.scrollToText(driver, ChildName);

		SS.FirstChildIsTapped();

		EP.ScreenNameTitleIsPresent();

		Page_ScreenShot_Capture.ScreenshotTaken("Edit_Profile", Result);
		AppiumLibrary.scrollToTextAndClick(driver, Grade);

		EP.ChangeGradePopupTitleIsPresent();

		Page_ScreenShot_Capture.ScreenshotTaken("Change_Grade_Screen", Result);
		EP.ChangeGradeYesButtonIsTapped();

		EP.SelectedGradeCorretlyDisplayed(Grade);

		EP.EditProfileBackButtonIsTapped();

		SS.SettingsBackButtonIsTapped();
		PDS.ChildNameIsDisplayed();

	}

	public void MathGamesScreenFromDashboard(String Result) throws IOException {

		PDS.BottomSheetButtonIsTapped();

		Page_ScreenShot_Capture.ScreenshotTaken("Bottom_Drawer_Screen", Result);
		// HLBD.MathGamesIconIsDisplayed();

		try {

			AppiumLibrary.scrollToTextAndClick((AndroidDriver<MobileElement>) driver, "Math Games");

		} catch (Exception e) {
			AppiumLibrary.scrollToTextAndClick((AndroidDriver<MobileElement>) driver, "Math Games");

		}
	}

	public void GameOpenFromMathGamesScreen(String GameName, String Level, String Result,
			AndroidDriver<MobileElement> driver) throws IOException, InterruptedException {

		try {
			AppiumLibrary.scrollToTextAndClick(driver, GameName);

			Thread.sleep(2000);

			AppiumLibrary.scrollToTextAndClick(driver, Level);
			Thread.sleep(20000);

			if (alertIsDisplayed() == false) {

				Thread.sleep(2000);

				Page_ScreenShot_Capture.ScreenshotTaken(GameName, Result);
				AppiumLibrary.PressDeviceBackButton();
				Thread.sleep(2000);
				AppiumLibrary.PressDeviceBackButton();
				Thread.sleep(2000);

			} else if (alertIsDisplayed() == true) {

				Page_ScreenShot_Capture.ScreenshotTaken(GameName, Result);

				tapOnAlertOkButton();
				Thread.sleep(2000);

				AppiumLibrary.PressDeviceBackButton();

				// MGS.GamePageHeadingPresent();

				// MGLS.BackButtonIsTapped();

				// MGS.GamePageHeadingPresent();

			}

		} catch (Exception e) {
			if (alertIsDisplayed() == true) {
				Page_ScreenShot_Capture.ScreenshotTaken(GameName, Result);
				tapOnAlertOkButton();
				Thread.sleep(2000);
				AppiumLibrary.PressDeviceBackButton();

			}

			else if (alertIsDisplayed() == false) {
				Page_ScreenShot_Capture.ScreenshotTaken(GameName, Result);
				System.out.println("Games Level or Games Not found");

			}

		}

	}

	public void MathGamesToDashboardScreen() throws IOException, InterruptedException {

		AppiumLibrary.PressDeviceBackButton();
		try {

			Thread.sleep(1000);
			if (HLBD.MathGamesIconIsDisplayed()) {
				AppiumLibrary.PressDeviceBackButton();

			} else {

			}

		} catch (Exception e) {
			AppiumLibrary.PressDeviceBackButton();
		}
	}
}