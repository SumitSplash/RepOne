package com.splashlearn.test.android;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
//import org.apache.log4j.Logger;
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

public class AND_Login_Test_CaseGradePreKMath extends Hooks {
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
	public void AndroidLoginTestCaseGradePreKmath() throws InterruptedException, IOException {

		Device device = DeviceFactory.getInstance().getDevice("android", 8205);
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
		Thread.sleep(7000);

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
		Extent_Test_Manager.AssertTrue("Change Profile Button is displayed",
				MD.ChangeProfileAndLoginButtonIsDisplayed(), "Change Profile Button is not displayed");
		PSC.ScreenshotTaken("Menu Drawer Screen", Result);
		Extent_Test_Manager.AssertTrue("Settings Button is displayed", MD.SettingsButtonIsDisplayed(),
				"Settings Button is not displayed");
		Extent_Test_Manager.AssertTrue("Help Button is displayed", MD.HelpButtonIsDisplayed(),
				"Hepl Button is not displayed");
		Extent_Test_Manager.AssertTrue("Sound Button is displayed", MD.SoundButtonIsDisplayed(),
				"Sound Button is not displayed");
		Extent_Test_Manager.AssertTrue("Music Button is displayed", MD.MusicButtonIsDisplayed(),
				"Music Button is not displayed");
		MD.ChangeProfileAndLoginButtonIsTapped();
		String ExpChangeProfileHeading = "Change Profile";
		Extent_Test_Manager.AssertEquals("Change Profile Heading is getting correctly displayed.",
				CP.ElementGetText(driver, "Change Profile"), ExpChangeProfileHeading);
		PSC.ScreenshotTaken("Change Profile Screen", Result);

		String expCPHeading = "Change Profile";

		Extent_Test_Manager.AssertEquals("Change Profile Screen Heading is getting displayed.",
				PDS.ElementGetText(driver, "Change Profile"), expCPHeading);
		Extent_Test_Manager.AssertTrue("First Child ela name is getting displayed.", CP.SecondChildIsDisplayed(),
				"First Child is not getting displayed");
		Extent_Test_Manager.AssertTrue("Second Child nonela name is getting displayed.", CP.SecondChildIsDisplayed(),
				"Second child is not getting displayed");
		Extent_Test_Manager.AssertTrue("Add child button is displayed", CP.AddChildButtonIsDisplayed(),
				"Add child button is not displayed.");
		CP.AddChildButtonIsTapped();

		Assert.assertTrue(SGS.SelectGradeHeadingisDisplayed());
		Extent_Test_Manager.AssertTrue("Choose Grade screen is Displayed", SGS.SelectGradeHeadingisDisplayed(),
				"Choose Grade screen is not Displayed");
		String expSelectGradePB = "Select Grade";
		String expSelectFocusAreaPB = "Select Focus Area";
		// String expPlayPB = "Play";
		String expSelectGradeH = "Select Grade";
		String expSelectGradeSH = "Select your child’s grade and get access to the complete range of curriculum that we have.";

		PSC.ScreenshotTaken("Choose Grade Screen", Result);
		Extent_Test_Manager.AssertEquals("Select Grade progress bar text is correct",
				SGS.SelectGradeProgressBarGetText(), expSelectGradePB);
		Extent_Test_Manager.AssertEquals("Select Focus Area progress bar text is correct",
				SGS.SelectFocusAreaProgressBarGetText(), expSelectFocusAreaPB);
//		Extent_Test_Manager.AssertEquals("Play progress bar is correct", SGS.PlayProgressBarGetText(), expPlayPB);
		Extent_Test_Manager.AssertEquals("Select Grade Heading text is correct", SGS.SelectGradeHeadingGetText(),
				expSelectGradeH);
		Extent_Test_Manager.AssertEquals("Select Grade Subheading  text is correct", SGS.SelectGradeSubHeadingGetText(),
				expSelectGradeSH);
		try {
			List<String> actualGrades = Arrays.asList(PDS.ElementGetText(driver, "Pre-Kindergarten"),
					SGS.GradeKGetText(), PDS.ElementGetText(driver, "Grade 1"), PDS.ElementGetText(driver, "Grade 2"),
					PDS.ElementGetText(driver, "Grade 3"), PDS.ElementGetText(driver, "Grade 4"),
					PDS.ElementGetText(driver, "Grade 5"));

			List<String> expectedGrades = Arrays.asList("Pre-Kindergarten", "Kindergarten", "Grade 1", "Grade 2",
					"Grade 3", "Grade 4", "Grade 5");
			Extent_Test_Manager.AssertEqualsList("All Grades are correctly displayed on Select Grade screen",
					actualGrades, expectedGrades);
		}

		catch (Exception e) {
			Extent_Test_Manager.AssertFail("All Grades are correctly displayed on Select Grade screen",
					"All Grades are correctly displayed on Select Grade screen");
		}
		SGS.clickGrade(driver, "Pre-Kindergarten");
		Assert.assertTrue(SFA.FocusAreaHeadingisDisplayed());
		Extent_Test_Manager.AssertTrue("Choose Focus area screen is Displayed", SFA.FocusAreaHeadingisDisplayed(),
				"Choose focus area screen is not Displayed");
//		PSC.ScreenshotTaken("Choose Focus Area", Result);

		String expFocusAreaHeading = "Select Preferred Topics";
		String expFocusAreaSubHeading = "Your child will start with topics chosen by you.";
		String expDoNotWorryText = "Do not worry, you can change these selections any time.";
		String expChooseForMeText = "Choose for me";
		String expDoneText = "Done";
		Extent_Test_Manager.AssertEquals("Select Preferred Topic correct heading text is getting displayed.",
				SFA.FocusAreaHeadingGetText(), expFocusAreaHeading);
		Extent_Test_Manager.AssertEquals("Select Preferred Topic correct sub-heading text is getting displayed.",
				SFA.FocusAreaSubHeadingGetText(), expFocusAreaSubHeading);
		Extent_Test_Manager.AssertEquals("Select Preferred topic Do not worry text is getting correctly displayed",
				SFA.ChangeFocusAreaTextGetText(), expDoNotWorryText);
		Extent_Test_Manager.AssertEquals("Choose for me button correcy text is correctly displayed",
				SFA.chooseForMeButtonGetText(), expChooseForMeText);
		Extent_Test_Manager.AssertEquals("Done button correct text is getting displayed", SFA.DoneButtonGetText(),
				expDoneText);

		try {
			List<String> actualGradePreK = Arrays.asList(PDS.ElementGetText(driver, "Counting Sequence"),
					PDS.ElementGetText(driver, "Shapes & Patterns"), PDS.ElementGetText(driver, "Counting Objects"),
					PDS.ElementGetText(driver, "Sorting & Comparing"),
					PDS.ElementGetText(driver, "Addition & Subtraction"));

			List<String> expectedGradePreK = Arrays.asList("Counting Sequence", "Shapes & Patterns", "Counting Objects",
					"Sorting & Comparing", "Addition & Subtraction");
			Extent_Test_Manager.AssertEqualsList("Focus Area is correct for Grade PreK", actualGradePreK,
					expectedGradePreK);
		}

		catch (Exception e) {
			Extent_Test_Manager.AssertFail("Focus Area is correct for Grade PreK",
					"Focus Area is correct for Grade PreK");
		}

		SFA.BackButtonIsTapped();

		Extent_Test_Manager.AssertEquals("User is able to go back to Grade screen from Focus Area screen",
				SGS.SelectGradeHeadingGetText(), expSelectGradeH);

		SGS.clickGrade(driver, "Kindergarten");
		Assert.assertTrue(SFA.FocusAreaHeadingisDisplayed());
//		PSC.ScreenshotTaken("GradekChooseFocusAreaScreen", Result);
		try {
			List<String> actualGradeK = Arrays.asList(PDS.ElementGetText(driver, "Counting & Comparison"),
					PDS.ElementGetText(driver, "Addition & Subtraction"),
					PDS.ElementGetText(driver, "Place Value & Number Sense"),
					PDS.ElementGetText(driver, "Measurements and Data"), PDS.ElementGetText(driver, "Geometry"));

			List<String> expectedGradeK = Arrays.asList("Counting & Comparison", "Addition & Subtraction",
					"Place Value & Number Sense", "Measurements and Data", "Geometry");
			Extent_Test_Manager.AssertEqualsList("Focus Area is correct for Grade K", actualGradeK, expectedGradeK);
		}

		catch (Exception e) {
			Extent_Test_Manager.AssertFail("Focus Area is correct for Grade K", "Focus Area is correct for Grade K");
		}

		SFA.BackButtonIsTapped();
		SGS.clickGrade(driver, "Grade 1");
		Assert.assertTrue(SFA.FocusAreaHeadingisDisplayed());
//		PSC.ScreenshotTaken("Grade1ChooseFocusAreaScreen", Result);
		try {
			List<String> actualGrade1 = Arrays.asList(PDS.ElementGetText(driver, "Addition & Subtraction"),
					PDS.ElementGetText(driver, "Place Value & Number Sense"),
					PDS.ElementGetText(driver, "Add & Subtract within 100"), PDS.ElementGetText(driver, "Time & Money"),
					PDS.ElementGetText(driver, "Measurements and Data"), PDS.ElementGetText(driver, "Geometry"),
					PDS.ElementGetText(driver, "Addition & Subtraction Facts"));

			List<String> expectedGrade1 = Arrays.asList("Addition & Subtraction", "Place Value & Number Sense",
					"Add & Subtract within 100", "Time & Money", "Measurements and Data", "Geometry",
					"Addition & Subtraction Facts");
			Extent_Test_Manager.AssertEqualsList("Focus Area is correct for Grade 1", actualGrade1, expectedGrade1);
		}

		catch (Exception e) {
			Extent_Test_Manager.AssertFail("Focus Area is correct for Grade 1", "Focus Area is correct for Grade 1");
		}

		SFA.BackButtonIsTapped();
		SGS.clickGrade(driver, "Grade 2");
		Assert.assertTrue(SFA.FocusAreaHeadingisDisplayed());
//		PSC.ScreenshotTaken("Grade2ChooseFocusAreaScreen", Result);
		try {
			List<String> actualGrade2 = Arrays.asList(PDS.ElementGetText(driver, "Addition & Subtraction"),
					PDS.ElementGetText(driver, "Place Value & Number Sense"),
					PDS.ElementGetText(driver, "Add & Subtract within 1000"),
					PDS.ElementGetText(driver, "Time & Money"), PDS.ElementGetText(driver, "Measurements and Data"),
					PDS.ElementGetText(driver, "Geometry"));

			List<String> expectedGrade2 = Arrays.asList("Addition & Subtraction", "Place Value & Number Sense",
					"Add & Subtract within 1000", "Time & Money", "Measurements and Data", "Geometry");
			Extent_Test_Manager.AssertEqualsList("Focus Area is correct for Grade 2", actualGrade2, expectedGrade2);
		}

		catch (Exception e) {
			Extent_Test_Manager.AssertFail("Focus Area is correct for Grade 2", "Focus Area is correct for Grade 2");
		}

		SFA.BackButtonIsTapped();
		SGS.clickGrade(driver, "Grade 3");
		Assert.assertTrue(SFA.FocusAreaHeadingisDisplayed());
//		PSC.ScreenshotTaken("Grade3ChooseFocusAreaScreen", Result);
		try {
			List<String> actualGrade3 = Arrays.asList(PDS.ElementGetText(driver, "Place Value & Number Sense"),
					PDS.ElementGetText(driver, "Addition & Subtraction"),
					PDS.ElementGetText(driver, "Multiplication & Division"), PDS.ElementGetText(driver, "Fractions"),
					PDS.ElementGetText(driver, "Time & Money"), PDS.ElementGetText(driver, "Measurements and Data"),
					PDS.ElementGetText(driver, "Geometry"),
					PDS.ElementGetText(driver, "Advanced Multiplication & Division"));

			List<String> expectedGrade3 = Arrays.asList("Place Value & Number Sense", "Addition & Subtraction",
					"Multiplication & Division", "Fractions", "Time & Money", "Measurements and Data", "Geometry",
					"Advanced Multiplication & Division");
			Extent_Test_Manager.AssertEqualsList("Focus Area is correct for Grade 3", actualGrade3, expectedGrade3);
		}

		catch (Exception e) {
			Extent_Test_Manager.AssertFail("Focus Area is correct for Grade 3", "Focus Area is correct for Grade 3");
		}

		SFA.BackButtonIsTapped();
		SGS.clickGrade(driver, "Grade 4");
		Assert.assertTrue(SFA.FocusAreaHeadingisDisplayed());
//		PSC.ScreenshotTaken("Grade4ChooseFocusAreaScreen", Result);
		try {
			List<String> actualGrade4 = Arrays.asList(PDS.ElementGetText(driver, "Place Value & Number Sense"),
					PDS.ElementGetText(driver, "Algebra"), PDS.ElementGetText(driver, "Addition & Subtraction"),
					PDS.ElementGetText(driver, "Multiplication & Division"), PDS.ElementGetText(driver, "Fractions"),
					PDS.ElementGetText(driver, "Decimals"), PDS.ElementGetText(driver, "Measurements and Data"),
					PDS.ElementGetText(driver, "Geometry"));

			List<String> expectedGrade4 = Arrays.asList("Place Value & Number Sense", "Algebra",
					"Addition & Subtraction", "Multiplication & Division", "Fractions", "Decimals",
					"Measurements and Data", "Geometry");
			Extent_Test_Manager.AssertEqualsList("Focus Area is correct for Grade 4", actualGrade4, expectedGrade4);
		}

		catch (Exception e) {
			Extent_Test_Manager.AssertFail("Focus Area is correct for Grade 4", "Focus Area is correct for Grade 4");
		}

		SFA.BackButtonIsTapped();
		SGS.clickGrade(driver, "Grade 5");
		Assert.assertTrue(SFA.FocusAreaHeadingisDisplayed());
//		PSC.ScreenshotTaken("Grade5ChooseFocusAreaScreen", Result);
		try {
			List<String> actualGrade5 = Arrays.asList(PDS.ElementGetText(driver, "Decimals"),
					PDS.ElementGetText(driver, "Algebra"), PDS.ElementGetText(driver, "Multiplication & Division"),
					PDS.ElementGetText(driver, "Fractions"), PDS.ElementGetText(driver, "Decimal Arithmetic"),
					PDS.ElementGetText(driver, "Measurements and Data"), PDS.ElementGetText(driver, "Geometry"));

			List<String> expectedGrade5 = Arrays.asList("Decimals", "Algebra", "Multiplication & Division", "Fractions",
					"Decimal Arithmetic", "Measurements and Data", "Geometry");
			Extent_Test_Manager.AssertEqualsList("Focus Area is correct for Grade 5", actualGrade5, expectedGrade5);
		}

		catch (Exception e) {
			Extent_Test_Manager.AssertFail("Focus Area is correct for Grade 5", "Focus Area is correct for Grade 5");
		}

		SFA.BackButtonIsTapped();

		SGS.clickGrade(driver, "Grade 3");

		SFA.ClickFocusArea(driver, "Addition & Subtraction");

		SFA.DoneButtonIsTapped();
		String expEnterChildNameHeading = "Enter Child’s Screen Name";
		Extent_Test_Manager.AssertTrue("Enter Child Name Text box is Displayed", CP.EnterChildNameTexFieldIsDisplayed(),
				"Enter Child Name Text box is not Displayed");
		Extent_Test_Manager.AssertTrue("Done button is getting displayed", CP.EnterChildNameDoneBtnIsDisplayed(),
				"Done button is not getting displayed.");
		Extent_Test_Manager.AssertEquals("Correct Enter Child Name Heading is getting displayed",
				PDS.ElementGetText(driver, "Enter Child’s Screen Name"), expEnterChildNameHeading);
		PSC.ScreenshotTaken("Add Child Enter child Name Screen", Result);
		CP.EnterChildCloseBtn();
		Extent_Test_Manager.AssertTrue("Dashboard is getting displayed", PDS.ChildAvatarIsDisplayed(),
				"Dashboard screen is not getting displayed");
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

		PDS.scrollToTextAndClick(driver, "ela");
		Thread.sleep(3000);
		String expProfileScreenHeading = "Edit Profile";
		Extent_Test_Manager.AssertEquals("Edit Profile Screen - Heading is correctly displayed",
				PDS.ElementGetText(driver, "Edit Profile"), expProfileScreenHeading);

//		PDS.scrollToTextAndClick(driver, "We're coming soon for Grades 3, 4 and 5, so stay tuned!");
		PDS.scrollToTextAndClick(driver, "Math");
		Thread.sleep(3000);
		PDS.scrollToTextAndClick(driver, "Select Focus Area");
		Thread.sleep(3000);
//		PSC.ScreenshotTaken("Math Grade - Change Profile", Result);
		EP.GradePreKButtonIsTapped();
		try {
			List<String> actualGradePreK = Arrays.asList(PDS.ElementGetText(driver, "Counting Sequence"),
					PDS.ElementGetText(driver, "Shapes & Patterns"), PDS.ElementGetText(driver, "Counting Objects"),
					PDS.ElementGetText(driver, "Sorting & Comparing"),
					PDS.ElementGetText(driver, "Addition & Subtraction"));

			List<String> expectedGradePreK = Arrays.asList("Counting Sequence", "Shapes & Patterns", "Counting Objects",
					"Sorting & Comparing", "Addition & Subtraction");
			Extent_Test_Manager.AssertEqualsList("Focus Area is correct for Grade PreK", actualGradePreK,
					expectedGradePreK);
		}

		catch (Exception e) {
			Extent_Test_Manager.AssertFail("Focus Area is correct for Grade PreK",
					"Focus Area is correct for Grade PreK");
		}

		PDS.scrollToTextAndClick(driver, "Save");

		Thread.sleep(2000);

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

		String exp1stMathCardName = "Way to the Party Chapter 1.1";
		String expSecondPlayable = "Counting Sequence";
		String expPopupHeading = "Activity is locked";
		String expPopupSubHeading = "Please complete previous activities first.";
		Extent_Test_Manager.AssertEquals(
				"Correct First card (Way to the Party Chapter 1.1) is getting displayed as 1st card for Pre-K Math",
				PDS.ElementGetText(driver, "Way to the Party Chapter 1.1"), exp1stMathCardName);
		Extent_Test_Manager.AssertEquals("Math Dashboard 2nd correct playable is getting displayed for Pre-K Math ",
				PDS.ElementGetText(driver, "Counting Sequence"), expSecondPlayable);

		PDS.scrollToTextAndClick(driver, "Counting Sequence");
		Thread.sleep(3000);
		Extent_Test_Manager.AssertEquals("Locked popup Heading is correctly displayed", PDS.LockedPopupHeadingText(),
				expPopupHeading);
		Extent_Test_Manager.AssertEquals("Locked popup Sub-Heading is correctly displayed",
				PDS.LockedPopupSubHeadingText(), expPopupSubHeading);
//		PSC.ScreenshotTaken("Locked Popup Screen", Result);
		PDS.LockedPopupOkBtnIsTapped();

		Extent_Test_Manager.AssertEquals("Dashboard screen is getting displayed after closing activity is locked popup",
				PDS.ElementGetText(driver, "Way to the Party Chapter 1.1"), exp1stMathCardName);

		PDS.scrollToTextAndClick(driver, "Way to the Party Chapter 1.1");
		Thread.sleep(3000);
		try {

			if (MGLS.alertIsDisplayed()) {
				Extent_Test_Manager.AssertFail("Content Group - Leveled Readers 1st playable  is getting displayed",
						"Content Group - Leveled Readers 1st playable  is getting displayed");

				PSC.ScreenshotTaken("Content Group - Leveled Readers 1st playable  is getting displayed", Result);

				MGLS.tapOnAlertOkButton();

				// AppiumLibrary.PressDeviceBackButton();

			}
		} catch (Exception e) {
			Thread.sleep(19000);
			PSC.ScreenshotTaken("1st Card Playable Screen", Result);
			PDS.UserIsSendToPreviousScreen();
			Thread.sleep(1000);

		}
		Extent_Test_Manager.AssertEquals(
				"Dashboard screen is getting displayed after user comes from Daily Suggestion Games",
				PDS.ElementGetText(driver, "Way to the Party Chapter 1.1"), exp1stMathCardName);

		PDS.BottomSheetButtonIsTapped();
		PSC.ScreenshotTaken("Bottom Drawer Screen", Result);

		String expGames = "Games";
		String expMathFacts = "Math Facts";
		String exp1stContentGroup = "Counting Sequence";
		Extent_Test_Manager.AssertEquals("Correct Math Games icon text is getting displayed",
				PDS.ElementGetText(driver, "Games"), expGames);

		Extent_Test_Manager.AssertEquals("Correct Math Facts icon text is getting displayed",
				PDS.ElementGetText(driver, "Math Facts"), expMathFacts);

		Extent_Test_Manager.AssertEquals("Correct 1st Math Content Group icon text is getting displayed",
				PDS.ElementGetText(driver, "Counting Sequence"), exp1stContentGroup);

		PDS.scrollToTextAndClick(driver, "Games");
		Thread.sleep(3000);
		String expGamesScreen1stGame = "Way to the Party";
		Extent_Test_Manager.AssertEquals("Math Games screen screen is getting displayed",
				PDS.ElementGetText(driver, "Way to the Party"), expGamesScreen1stGame);

		try {
			List<String> actualGames = Arrays.asList(PDS.ElementGetText(driver, "Way to the Party"),
					PDS.ElementGetText(driver, "Sky Lands"), PDS.ElementGetText(driver, "Hide And Seek"),
					PDS.ElementGetText(driver, "Treehouse Party"), PDS.ElementGetText(driver, "Hoppy's List"),
					PDS.ElementGetText(driver, "Amusement Park"), PDS.ElementGetText(driver, "Cat Out"),
					PDS.ElementGetText(driver, "Bird Trouble"), PDS.ElementGetText(driver, "Blue's Adventure"),
					PDS.ElementGetText(driver, "Hungry Snails"), PDS.ElementGetText(driver, "Splash Party"),
					PDS.ElementGetText(driver, "Zoo Zoo Train"));

			List<String> expectedGames = Arrays.asList("Way to the Party", "Sky Lands", "Hide And Seek",
					"Treehouse Party", "Hoppy's List", "Amusement Park", "Cat Out", "Bird Trouble", "Blue's Adventure",
					"Hungry Snails", "Splash Party", "Zoo Zoo Train");
			Extent_Test_Manager.AssertEqualsList("All Maths Games are getting displayed", actualGames, expectedGames);
		}

		catch (Exception e) {
			Extent_Test_Manager.AssertFail("All Maths Games are getting displayed",
					"All Maths Games are getting displayed");
		}

		SC.GameOpenFromMathGamesScreen("Way to the Party", "1", Result, driver);

		SC.GameOpenFromMathGamesScreen("Sky Lands", "1", Result, driver);

		SC.GameOpenFromMathGamesScreen("Hide And Seek", "1", Result, driver);

		SC.GameOpenFromMathGamesScreen("Hoppy's List", "1", Result, driver);

		SC.GameOpenFromMathGamesScreen("Treehouse Party", "1", Result, driver);

		SC.GameOpenFromMathGamesScreen("Amusement Park", "1", Result, driver);

		SC.GameOpenFromMathGamesScreen("Cat Out", "1", Result, driver);

		SC.GameOpenFromMathGamesScreen("Bird Trouble", "1", Result, driver);

		SC.GameOpenFromMathGamesScreen("Blue's Adventure", "1", Result, driver);

		SC.GameOpenFromMathGamesScreen("Hungry Snails", "1", Result, driver);

		SC.GameOpenFromMathGamesScreen("Splash Party", "1", Result, driver);

		SC.GameOpenFromMathGamesScreen("Zoo Zoo Train", "1", Result, driver);

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
		PDS.scrollToTextAndClick(driver, "Counting Sequence");
		Thread.sleep(3000);
		String ExpFirstCardCS = "Way to the Party Chapter 1.1";
		Extent_Test_Manager.AssertEquals("Correct Content Group screen - Counting sequence is getting displayed",
				PDS.ElementGetText(driver, "Way to the Party Chapter 1.1"), ExpFirstCardCS);
		String expfirstmilestobneCS = "Number Sequence up to 5";
		Extent_Test_Manager.AssertEquals("Correct 1st Milestone Cloud is getting displayed",
				PDS.ElementGetText(driver, "Number Sequence up to 5"), expfirstmilestobneCS);
		PSC.ScreenshotTaken("Content Group Screen", Result);
//		CG.scrollToTextAndClick(driver, "Way to the Party Chapter 1.1");
//		Thread.sleep(22000);
//		PSC.ScreenshotTaken("Content Group screen - Counting sequence first playable Display", Result);

//		AppiumLibrary.PressDeviceBackButton();

		CG.NextContentGroupButtonIsTapped();
		Thread.sleep(2000);

		String ExpFirstCardSP = "In Front Or Behind";
		Extent_Test_Manager.AssertEquals("Correct Content Group screen - Shapes & Patterns is getting displayed",
				PDS.ElementGetText(driver, "In Front Or Behind"), ExpFirstCardSP);
//		PSC.ScreenshotTaken("Content Group Screen - Shapes & Patterns", Result);
		String expfirstmilestoneSP = "Understand Positional Words";
		Extent_Test_Manager.AssertEquals("Correct 1st Milestone Cloud is getting displayed",
				PDS.ElementGetText(driver, "Understand Positional Words"), expfirstmilestoneSP);
		PDS.scrollToTextAndClick(driver, "In Front Or Behind");

		Thread.sleep(15000);
		PSC.ScreenshotTaken("Content Group screen - Shapes & Patterns first playable Display", Result);

		AppiumLibrary.PressDeviceBackButton();
		Thread.sleep(1000);

		CG.NextContentGroupButtonIsTapped();
		Thread.sleep(2000);

		String ExpFirstCardCO = "Hide and Seek Chapter 1.1";
		Extent_Test_Manager.AssertEquals("Correct Content Group screen - Counting Objects is getting displayed",
				PDS.ElementGetText(driver, "Hide and Seek Chapter 1.1"), ExpFirstCardCO);
//		PSC.ScreenshotTaken("Content Group Screen - Counting Objects", Result);
		String expfirstmilestoneCD = "Count up to 5 Objects";
		Extent_Test_Manager.AssertEquals("Correct 1st Milestone Cloud is getting displayed",
				PDS.ElementGetText(driver, "Count up to 5 Objects"), expfirstmilestoneCD);
//		CG.scrollToTextAndClick(driver, "Hide and Seek Chapter 1.1");
//		Thread.sleep(22000);
//		PSC.ScreenshotTaken("Content Group screen - Counting Objects first playable Display", Result);

//		AppiumLibrary.PressDeviceBackButton();

		CG.NextContentGroupButtonIsTapped();
		Thread.sleep(5000);
		String ExpFirstCardSC = "Identify Pictures";
		Extent_Test_Manager.AssertEquals("Correct Content Group screen - Sorting & Comparing is getting displayed",
				PDS.ElementGetText(driver, "Identify Pictures"), ExpFirstCardSC);
		String expfirstmilestoneSC = "Sorting";
		Extent_Test_Manager.AssertEquals("Correct 1st Milestone Cloud is getting displayed", PDS.FirstMilestoneText(),
				expfirstmilestoneSC);
//		PSC.ScreenshotTaken("Content Group Screen - Sorting & Comparing", Result);
//		CG.scrollToTextAndClick(driver, "Identify Pictures");
//		Thread.sleep(15000);
//		PSC.ScreenshotTaken("Content Group screen - Sorting & Comparing first playable Display", Result);

//		AppiumLibrary.PressDeviceBackButton();

		CG.NextContentGroupButtonIsTapped();
		Thread.sleep(2000);

		String ExpFirstCardAS = "Blue's Adventure Chapter 1.1";
		Extent_Test_Manager.AssertEquals("Correct Content Group screen - Addition & Subtraction is getting displayed",
				PDS.ElementGetText(driver, "Blue's Adventure Chapter 1.1"), ExpFirstCardAS);
//		PSC.ScreenshotTaken("Content Group Screen - Addition & Subtraction", Result);

		String expfirstmilestoneAS = "Understand Concept of Addition";
		Extent_Test_Manager.AssertEquals("Correct 1st Milestone Cloud is getting displayed",
				PDS.ElementGetText(driver, "Understand Concept of Addition"), expfirstmilestoneAS);
		// CG.scrollToTextAndClick(driver, "Blue's Adventure Chapter 1.1");
		// Thread.sleep(22000);
		// PSC.ScreenshotTaken("Content Group screen - Addition & Subtraction first
		// playable Display", Result);

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
