package com.splashlearn.test.android;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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

public class AND_Login_Test_CaseGrade3Math extends Hooks {
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

	@BeforeTest
	public void beforeTest(ITestContext cont) throws IOException {
		Result = cont.getName();
		AppiumLibrary.DeleteFilesAll(PageScreenShot);

	}

	@Test
	public void AndroidLoginTestCaseGrade3Math() throws InterruptedException, IOException {

		Device device = DeviceFactory.getInstance().getDevice("android", 8214);
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
		PSC.ScreenshotTaken("Dashboard", Result);
		Extent_Test_Manager.AssertTrue("Bottom sheet button is displayed", PDS.BottomSheetButtonIsDisplayed(),
				"Bottom sheet button is not displayed");
		Extent_Test_Manager.AssertTrue("Menu button is displayed", PDS.MenuButtonIsDisplayed(),
				"Menu button is not displayed");
		Extent_Test_Manager.AssertTrue("Child avatar is getting displayed", PDS.ChildAvatarIsDisplayed(),
				"Child avatar is not getting displayed");
		Extent_Test_Manager.AssertTrue("Playable cards are getting displayed.", PDS.PlayableCardIsDisplayed(),
				"Playable cards are not getting displayed.");

		PDS.MenuButtonIsTapped();
		MD.ChangeProfileAndLoginButtonIsTapped();
		CP.FirstChildIsTapped();
		Thread.sleep(4000);
		PDS.MathToggleIsTapped();
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

		SS.scrollToTextAndClick(driver, "ela");
		Thread.sleep(3000);
		String expProfileScreenHeading = "Edit Profile";
		Extent_Test_Manager.AssertEquals("Edit Profile Screen - Heading is correctly displayed",
				PDS.ElementGetText(driver, "Edit Profile"), expProfileScreenHeading);

//		PDS.scrollToTextAndClick(driver, "We're coming soon for Grades 3, 4 and 5, so stay tuned!");
		PDS.scrollToTextAndClick(driver, "Math");
		Thread.sleep(3000);
		PDS.scrollToTextAndClick(driver, "Select Focus Area");
		Thread.sleep(3000);
		// PSC.ScreenshotTaken("Math Grade - Change Profile", Result);
		EP.Grade3ButtonIsTapped();

		try {
			List<String> actualGradeK = Arrays.asList(PDS.ElementGetText(driver, "Place Value & Number Sense"),
					PDS.ElementGetText(driver, "Addition & Subtraction"),
					PDS.ElementGetText(driver, "Multiplication & Division"), PDS.ElementGetText(driver, "Fractions"),
					PDS.ElementGetText(driver, "Time & Money"), PDS.ElementGetText(driver, "Measurements and Data"),
					PDS.ElementGetText(driver, "Geometry"),
					PDS.ElementGetText(driver, "Advanced Multiplication & Division"));

			List<String> expectedGradeK = Arrays.asList("Place Value & Number Sense", "Addition & Subtraction",
					"Multiplication & Division", "Fractions", "Time & Money", "Measurements and Data", "Geometry",
					"Advanced Multiplication & Division");
			Extent_Test_Manager.AssertEqualsList("Focus Area is correct for Grade 3", actualGradeK, expectedGradeK);
		}

		catch (Exception e) {
			Extent_Test_Manager.AssertFail("Focus Area is correct for Grade 3", "Focus Area is correct for Grade 3");
		}

		EP.scrollToTextAndClick(driver, "Save");
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

		PDS.MathToggleIsTapped();
		Thread.sleep(1000);

		String exp1stMathCardName = "Complete the Place Value Chart";
		String expSecondPlayable = "Complete the Unit Form";
		String expPopupHeading = "Activity is locked";
		String expPopupSubHeading = "Please complete previous activities first.";
		Extent_Test_Manager.AssertEquals(
				"Correct First card (Complete the Place Value Chart) is getting displayed as 1st card for Grade 3 Math",
				PDS.ElementGetText(driver, "Complete the Place Value Chart"), exp1stMathCardName);
		Extent_Test_Manager.AssertEquals("Math Dashboard 2nd correct playable is getting displayed for Grade 3 Math ",
				PDS.ElementGetText(driver, "Complete the Unit Form"), expSecondPlayable);

		PDS.scrollToTextAndClick(driver, "Complete the Unit Form");
		Thread.sleep(3000);

		Extent_Test_Manager.AssertEquals("Locked popup Heading is correctly displayed", PDS.LockedPopupHeadingText(),
				expPopupHeading);
		Extent_Test_Manager.AssertEquals("Locked popup Sub-Heading is correctly displayed",
				PDS.LockedPopupSubHeadingText(), expPopupSubHeading);
//		PSC.ScreenshotTaken("Locked Popup Screen", Result);
		PDS.LockedPopupOkBtnIsTapped();

		Extent_Test_Manager.AssertEquals("Dashboard screen is getting displayed after closing activity is locked popup",
				PDS.ElementGetText(driver, "Complete the Place Value Chart"), exp1stMathCardName);

		PDS.scrollToTextAndClick(driver, "Complete the Place Value Chart");

		Thread.sleep(22000);
		PSC.ScreenshotTaken("1st Card Playable Screen", Result);
		PDS.UserIsSendToPreviousScreen();
		Thread.sleep(1000);
		Extent_Test_Manager.AssertEquals(
				"Dashboard screen is getting displayed after user comes from Daily Suggestion Games",
				PDS.ElementGetText(driver, "Complete the Place Value Chart"), exp1stMathCardName);

		PDS.BottomSheetButtonIsTapped();
		// PSC.ScreenshotTaken("Bottom Drawer Screen", Result);

		BDS.scrollToTextAndClick(driver, "Games");
		Thread.sleep(3000);
		String expGamesScreen1stGame = "Stranded";
		Extent_Test_Manager.AssertEquals("Math Games screen screen is getting displayed",
				PDS.ElementGetText(driver, "Stranded"), expGamesScreen1stGame);

		try {
			List<String> actualGames = Arrays.asList(PDS.ElementGetText(driver, "Stranded"),
					PDS.ElementGetText(driver, "Make Way"), PDS.ElementGetText(driver, "Sky Lands"),
					PDS.ElementGetText(driver, "Journey"), PDS.ElementGetText(driver, "Jelly Jungle"),
					PDS.ElementGetText(driver, "Glow"), PDS.ElementGetText(driver, "Jelly Shooter"),
					PDS.ElementGetText(driver, "Ice Trap"), PDS.ElementGetText(driver, "Topple Maze"),
					PDS.ElementGetText(driver, "Monster in the City"), PDS.ElementGetText(driver, "Granny's Rescue"),
					PDS.ElementGetText(driver, "Wilda's Wonders"), PDS.ElementGetText(driver, "Stack Jump"),
					PDS.ElementGetText(driver, "House of Light"), PDS.ElementGetText(driver, "Dial Shooter"),
					PDS.ElementGetText(driver, "The Gate"), PDS.ElementGetText(driver, "Beam Up!"),
					PDS.ElementGetText(driver, "Granny and the Monsters"));

			List<String> expectedGames = Arrays.asList("Stranded", "Make Way", "Sky Lands", "Journey", "Jelly Jungle",
					"Glow", "Jelly Shooter", "Ice Trap", "Topple Maze", "Monster in the City", "Granny's Rescue",
					"Wilda's Wonders", "Stack Jump", "House of Light", "Dial Shooter", "The Gate", "Beam Up!",
					"Granny and the Monsters");
			Extent_Test_Manager.AssertEqualsList("All Maths Games are getting displayed", actualGames, expectedGames);
		}

		catch (Exception e) {
			Extent_Test_Manager.AssertFail("All Maths Games are getting displayed",
					"All Maths Games are getting displayed");
		}

		SC.GameOpenFromMathGamesScreen("Glow", "1", Result, driver);
		SC.GameOpenFromMathGamesScreen("Jelly Shooter", "1", Result, driver);
		SC.GameOpenFromMathGamesScreen("Monster in the City", "1", Result, driver);
		SC.GameOpenFromMathGamesScreen("Granny's Rescue", "1", Result, driver);
		SC.GameOpenFromMathGamesScreen("Wilda's Wonders", "1", Result, driver);
		SC.GameOpenFromMathGamesScreen("Beam Up!", "1", Result, driver);
		SC.GameOpenFromMathGamesScreen("Granny and the Monsters", "1", Result, driver);
		SC.MathGamesToDashboardScreen();

		PDS.BottomSheetButtonIsTapped();

		PDS.scrollToTextAndClick(driver, "Math Facts");
		Thread.sleep(3000);
		String expMathFactsHeading = "Math Facts";
		Extent_Test_Manager.AssertEquals("Math Facts screen is displayed.", MFS.MathFactsHeadingText(),
				expMathFactsHeading);
		PSC.ScreenshotTaken("Math Facts Screen", Result);

		MFS.StartButtonIsTapped();
		Thread.sleep(5000);
		Extent_Test_Manager.AssertTrue("Math Facts content screen is getting displayed.",
				PDS.WorksheetPauseButtonIsDisplayed(), "Math Facts content screen is not getting displayed");

		PSC.ScreenshotTaken("Math Facts Content Screen", Result);
		AppiumLibrary.PressDeviceBackButton();
		Thread.sleep(1000);
		AppiumLibrary.PressDeviceBackButton();
		Thread.sleep(1000);
		PDS.scrollToTextAndClick(driver, "Place Value & Number Sense");
		Thread.sleep(3000);

		String ExpFirstCardPVNS = "Complete the Place Value Chart";
		Extent_Test_Manager.AssertEquals(
				"Correct Content Group screen - Place Value & Number Sense  is getting displayed",
				PDS.ElementGetText(driver, "Complete the Place Value Chart"), ExpFirstCardPVNS);
		String expfirstmilestonePVNS = "Read & Write Numbers";
		Extent_Test_Manager.AssertEquals("Correct 1st Milestone Cloud is getting displayed",
				PDS.ElementGetText(driver, "Read & Write Numbers"), expfirstmilestonePVNS);
		PSC.ScreenshotTaken("Content Group Screen - Place Value & Number Sense", Result);
		PDS.scrollToTextAndClick(driver, "Complete the Place Value Chart");
		Thread.sleep(15000);
		PSC.ScreenshotTaken("Content Group screen - Place Value & Number Sense first playable Display", Result);

		AppiumLibrary.PressDeviceBackButton();
		Thread.sleep(1000);

		CG.NextContentGroupButtonIsTapped();
		Thread.sleep(2000);

		String ExpFirstCardAS = "Add the Numbers - I";
		Extent_Test_Manager.AssertEquals("Correct Content Group screen - Addition & Subtraction is getting displayed",
				PDS.ElementGetText(driver, "Add the Numbers - I"), ExpFirstCardAS);
		PSC.ScreenshotTaken("Content Group Screen -Addition & Subtraction ", Result);
		String expfirstmilestoneAS = "Fluently Add within 1000";
		Extent_Test_Manager.AssertEquals("Correct 1st Milestone Cloud is getting displayed",
				PDS.ElementGetText(driver, "Fluently Add within 1000"), expfirstmilestoneAS);
//		CG.scrollToTextAndClick(driver, "Add the Numbers - I");
//		Thread.sleep(15000);
//		PSC.ScreenshotTaken("Content Group screen -  Addition & Subtraction first playable Display", Result);

//		AppiumLibrary.PressDeviceBackButton();

		CG.NextContentGroupButtonIsTapped();

		String ExpFirstCardMD = "Number of Groups and Size of Groups";
		Extent_Test_Manager.AssertEquals(
				"Correct Content Group screen - Multiplication & Division is getting displayed",
				PDS.ElementGetText(driver, "Number of Groups and Size of Groups"), ExpFirstCardMD);
//		PSC.ScreenshotTaken("Content Group Screen - Multiplication & Division ", Result);
		String expfirstmilestoneMD = "Build Foundation for Multiplication";
		Extent_Test_Manager.AssertEquals("Correct 1st Milestone Cloud is getting displayed",
				PDS.ElementGetText(driver, "Build Foundation for Multiplication"), expfirstmilestoneMD);
//		CG.scrollToTextAndClick(driver, "Number of Groups and Size of Groups");
//		Thread.sleep(15000);
//		PSC.ScreenshotTaken("Content Group screen - Multiplication & Division first playable Display", Result);

//		AppiumLibrary.PressDeviceBackButton();

		CG.NextContentGroupButtonIsTapped();

		String ExpFirstCardF = "Glow Chapter 1.1";
		Extent_Test_Manager.AssertEquals("Correct Content Group screen - Fractions is getting displayed",
				PDS.ElementGetText(driver, "Glow Chapter 1.1"), ExpFirstCardF);
//		PSC.ScreenshotTaken("Content Group Screen - Fractions", Result);
		String expfirstmilestoneF = "Understand & Represent Fractions";
		Extent_Test_Manager.AssertEquals("Correct 1st Milestone Cloud is getting displayed",
				PDS.ElementGetText(driver, "Understand & Represent Fractions"), expfirstmilestoneF);
//		CG.scrollToTextAndClick(driver, "Glow Chapter 1.1");
//		Thread.sleep(22000);
//		PSC.ScreenshotTaken("Content Group screen - Fractions first playable Display", Result);

//		AppiumLibrary.PressDeviceBackButton();

		CG.NextContentGroupButtonIsTapped();
		Thread.sleep(2000);

		String ExpFirstCardTM = "Read Time in Different Formats";
		Extent_Test_Manager.AssertEquals("Correct Content Group screen - Time & Money is getting displayed",
				PDS.ElementGetText(driver, "Read Time in Different Formats"), ExpFirstCardTM);
//		PSC.ScreenshotTaken("Content Group Screen - Time & Money", Result);
		String expfirstmilestoneTM = "Tell Time & Measure Elapsed Time";
		Extent_Test_Manager.AssertEquals("Correct 1st Milestone Cloud is getting displayed",
				PDS.ElementGetText(driver, "Tell Time & Measure Elapsed Time"), expfirstmilestoneTM);
//		CG.scrollToTextAndClick(driver, "Read Time in Different Formats");
//		Thread.sleep(15000);
//		PSC.ScreenshotTaken("Content Group screen - Time & Money first playable Display", Result);

//		AppiumLibrary.PressDeviceBackButton();

		CG.NextContentGroupButtonIsTapped();
		Thread.sleep(2000);

		String ExpFirstCardMAD = "Measure Lengths in Centimeters";
		Extent_Test_Manager.AssertEquals("Correct Content Group screen - Measurements and Data is getting displayed",
				PDS.ElementGetText(driver, "Measure Lengths in Centimeters"), ExpFirstCardMAD);
//		PSC.ScreenshotTaken("Content Group Screen - Measurements and Data ", Result);
		String expfirstmilestoneMAD = "Metric Units of Measurement";
		Extent_Test_Manager.AssertEquals("Correct 1st Milestone Cloud is getting displayed",
				PDS.ElementGetText(driver, "Metric Units of Measurement"), expfirstmilestoneMAD);
//		CG.scrollToTextAndClick(driver, "Measure Lengths in Centimeters");
//		Thread.sleep(15000);
//		PSC.ScreenshotTaken("Content Group screen - Measurements and Data first playable Display", Result);

//		AppiumLibrary.PressDeviceBackButton();

		CG.NextContentGroupButtonIsTapped();
		Thread.sleep(2000);

		String Exp2ndCardG = "Classify Triangles";
		Extent_Test_Manager.AssertEquals("Correct Content Group screen - Geometry is getting displayed",
				PDS.ElementGetText(driver, "Classify Triangles"), Exp2ndCardG);
//		PSC.ScreenshotTaken("Content Group Screen - Geometry ", Result);
		String expfirstmilestoneG = "Identify & Classify Shapes";
		Extent_Test_Manager.AssertEquals("Correct 1st Milestone Cloud is getting displayed",
				PDS.ElementGetText(driver, "Identify & Classify Shapes"), expfirstmilestoneG);
//		CG.scrollToTextAndClick(driver, "Classify Triangles");
//		Thread.sleep(15000);
//		PSC.ScreenshotTaken("Content Group screen - Geometry first playable Display", Result);

//		AppiumLibrary.PressDeviceBackButton();

		CG.NextContentGroupButtonIsTapped();
		Thread.sleep(2000);

		String ExpFirstCardAMD = "Multiply Tens, Hundreds, Thousands";
		Extent_Test_Manager.AssertEquals(
				"Correct Content Group screen - Advanced Multiplication & Division is getting displayed",
				PDS.ElementGetText(driver, "Multiply Tens, Hundreds, Thousands"), ExpFirstCardAMD);
//		PSC.ScreenshotTaken("Content Group Screen -	Advanced Multiplication & Division ", Result);
		String expfirstmilestone = "Multiply using Place Value Understanding";
		Extent_Test_Manager.AssertEquals("Correct 1st Milestone Cloud is getting displayed",
				PDS.ElementGetText(driver, "Multiply using Place Value Understanding"), expfirstmilestone);
//		CG.scrollToTextAndClick(driver, "Multiply Tens, Hundreds, Thousands");
//		Thread.sleep(15000);
//		PSC.ScreenshotTaken("Content Group screen -	Advanced Multiplication & Division first playable Display", Result);

		AppiumLibrary.PressDeviceBackButton();
		Thread.sleep(1000);

		AppiumLibrary.PressDeviceBackButton();
		Thread.sleep(1000);
		AppiumLibrary.PressDeviceBackButton();
		Thread.sleep(1000);
	}

	@AfterTest
	public void sendingEmail(ITestContext cont) throws IOException {
		Sending_Mail_Folder.SendMail("sumit.bansal@splashlearn.com", "sumit.bansal@splashlearn.com", cont.getName(),
				"PageScreenshot", " Screen Screenshots ");
	}

}
