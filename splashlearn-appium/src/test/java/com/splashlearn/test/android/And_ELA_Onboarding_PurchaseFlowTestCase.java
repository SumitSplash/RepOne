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
import com.splashlearn.app.screens.android.And_GooglePlayPurchaseScreen;
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

public class And_ELA_Onboarding_PurchaseFlowTestCase extends Hooks {
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

	public And_GooglePlayPurchaseScreen GPPS;

	public AndroidDriver<MobileElement> driver;

	// public static Logger log = Logger.getLogger("devpinoyLogger");
	@BeforeTest
	public void beforeTest(ITestContext cont) throws IOException {
		Result = cont.getName();
		AppiumLibrary.DeleteFilesAll(PageScreenShot);

	}

	@Test
	public void OnboardingPurchaseELATestCase() throws InterruptedException, IOException {
		Device device = DeviceFactory.getInstance().getDevice("android", 8217);
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
		GPPS = new And_GooglePlayPurchaseScreen(driver);

		String ExpGetStarted = "Get Started";
		String ExpTouHeading = "Terms of Use";
		String ExpTouSubHeading = "Please accept Terms & Conditions to continue using SplashLearn.";
		String ExpTouConfirmTxt = "I confirm that I am at least 18 years of age and I agree to the SplashLearn’s Terms of use and Privacy Policy.";
		String OkBtnText = "OK";
		Assert.assertTrue(GSS.GetStartedBtnIsDisplayed(), "Get Started Button Is Not Displayed");
		Extent_Test_Manager.AssertTrue("Get Started Screen Is Displayed", GSS.GetStartedBtnIsDisplayed(),
				"Get Started Screen Is Not Displayed");
		Extent_Test_Manager.AssertEquals("Get Started Button Text Is Correct", GSS.GetStartedBtnGetText(),
				ExpGetStarted);
		PSC.ScreenshotTaken("GetStartedScreen", Result);

		GSS.GetStartedBtnTapped();
		Assert.assertTrue(TOU.TermsOfUseHeadingisDisplayed());
		Extent_Test_Manager.AssertTrue("Terms of Use popup is displayed", TOU.TermsOfUseHeadingisDisplayed(),
				"Terms of Use Popup is Not Displayed");
		PSC.ScreenshotTaken("TermsOfUseScreen", Result);

		Extent_Test_Manager.AssertEquals("Terms Of Use Heading Text is correct", TOU.TermsOfUseHeadingGetText(),
				ExpTouHeading);
		Extent_Test_Manager.AssertEquals("Terms Of Use SubHeading Text is correct", TOU.TermsOfUseSubHeadingGetText(),
				ExpTouSubHeading);
		Extent_Test_Manager.AssertEquals("Terms Of Use Confirm Text is correct", TOU.TermsOfUseConfirmGetText(),
				ExpTouConfirmTxt);
		Extent_Test_Manager.AssertEquals("Terms Of Use Ok Button text is correct", TOU.OkBtnGetText(), OkBtnText);

		TOU.OkBtnIsTapped();

		TOU.ConfirmCheckBoxIsTapped();
		TOU.OkBtnIsTapped();

		Assert.assertTrue(SGS.SelectGradeHeadingisDisplayed());
		Extent_Test_Manager.AssertTrue("Choose Grade screen is Displayed", SGS.SelectGradeHeadingisDisplayed(),
				"Choose Grade screen is not Displayed");
		String expSelectGradePB = "Select Grade";
		String expSelectFocusAreaPB = "Select Focus Area";
		String expPlayPB = "Play";
		String expSelectGradeH = "Select Grade";
		String expSelectGradeSH = "Select your child’s grade and get access to the complete range of curriculum that we have.";

		PSC.ScreenshotTaken("ChooseGradeScreen", Result);
		Extent_Test_Manager.AssertEquals("Select Grade progress bar text is correct",
				SGS.SelectGradeProgressBarGetText(), expSelectGradePB);
		Extent_Test_Manager.AssertEquals("Select Focus Area progress bar text is correct",
				SGS.SelectFocusAreaProgressBarGetText(), expSelectFocusAreaPB);
		Extent_Test_Manager.AssertEquals("Play progress bar is correct", SGS.PlayProgressBarGetText(), expPlayPB);
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
		PSC.ScreenshotTaken("GradePrekChooseFocusAreaScreen", Result);

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

		// SGS.clickGrade(driver, "Grade 3");
		SFA.chooseForMeButtonIsTapped();

		String ExpTrialScreenHeading = "Start your free trial";

		Extent_Test_Manager.AssertEquals("Start Your Trial Screen is getting displayed",
				SYT.ElementGetText(driver, "Start your free trial"), ExpTrialScreenHeading);

		SYT.YearlyTabIsClicked();
		PSC.ScreenshotTaken("StartYourFreeTrialMelaYearlyPackScreen", Result);
		SYT.MonthlyTabIsClicked();
		PSC.ScreenshotTaken("StartYourFreeTrialMelaMonthlyPackScreen", Result);

		PDS.scrollToTextAndClick(driver, "Unique and Tailored");
		PSC.ScreenshotTaken("StartYourFreeTrialBottomScreen", Result);

		SYT.CloseButtonIsClicked();

		// ----Review Starts Here----//

		Assert.assertTrue(SUS.SignUpScreenHeadingIsDisplayed());
		Extent_Test_Manager.AssertTrue("Signup screen is displayed", SUS.SignUpScreenHeadingIsDisplayed(),
				"SignUp screen is not displayed");

		String expBuyScreenHeading = "Sign up on SplashLearn";
		String expBuyScreenSubheading = "Help your Kindergartner stay on top of Math";
		String expUspPoint1 = "Access your Subscription anywhere anytime";
		String expUspPoint2 = "Save your child’s learning progress";
		String expUspPoint3 = "Get your child’s weekly reports and free resources on your Email";
		String expClassRoomText = "Looking for classroom account?";
		String expContinueButtonText = "Continue";
		String expTAndCText = "By signing up for SplashLearn, you agree to our Terms of use and Privacy Policy.";

		Extent_Test_Manager.AssertEquals("Correct Sign up Heading text is getting displayed",
				SUS.SignUpScreenHeadingText(), expBuyScreenHeading);
		/*
		 * Extent_Test_Manager.
		 * AssertEquals("Correct Sign up SubHeading text is getting displayed",
		 * SUS.SignUpScreenSubHeadingText(), expBuyScreenSubheading);
		 */
		Extent_Test_Manager.AssertEquals("Correct Sign up USP First Line text is getting displayed",
				SUS.USPpoint1Text(), expUspPoint1);
		Extent_Test_Manager.AssertEquals("Correct Sign up USP Second Line text is getting displayed",
				SUS.USPpoint2Text(), expUspPoint2);
		Extent_Test_Manager.AssertEquals("Correct Sign up USP Third Line text is getting displayed",
				SUS.USPpoint3Text(), expUspPoint3);
		Extent_Test_Manager.AssertEquals("Correct Sign up Continue button text is getting displayed",
				SUS.SignUpButtonText(), expContinueButtonText);

		Extent_Test_Manager.AssertEquals("Correct Sign up Classroom text is getting displayed",
				SUS.ClassRoomAccountText(), expClassRoomText);
		Extent_Test_Manager.AssertEquals("Correct Sign up Privacy Policy text is getting displayed",
				SUS.TermsAndPrivacyTexts(), expTAndCText);
		PSC.ScreenshotTaken("SignUpScreen", Result);

		String Email = SUS.randomEmail();

		SUS.SignupEmail(Email);
		AG.GrownUpTextIsDisplayed();
		AG.AgeGateNumberPad("1");
		AG.AgeGateNumberPad("9");
		AG.AgeGateNumberPad("9");
		AG.AgeGateNumberPad("1");
		Thread.sleep(10000);
		Assert.assertTrue(OTP.VerifyYourEmailHeadingIsDisplayed());
		Extent_Test_Manager.AssertTrue("OTP screen is displayed", OTP.VerifyYourEmailHeadingIsDisplayed(),
				"OTP screen is not displayed");

		String ExpVerifyYourEmail = "Verify Your Email";
		String ExpVerifyEmailText = "Enter verification code here:";
		String ExpContactUs = "Your code may take few minutes to arrive. If you cannot see the email then please check your spam folder.";
		String VerifyButtonTxt = "Verify";
		Extent_Test_Manager.AssertEquals("Correct VerifyEmail Heading text is getting displayed",
				OTP.VerifyYourEmailHeadingText(), ExpVerifyYourEmail);
		Extent_Test_Manager.AssertEquals("Correct VerifyEmail  text is getting displayed", OTP.EmailSubHeadingText(),
				ExpVerifyEmailText);
		Extent_Test_Manager.AssertEquals("Correct VerifyEmail ContactUs text is getting displayed", OTP.ContactUsText(),
				ExpContactUs);
		Extent_Test_Manager.AssertEquals("Correct VerifyEmail VerifyButton text is getting displayed",
				OTP.VerifyButtonText(), VerifyButtonTxt);
		PSC.ScreenshotTaken("EnterOTPScreen", Result);
		int CompleteOTP = MailReader.GmailMailReader("Splashmath OTP/Other Emails", "Use code", 4);
		String CompOTP = Integer.toString(CompleteOTP);
		int OTP1 = Character.getNumericValue(CompOTP.charAt(0));
		int OTP2 = Character.getNumericValue(CompOTP.charAt(1));
		int OTP3 = Character.getNumericValue(CompOTP.charAt(2));
		int OTP4 = Character.getNumericValue(CompOTP.charAt(3));

		OTP.EnterOTP(OTP1, OTP2, OTP3, OTP4);
		Assert.assertTrue(SP.SetPasswordHeadingIsDisplayed());
		Extent_Test_Manager.AssertTrue("Set Password screen is getting displayed.", SP.SetPasswordHeadingIsDisplayed(),
				"Set Password screen is not getting displayed.");

		String ExpSetPasswordHeading = "Set Password";
		String ExpCheckboxText = "Show Password";
		String ExpDoneButtonText = "Done";

		Extent_Test_Manager.AssertEquals("Correct Set Password screen Heading text is getting displayed",
				SP.SetPasswordHeadingText(), ExpSetPasswordHeading);
		Extent_Test_Manager.AssertEquals("Correct Set Password screen checkbox text is getting displayed",
				SP.ShowPasswordCheckBoxDescriptionText(), ExpCheckboxText);

		Extent_Test_Manager.AssertEquals("Correct Set Password screen Done Button text is getting displayed",
				SP.DoneButtonText(), ExpDoneButtonText);
		PSC.ScreenshotTaken("SetPassword", Result);
		SP.SetPasswordFieldEnter("123456");
		SP.DoneButtonIsClicked();

		Assert.assertTrue(PDS.ChildNameIsDisplayed());
		Extent_Test_Manager.AssertTrue("Dashboard is displayed", PDS.ChildNameIsDisplayed(),
				"Dashboard is not displayed");
		PSC.ScreenshotTaken("DashboardBeforeScrolling", Result);

		PDS.MathToggleIsTapped();
		Thread.sleep(2000);

		PSC.ScreenshotTaken("Math Dashboard Screen", Result);

		PDS.UnlockButtonIsTapped();

		PDS.scrollToTextAndClick(driver, "Monthly");

		Thread.sleep(1000);

		PDS.scrollToTextAndClick(driver, "Start my free trial");
		Thread.sleep(3000);

		AG.GrownUpTextIsDisplayed();
		AG.AgeGateNumberPad("1");
		AG.AgeGateNumberPad("9");
		AG.AgeGateNumberPad("9");
		AG.AgeGateNumberPad("1");

		Thread.sleep(5000);

		Extent_Test_Manager.AssertTrue("Google Play Purchase - Pack Amount screen is getting displayed",
				GPPS.scrollToText(driver, "SplashLearn - Fun Math Learning Games for Kids"),
				"Google Play Purchase  - Pack Amount screen is not getting displayed");

		PDS.scrollToTextAndClick(driver, "Subscribe");
		Thread.sleep(3000);

		PDS.scrollToTextAndClick(driver, "Subscribe");

		Thread.sleep(4000);

		// Extent_Test_Manager.AssertTrue("Google Play Purchase - Enter Password screen
		// is getting displayed",
		// GPPS.scrollToText(driver, "SplashLearn Math and English (Monthly)"),
		// "Google Play Purchase - Enter Password screen is not getting displayed");

		GPPS.EnterPasswordTextField("splashlearnteam");

		Thread.sleep(1000);

		PDS.scrollToTextAndClick(driver, "Verify");

		Thread.sleep(8000);

		try {
			if (PDS.ChildNameIsDisplayed()) {
				System.out.println("Dashboard screen is getting displayed");
			}
		} catch (Exception e) {
			PDS.scrollToTextAndClick(driver, "Yes, always");

			Thread.sleep(1000);

			PDS.scrollToTextAndClick(driver, "OK");

			System.out.println("Yes always icon is getting displayed");

			Thread.sleep(8000);

		}

		PDS.MathToggleIsTapped();

		Thread.sleep(2000);

		PDS.BottomSheetButtonIsTapped();

		BDS.scrollToTextAndClick(driver, "Games");
		Thread.sleep(3000);

		try {
			BDS.scrollToTextAndClick(driver, "Way to the Party");
			Thread.sleep(3000);
			BDS.scrollToTextAndClick(driver, "1");
			Thread.sleep(22000);
			try {
				if (MGLS.alertIsDisplayed()) {

					Extent_Test_Manager.AssertFail("Way to the Party playable is  correctly displayed",
							"Way to the Party playable  not correctly displayed");
					// Page_ScreenShot_Capture.ScreenshotTaken(GameName, Result);

					MGLS.tapOnAlertOkButton();

					PDS.UserIsSendToPreviousScreen();
					Thread.sleep(1000);

					MGS.GamePageHeadingPresent();

				}
			} catch (Exception e) {

				// Page_ScreenShot_Capture.ScreenshotTaken(GameName, Result);

				AppiumLibrary.PressDeviceBackButton();
				Thread.sleep(1000);

				AppiumLibrary.PressDeviceBackButton();
				Thread.sleep(1000);
				// MGLS.BackButtonIsTapped();

				// MGS.GamePageHeadingPresent();

			}

			AppiumLibrary.PressDeviceBackButton();

			Thread.sleep(1000);

		}

		catch (Exception e) {
			Extent_Test_Manager.AssertFail("Way to the Party playable is correctly displayed",
					"Way to the Party playable is  correctly displayed");
			PDS.UserIsSendToPreviousScreen();
			Thread.sleep(1000);
			PDS.UserIsSendToPreviousScreen();
			Thread.sleep(1000);
		}

		try {
			BDS.scrollToTextAndClick(driver, "Math Facts");
			Thread.sleep(3000);

			Thread.sleep(2000);
			String expMathFactsHeading = "Math Facts";

			Extent_Test_Manager.AssertEquals("Math Facts screen is displayed.", MFS.MathFactsHeadingText(),
					expMathFactsHeading);
			// PSC.ScreenshotTaken("Math Facts Screen", Result);
			MFS.StartButtonIsTapped();
			Thread.sleep(7000);
			Extent_Test_Manager.AssertTrue("Math Facts content screen is getting displayed after purchase.",
					PDS.WorksheetPauseButtonIsDisplayed(),
					"Math Facts content screen is not getting displayed after purchase");
//			PDS.WorksheetPauseButtonIsTapped();
//			PDS.UserIsSendToPreviousScreen();
			Thread.sleep(1000);

		}

		catch (Exception e) {
			Extent_Test_Manager.AssertFail("Math Facts is opened", "Math Facts is opened");
		}

		PDS.UserIsSendToPreviousScreen();
		Thread.sleep(1000);
		PDS.UserIsSendToPreviousScreen();
		Thread.sleep(1000);
		BDS.scrollToTextAndClick(driver, "Counting Sequence");
		Thread.sleep(2000);
		CG.NextContentGroupButtonIsTapped();
		Thread.sleep(2000);
		BDS.scrollToTextAndClick(driver, "In Front Or Behind");
		try {
			Thread.sleep(15000);
			Extent_Test_Manager.AssertTrue(
					"Counting sequence playable content screen is getting displayed after purchase.",
					PDS.WorksheetPauseButtonIsDisplayed(),
					"Counting sequence playable content screen is not getting displayed after purchase");
//			PDS.WorksheetPauseButtonIsTapped();
//			PDS.UserIsSendToPreviousScreen();
		}

		catch (Exception e) {
			Extent_Test_Manager.AssertFail(
					"Counting sequence playable content screen is not getting displayed after purchase",
					"Counting sequence playable content screen is not getting displayed after purchase");
		}

		PDS.UserIsSendToPreviousScreen();
		Thread.sleep(1000);
		PDS.UserIsSendToPreviousScreen();
		Thread.sleep(1000);
		PDS.UserIsSendToPreviousScreen();

		Thread.sleep(2000);
		PDS.MenuButtonIsTapped();
		MD.ChangeProfileAndLoginButtonIsTapped();
		CP.AddChildButtonIsTapped();
		try {
			SGS.clickGrade(driver, "Grade 1");

			SFA.ClickFocusArea(driver, "Addition & Subtraction");

			SFA.DoneButtonIsTapped();

			CP.EnterChildName("Sam");

			CP.DoneButtonIsTapped();
			Thread.sleep(2000);
			PDS.MathToggleIsTapped();
			Thread.sleep(2000);
			String ExpAddChild = "Count all to Add";
			Thread.sleep(2000);
			Extent_Test_Manager.AssertEquals("Child is added and landed on dashboard.",
					PDS.ElementGetText(driver, "Count all to Add"), ExpAddChild);
		}

		catch (Exception e) {
			Extent_Test_Manager.AssertFail("Child is added and landed on dashboard.",
					"Child is added and landed on dashboard.");
		}

		Thread.sleep(9000);

	}

	@AfterTest
	public void sendingEmail(ITestContext cont) throws IOException {
		Sending_Mail_Folder.SendMail("sumit.bansal@splashlearn.com", "sumit.bansal@splashlearn.com", cont.getName(),
				"PageScreenshot", " Screen Screenshots ");
	}

}
