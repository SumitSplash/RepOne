package com.splashlearn.test.android;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.splashlearn.app.library.AppiumLibrary;
import com.splashlearn.app.library.DeviceFactory;
import com.splashlearn.app.library.Student_Class;
import com.splashlearn.app.model.Device;
import com.splashlearn.app.screens.android.AgeGate;
import com.splashlearn.app.screens.android.And_BottomDrawerScreen;
import com.splashlearn.app.screens.android.And_BuyScreenMathOnlyGrades;
import com.splashlearn.app.screens.android.And_ChangeFocusArea;
import com.splashlearn.app.screens.android.And_ChangeProfileScreen;
import com.splashlearn.app.screens.android.And_ContentGroup;
import com.splashlearn.app.screens.android.And_EditProfileScreen;
import com.splashlearn.app.screens.android.And_GetStartedScreen;
import com.splashlearn.app.screens.android.And_HomeLoginBottomDrawer;
import com.splashlearn.app.screens.android.And_HomeLoginScreen;
import com.splashlearn.app.screens.android.And_MathFactsScreen;
import com.splashlearn.app.screens.android.And_MathGamesLevelScreen;
import com.splashlearn.app.screens.android.And_MathGamesScreen;
import com.splashlearn.app.screens.android.And_MenuDrawer;
import com.splashlearn.app.screens.android.And_OTPScreen;
import com.splashlearn.app.screens.android.And_ParentDashboardScreen;
import com.splashlearn.app.screens.android.And_PrivacyPolicyScreen;
import com.splashlearn.app.screens.android.And_SelectFocusArea;
import com.splashlearn.app.screens.android.And_SelectGradeScreen;
import com.splashlearn.app.screens.android.And_SetPassword;
import com.splashlearn.app.screens.android.And_SettingsScreen;
import com.splashlearn.app.screens.android.And_SignupScreen;
import com.splashlearn.app.screens.android.And_StartYouFreeTrialScreenMathOnlyGrades;
import com.splashlearn.app.screens.android.And_StartYourTrialScreenMELA;
import com.splashlearn.app.screens.android.And_TermsOfUsePopup;
import com.splashlearn.app.util.MailReader;
import com.splashlearn.app.util.Page_ScreenShot_Capture;
import com.splashlearn.app.util.Sending_Mail_Folder;
import com.splashlearn.test.Hooks;
import com.splashlearn.utils.extent.Extent_Test_Manager;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class And_Login_Test_CaseGrade2English extends Hooks {
	private static final File PageScreenShot = new File(System.getProperty("user.dir") + "//PageScreenshot//");

	public Object expectedGradePreK;
	public Object actualGradePreK;
	public And_GetStartedScreen GSS;
	public And_HomeLoginScreen HLS;
	public And_ParentDashboardScreen PDS;
	public And_HomeLoginBottomDrawer HLBD;
	public And_MathGamesScreen MGS;
	public And_MenuDrawer MD;
	public And_SettingsScreen SS;
	public And_EditProfileScreen EP;
	public Sending_Mail_Folder SM;
	public AgeGate AG;
	public And_MathGamesLevelScreen MGLS;
	public And_TermsOfUsePopup TOU;
	public ITestContext context;
	public Student_Class SC;
	public String Result;
	private final Logger logger = LogManager.getRootLogger();
	public And_PrivacyPolicyScreen PPS;
	public Page_ScreenShot_Capture PSC;
	public And_SelectGradeScreen SGS;
	public SoftAssert SA = new SoftAssert();

	public And_SelectFocusArea SFA;
	public And_StartYouFreeTrialScreenMathOnlyGrades SYFT;
	public And_SignupScreen SUS;
	public And_BuyScreenMathOnlyGrades BS;
	public MailReader MR;
	public And_OTPScreen OTP;
	public And_SetPassword SP;
	public And_BottomDrawerScreen BDS;
	public And_MathFactsScreen MFS;
	public And_ContentGroup CG;
	public And_ChangeProfileScreen CP;
	public And_ChangeFocusArea CFA;
	public And_StartYourTrialScreenMELA SYT;

	public AndroidDriver<MobileElement> driver;

	// public static Logger log = Logger.getLogger("devpinoyLogger");
	@BeforeTest
	public void beforeTest(ITestContext cont) throws IOException {
		Result = cont.getName();
		AppiumLibrary.DeleteFilesAll(PageScreenShot);

	}

	@Test
	public void AndroidLoginTestCaseGrade2English() throws InterruptedException, IOException {

		Device device = DeviceFactory.getInstance().getDevice("android", 8212);
		logger.debug(String.format("Test %s started on device %s", testName.get(), device.getId()));
		deviceThreadLocal.set(device);

		final AndroidDriver<MobileElement> driver = (AndroidDriver<MobileElement>) device.getDriver();
		AppiumLibrary appiumLibrary = new AppiumLibrary(driver);

		GSS = new And_GetStartedScreen(driver);
		HLS = new And_HomeLoginScreen(driver);
		PSC = new Page_ScreenShot_Capture(driver);
		PPS = new And_PrivacyPolicyScreen(driver);
		TOU = new And_TermsOfUsePopup(driver);
		SGS = new And_SelectGradeScreen(driver);
		SFA = new And_SelectFocusArea(driver);
		SYFT = new And_StartYouFreeTrialScreenMathOnlyGrades(driver);
		SUS = new And_SignupScreen(driver);

		BS = new And_BuyScreenMathOnlyGrades(driver);
		AG = new AgeGate(driver);
		MR = new MailReader(driver);
		OTP = new And_OTPScreen(driver);
		SP = new And_SetPassword(driver);
		PDS = new And_ParentDashboardScreen(driver);
		EP = new And_EditProfileScreen(driver);

		BDS = new And_BottomDrawerScreen(driver);
		MFS = new And_MathFactsScreen(driver);
		CG = new And_ContentGroup(driver);
		MD = new And_MenuDrawer(driver);
		CP = new And_ChangeProfileScreen(driver);
		EP = new And_EditProfileScreen(driver);
		CFA = new And_ChangeFocusArea(driver);
		SS = new And_SettingsScreen(driver);
		SYT = new And_StartYourTrialScreenMELA(driver);
		SC = new Student_Class(driver);

		Assert.assertTrue(GSS.GetStartedBtnIsDisplayed(), "Get Started Button Is Not Displayed");

		PSC.ScreenshotTaken("Get Started Screen", Result);

		GSS.AlreadyRegisteredBtnTapped();

		String expHeading = "Home Log in";
		String expLoginButton = "Login";

		Extent_Test_Manager.AssertEquals("Login Screen heading is getting displayed", HLS.HomeLoginHeadingGetText(),
				expHeading);
		PSC.ScreenshotTaken("Login Screen", Result);

		Extent_Test_Manager.AssertEquals("Login Screen Login Button text is getting correctly displayed",
				HLS.LoginBtnGetText(), expLoginButton);
		Extent_Test_Manager.AssertTrue("Parent Email field is getting displayed", HLS.EmailTextFieldisDIsplayed(),
				"Parent Email field is not getting displayed");
		Extent_Test_Manager.AssertTrue("Parent Password field is getting displayed", HLS.PasswordTextFieldIsDisplayed(),
				"Parent Password field is not getting displayed");

		HLS.LoginUser("sb+autotest@splashlearn.com", "123456");
		try {
			Extent_Test_Manager.AssertTrue("Child Name is displayed", PDS.ChildNameIsDisplayed(),
					"Child Name is not displayed");
		} catch (Exception e) {
			Extent_Test_Manager.AssertFail("Child Name is displayed", "Child Name is displayed");
			MGLS.tapOnAlertOkButton();
			driver.toggleWifi();
			Thread.sleep(1000);
			driver.toggleWifi();
			Thread.sleep(6000);
			HLS.LoginBtnisTapped();

		}
		Extent_Test_Manager.AssertTrue("Star earned is dipslayed", PDS.TotalStarEarnedIsDisplayed(),
				"Star earned is not dipslayed");
		Extent_Test_Manager.AssertTrue("Math Toggle button is displayed", PDS.MathToggleButtonIsDisplayed(),
				"Math Toggle button is not displayed");
		Extent_Test_Manager.AssertTrue("ELA toggle button is displayed", PDS.ElaToggleButtonIsDisplayed(),
				"ELA toggle button is not displayed");
		PDS.ElaToggleIsTapped();
		Extent_Test_Manager.AssertTrue("Bottom sheet button is displayed", PDS.BottomSheetButtonIsDisplayed(),
				"Bottom sheet button is not displayed");
		Extent_Test_Manager.AssertTrue("Menu button is displayed", PDS.MenuButtonIsDisplayed(),
				"Menu button is not displayed");
		Extent_Test_Manager.AssertTrue("Child avatar is getting displayed", PDS.ChildAvatarIsDisplayed(),
				"Child avatar is not getting displayed");
		Extent_Test_Manager.AssertTrue("Playable cards are getting displayed.", PDS.PlayableCardIsDisplayed(),
				"Playable cards are not getting displayed.");
		PSC.ScreenshotTaken("Dashboard", Result);
		PDS.MenuButtonIsTapped();
		MD.ChangeProfileAndLoginButtonIsTapped();
		CP.FirstChildIsTapped();
		Thread.sleep(4000);
		PDS.ElaToggleIsTapped();
		Thread.sleep(1000);

		PDS.MenuButtonIsTapped();

		MD.SettingsButtonIsTapped();
		AG.GrownUpTextIsDisplayed();
		AG.AgeGateNumberPad("1");
		AG.AgeGateNumberPad("9");
		AG.AgeGateNumberPad("9");
		AG.AgeGateNumberPad("1");
		Thread.sleep(2000);
		driver.toggleWifi();
		Thread.sleep(1000);
		driver.toggleWifi();
		Thread.sleep(6000);
		String expSettingHeading = "Settings";
		Extent_Test_Manager.AssertEquals("Settings Screen - Heading is correctly displayed",
				PDS.ElementGetText(driver, "Settings"), expSettingHeading);

		PDS.scrollToTextAndClick(driver, "ela");
		Thread.sleep(3000);
		String expProfileScreenHeading = "Edit Profile";
		Extent_Test_Manager.AssertEquals("Edit Profile Screen - Heading is correctly displayed",
				PDS.ElementGetText(driver, "Edit Profile"), expProfileScreenHeading);
		PDS.scrollToTextAndClick(driver, "We're coming soon for Grades 3, 4 and 5, so stay tuned!");
		Thread.sleep(3000);
		EP.Grade2ButtonIsTapped();
		PDS.scrollToTextAndClick(driver, "Save");
		Thread.sleep(2000);
		PDS.UserIsSendToPreviousScreen();
		Thread.sleep(1000);
		if (PDS.MenuButtonIsDisplayed() == true) {
			PDS.ChildAvatarIsDisplayed();
			// System.out.println("This is working.");

		}

		else if (PDS.MenuButtonIsDisplayed() == false) {

			Thread.sleep(2000);
			PDS.UserIsSendToPreviousScreen();
			Thread.sleep(1000);
			PDS.ChildAvatarIsDisplayed();

		}

		PDS.ElaToggleIsTapped();
		Thread.sleep(1000);
		String exp1stEnglishCardName = "Minecart: world";
		String expSecondPlayable = "Sound Pops: world";
		String expPopupHeading = "Activity is locked";
		String expPopupSubHeading = "Please complete previous activities first.";
		Extent_Test_Manager.AssertEquals("Correct First card is getting displayed for Grade 2 English",
				PDS.ElementGetText(driver, "Minecart: world"), exp1stEnglishCardName);
		Extent_Test_Manager.AssertEquals(
				"English Dashboard 2nd correct playable is getting displayed for Grade 2 English ",
				PDS.ElementGetText(driver, "Sound Pops: world"), expSecondPlayable);

		PDS.scrollToTextAndClick(driver, "Sound Pops: world");
		Thread.sleep(3000);
		Extent_Test_Manager.AssertEquals("Locked popup Heading is correctly displayed", PDS.LockedPopupHeadingText(),
				expPopupHeading);
		Extent_Test_Manager.AssertEquals("Locked popup Sub-Heading is correctly displayed",
				PDS.LockedPopupSubHeadingText(), expPopupSubHeading);
//		PSC.ScreenshotTaken("Locked Popup Screen", Result);
		PDS.LockedPopupOkBtnIsTapped();

		Extent_Test_Manager.AssertEquals("Dashboard screen is getting displayed after closing activity is locked popup",
				PDS.ElementGetText(driver, "Minecart: world"), exp1stEnglishCardName);

		PDS.scrollToTextAndClick(driver, "Minecart: world");
		Thread.sleep(22000);
		try {

			if (MGLS.alertIsDisplayed()) {

				PSC.ScreenshotTaken("Content Group - Leveled Readers 1st playable  is getting displayed", Result);
				Extent_Test_Manager.AssertFail("Content Group - Leveled Readers 1st playable  is getting displayed",
						"Content Group - Leveled Readers 1st playable  is getting displayed");
				MGLS.tapOnAlertOkButton();

			}
		} catch (Exception e) {

			PSC.ScreenshotTaken("1st Card Playable Screen", Result);
			PDS.UserIsSendToPreviousScreen();
			Thread.sleep(1000);
		}
		Extent_Test_Manager.AssertEquals(
				"Dashboard screen is getting displayed after user comes from Daily Suggestion Games",
				PDS.ElementGetText(driver, "Minecart: world"), exp1stEnglishCardName);

		PDS.BottomSheetButtonIsTapped();
		PSC.ScreenshotTaken("Bottom Drawer Screen", Result);

		PDS.scrollToTextAndClick(driver, "Reading Words");
		Thread.sleep(3000);
		String ExpFirstCard = "Explore Words With tch";
		Extent_Test_Manager.AssertEquals("Correct ELA Bottom drawer screen - Reading Words is getting displayed",
				PDS.ElementGetText(driver, "Explore Words With tch"), ExpFirstCard);
		PSC.ScreenshotTaken("Content Group Screen - Reading Words", Result);
		String expfirstmilestone = "Read Words with Trigraphs: tch, dge, igh";
		Extent_Test_Manager.AssertEquals("Correct Reading Words -  1st Milestone Cloud is getting displayed",
				PDS.ElementGetText(driver, "Read Words with Trigraphs: tch, dge, igh"), expfirstmilestone);

		PDS.scrollToTextAndClick(driver, "Explore Words With tch");
		Thread.sleep(22000);

		try {

			if (MGLS.alertIsDisplayed()) {

				PSC.ScreenshotTaken("Content Group - Leveled Readers 1st playable  is getting displayed", Result);
				Extent_Test_Manager.AssertFail("Content Group - Leveled Readers 1st playable  is getting displayed",
						"Content Group - Leveled Readers 1st playable  is getting displayed");
				MGLS.tapOnAlertOkButton();

				AppiumLibrary.PressDeviceBackButton();
				Thread.sleep(1000);

			}
		} catch (Exception e) {

			PSC.ScreenshotTaken("Content Group Reading Words - 1st playable  is getting displayed", Result);
			Thread.sleep(2000);
			AppiumLibrary.PressDeviceBackButton();
			Thread.sleep(1000);

			AppiumLibrary.PressDeviceBackButton();
			Thread.sleep(1000);

		}

		PDS.scrollToTextAndClick(driver, "Sight Words");

		Thread.sleep(3000);
		String ExpFirstCardSW = "We can read much faster when we can read words by sight.";
		Extent_Test_Manager.AssertEquals("Correct ELA Bottom drawer screen - Sight Words is getting displayed",
				PDS.ElementGetText(driver, "We can read much faster when we can read words by sight."), ExpFirstCardSW);
		PSC.ScreenshotTaken("Content Group Screen - Sight Words", Result);

		CG.SightWordsFirstPlayableIsTapped();
		Thread.sleep(22000);

		try {

			if (MGLS.alertIsDisplayed()) {

				PSC.ScreenshotTaken("Content Group - Sight Words 1st playable  is not getting displayed", Result);
				Extent_Test_Manager.AssertFail("Content Group - Sight Words 1st playable  is not getting displayed",
						"Content Group - Sight Words 1st playable  is not getting displayed");
				MGLS.tapOnAlertOkButton();

				AppiumLibrary.PressDeviceBackButton();
				Thread.sleep(1000);

			}
		} catch (Exception e) {

			PSC.ScreenshotTaken("Content Group Sight Words - 1st playable  is getting displayed", Result);

			AppiumLibrary.PressDeviceBackButton();
			Thread.sleep(1000);

			AppiumLibrary.PressDeviceBackButton();
			Thread.sleep(1000);
		}

		PDS.scrollToTextAndClick(driver, "Decodable Books");
		Thread.sleep(3000);

		String ExpFirstCarDDB = "If we know our letter sounds and blends, we can read these books in a flash.";
		Extent_Test_Manager.AssertEquals("Correct ELA Bottom drawer screen Decodable Books -  is getting displayed",
				PDS.ElementGetText(driver,
						"If we know our letter sounds and blends, we can read these books in a flash."),
				ExpFirstCarDDB);
		PSC.ScreenshotTaken("Content Group Screen - Decodable Books", Result);

		CG.DecodableBooksFirstPlayableIsTapped();
		Thread.sleep(22000);

		try {

			if (MGLS.alertIsDisplayed()) {

				PSC.ScreenshotTaken("Content Group - Leveled Readers 1st playable  is getting displayed", Result);
				Extent_Test_Manager.AssertFail("Content Group - Leveled Readers 1st playable  is getting displayed",
						"Content Group - Leveled Readers 1st playable  is getting displayed");
				MGLS.tapOnAlertOkButton();

				AppiumLibrary.PressDeviceBackButton();
				Thread.sleep(1000);

			}
		} catch (Exception e) {

			CG.AllowNotificationpopupIsTapped();
			Thread.sleep(3000);
			PSC.ScreenshotTaken("Content Group Decodable Books- 1st playable  is getting displayed", Result);

			AppiumLibrary.PressDeviceBackButton();
			Thread.sleep(1000);

			AppiumLibrary.PressDeviceBackButton();
			Thread.sleep(1000);
		}
		AppiumLibrary.PressDeviceBackButton();
		Thread.sleep(1000);
	}

	@AfterTest
	public void sendingEmail(ITestContext cont) throws IOException {
		Sending_Mail_Folder.SendMail("sumit.bansal@splashlearn.com", "sumit.bansal@splashlearn.com", cont.getName(),
				"PageScreenshot", " Screen Screenshots ");
	}

}
