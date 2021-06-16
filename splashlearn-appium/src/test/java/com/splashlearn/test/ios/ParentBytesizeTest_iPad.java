package com.splashlearn.test.ios;

import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.splashlearn.app.library.AppiumLibrary;
import com.splashlearn.app.library.DeviceFactory;
import com.splashlearn.app.model.Device;
import com.splashlearn.app.screens.ios.LoginPage;
import com.splashlearn.app.screens.ios.OnBoardingPage;
import com.splashlearn.app.screens.ios.ParentDashboardPage;
import com.splashlearn.app.screens.ios.WorksheetPage;
import com.splashlearn.test.Hooks;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class ParentBytesizeTest_iPad extends Hooks {

	private final Logger logger = LogManager.getRootLogger();

	@Test
	public void onboarding() throws InterruptedException, MalformedURLException {
		Device device = DeviceFactory.getInstance().getDevice("ios", 8218);
		logger.debug(String.format("Test %s started on device %s", testName.get(), device.getId()));
		deviceThreadLocal.set(device);

		final AppiumDriver<MobileElement> driver = device.getDriver();
		AppiumLibrary appiumLibrary = new AppiumLibrary(driver);

		OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
		ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
		WorksheetPage worksheetPage = new WorksheetPage(driver);

		onBoardingPage.onBoardingFlow();
		if (appiumLibrary.isElementPresent(parentDashboardPage.menuBS)) {
			parentDashboardPage.playFirstLPCard();
			Assert.assertTrue(appiumLibrary.isElementPresent(MobileBy.AccessibilityId("SPCurriculumNavMenu")),
					"Bytesize 3.0/ELA flow onboarding is unsuccessful");
		} else if (appiumLibrary.isElementPresent(parentDashboardPage.settingButton)) {
			parentDashboardPage.clickBalloonOne();
			parentDashboardPage.clickStartContentCF();
			if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("Downloading sounds for the game..."), 5)) {
				worksheetPage.clickPlayAnyway();
			}
			Assert.assertTrue(appiumLibrary.isElementPresent(MobileBy.AccessibilityId("QPPause"), 90),
					"Content is unable to load");
			worksheetPage.clickPause();
			worksheetPage.clickHome();
			Assert.assertTrue(appiumLibrary.isElementPresent(MobileBy.AccessibilityId("BalloonCell0")),
					"Control flow onboarding is unsuccessful");
		} else if (appiumLibrary.isElementPresent(parentDashboardPage.byteSize2PLayButton)) {
			parentDashboardPage.clickByteSize2PlayButton();
			Assert.assertTrue(appiumLibrary.isElementPresent(MobileBy.AccessibilityId("byteSizeDashboardFloatingBox")),
					"Control flow onboarding is unsuccessful");
		}
	}

	@Test
	public void loginFromMenu() throws InterruptedException, MalformedURLException {
		Device device = DeviceFactory.getInstance().getDevice("ios", 8218);
		logger.debug(String.format("Test %s started on device %s", testName.get(), device.getId()));
		deviceThreadLocal.set(device);
		final AppiumDriver<MobileElement> driver = device.getDriver();
		AppiumLibrary appiumLibrary = new AppiumLibrary(driver);

		OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
		WorksheetPage worksheetPage = new WorksheetPage(driver);

		onBoardingPage.onBoardingFlow();
		if (appiumLibrary.isElementPresent(parentDashboardPage.menuBS)) {
			parentDashboardPage.clickMenuBS();
			parentDashboardPage.clickLoginButton();
			if (appiumLibrary.isElementPresent(parentDashboardPage.homeLogin, 1)) {
				parentDashboardPage.clickHomeLogin();
			}
			String expected = "sb+pela1@splashmath.com";
			loginPage.loginfromMenu(expected, "123456");
			Assert.assertFalse(
					appiumLibrary.isElementPresent(MobileBy.xpath("//XCUIElementTypeAlert[@name=\"Error\"]"), 10),
					"Email ID/ Password incorrect.");
			parentDashboardPage.playFirstLPCard();
			parentDashboardPage.clickMenuBS();
			parentDashboardPage.clickSettingsButton();
			parentDashboardPage.agePasscode();
			Assert.assertNotEquals(
					appiumLibrary.isElementPresent(MobileBy.AccessibilityId("Signed in as " + expected.toLowerCase())),
					expected, "Email id is not matched.");
		} else if (appiumLibrary.isElementPresent(parentDashboardPage.settingButton)) {
			parentDashboardPage.clickSettingButton();
			parentDashboardPage.clickLoginButton();
			if (appiumLibrary.isElementPresent(parentDashboardPage.homeLogin, 1)) {
				parentDashboardPage.clickHomeLogin();
			}
			String expected = "sb+pela1@splashmath.com";
			loginPage.loginWith(expected, "123456");
			Assert.assertFalse(
					appiumLibrary.isElementPresent(MobileBy.xpath("//XCUIElementTypeAlert[@name=\"Error\"]"), 10),
					"Email ID/ Password incorrect.");
			parentDashboardPage.playFirstLPCard();
			parentDashboardPage.clickMenuBS();
			parentDashboardPage.clickSettingsButton();
			parentDashboardPage.agePasscode();
			Assert.assertNotEquals(
					appiumLibrary.isElementPresent(MobileBy.AccessibilityId("Signed in as " + expected.toLowerCase())),
					expected, "Email id is not matched.");
		}

	}

	@Test
	public void loginFromFirstLandingPage() throws MalformedURLException {
		Device device = DeviceFactory.getInstance().getDevice("ios", 8219);
		deviceThreadLocal.set(device);
		AppiumDriver<MobileElement> driver = device.getDriver();
		AppiumLibrary appiumLibrary = new AppiumLibrary(driver);

		OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
		WorksheetPage worksheetPage = new WorksheetPage(driver);

		onBoardingPage.clickAlreadyRegister();
		if (appiumLibrary.isElementPresent(parentDashboardPage.homeLogin, 1)) {
			parentDashboardPage.clickHomeLogin();
		}
		String expected = "sb+pela1@splashmath.com";
		loginPage.loginWith(expected, "123456");
		Assert.assertFalse(
				appiumLibrary.isElementPresent(MobileBy.xpath("//XCUIElementTypeAlert[@name=\"Error\"]"), 10),
				"Email Id/Password is incorrect.");
		if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("Enable Notifications"))) {
			parentDashboardPage.clickEnableNotification();
			parentDashboardPage.clickAllow();
		}
		parentDashboardPage.playFirstLPCard();
		parentDashboardPage.clickMenuBS();
		parentDashboardPage.clickSettingsButton();
		parentDashboardPage.agePasscode();
		Assert.assertNotEquals(
				appiumLibrary.isElementPresent(MobileBy.AccessibilityId("Signed in as " + expected.toLowerCase())),
				expected, "Email Id is not matching");
	}

//
//    @Test
//    public void loginFromWelcomeBack() throws InterruptedException, MalformedURLException {
//
//        Device device = DeviceFactory.getInstance().getDevice("ios");
//        deviceThreadLocal.set(device);
//        AppiumDriver<MobileElement> driver = device.getDriver();
//        AppiumLibrary appiumLibrary = new AppiumLibrary(driver);
//
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//        WorksheetPage worksheetPage = new WorksheetPage(driver);
//
//
//        onBoardingPage.onBoardingFlowTillSignupPage();
//        String expected = "va+elan6@splashmath.com";
//        onBoardingPage.emailField(expected);
//        onBoardingPage.clickContinue();
//        onBoardingPage.agePasscode();
//        onBoardingPage.passwordLogin("123456");
//        int i = 0;
//        while (!appiumLibrary.isElementPresent(MobileBy.AccessibilityId("//XCUIElementTypeButton[@name=\"BSSideDrawerLogIn\"]/XCUIElementTypeStaticText")) && i < 10) {
//            driver.hideKeyboard();
//            onBoardingPage.clickLoginWB();
//            i++;
//        }
//        onBoardingPage.clickLoginWB();
//        parentDashboardPage.playFirstLPCard();
//        parentDashboardPage.clickMenuBS();
//        parentDashboardPage.clickSettingsButton();
//        onBoardingPage.agePasscode();
//        Assert.assertNotEquals(appiumLibrary.isElementPresent(MobileBy.AccessibilityId("Signed in as " + expected.toLowerCase())), expected, "Email id is not matching");
//    }
//
//    @Test
//    public void loginFromFifthLandingPage() throws MalformedURLException {
//
//        Device device = DeviceFactory.getInstance().getDevice("ios");
//        deviceThreadLocal.set(device);
//        AppiumDriver<MobileElement> driver = device.getDriver();
//        AppiumLibrary appiumLibrary = new AppiumLibrary(driver);
//
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//        SettingsPage settingPage = new SettingsPage(driver);
//        WorksheetPage worksheetPage = new WorksheetPage(driver);
//
//        onBoardingPage.clickAlreadyRegister();
//        onBoardingPage.clickHomeLogin();
//        loginPage.loginWith("va+elan2@splashlearn.com", "123456");
//        Assert.assertFalse(appiumLibrary.isElementPresent(MobileBy.xpath("//XCUIElementTypeAlert[@name=\"Error\"]"), 10), "Email ID/ Password incorrect.");
//        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("Enable Notifications"), 2)) {
//            parentDashboardPage.clickEnableNotification();
//            parentDashboardPage.clickAllow();
//        }
//        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("SPCurriculumNavMenu"), 2)) {
//            parentDashboardPage.clickMenuBS();
//            parentDashboardPage.clickSettingsButton();
//        } else {
//            parentDashboardPage.clickSettingButton();
//            parentDashboardPage.clickSettings();
//        }
//        parentDashboardPage.agePasscode();
//        settingPage.clickSignOut();
//        settingPage.clickSignOutA();
//        loginPage.clickLogin();
//        onBoardingPage.clickHomeLogin();
//        String expected = "va+staging@splashmath.com";
//        loginPage.loginWith(expected, "123456");
//        Assert.assertFalse(appiumLibrary.isElementPresent(MobileBy.xpath("//XCUIElementTypeAlert[@name=\"Error\"]"), 10), "Email ID/ Password incorrect.");
//        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("Enable Notifications"), 2)) {
//            parentDashboardPage.clickEnableNotification();
//            parentDashboardPage.clickAllow();
//        }
//        parentDashboardPage.playFirstLPCard();
//        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("SPCurriculumNavMenu"), 2)) {
//            parentDashboardPage.clickMenuBS();
//            parentDashboardPage.clickSettingsButton();
//        } else {
//            parentDashboardPage.clickSettingButton();
//            parentDashboardPage.clickSettings();
//        }
//        onBoardingPage.agePasscode();
//        SplashMathLibrary.sleep(3000);
//        Assert.assertNotEquals(appiumLibrary.isElementPresent(MobileBy.AccessibilityId("Signed in as " + expected.toLowerCase())), expected, "Email Id is not matching");
//    }
//
//    @Test
//    public void switchChild() throws InterruptedException, MalformedURLException {
//
//        Device device = DeviceFactory.getInstance().getDevice("ios");
//        deviceThreadLocal.set(device);
//        AppiumDriver<MobileElement> driver = device.getDriver();
//        AppiumLibrary appiumLibrary = new AppiumLibrary(driver);
//
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//        ChangeProfilePage changeProfilePage = new ChangeProfilePage(driver);
//        WorksheetPage worksheetPage = new WorksheetPage(driver);
//
//        onBoardingPage.clickAlreadyRegister();
//        loginPage.loginWith("va+ela101@splashmath.com", "123456");
//        Assert.assertFalse(appiumLibrary.isElementPresent(MobileBy.xpath("//XCUIElementTypeAlert[@name=\"Error\"]"), 10), "Email ID/ Password incorrect.");
//        parentDashboardPage.clickMenuBS();
//        parentDashboardPage.clickChangeProfileBS();
//        List<String> childNames = changeProfilePage.getChildName();
//        changeProfilePage.getChildCount();
//        String expected = childNames.get(1);
//        changeProfilePage.switchToChild(expected);
//        parentDashboardPage.playFirstLPCard();
//        parentDashboardPage.clickMenuBS();
//        parentDashboardPage.clickChangeProfileBS();
//        Assert.assertEquals(changeProfilePage.getSelectedChildName(), expected, "Unable to switch child successfully.");
//    }
//
//    @Test
//    public void addChild() throws MalformedURLException {
//
//        Device device = DeviceFactory.getInstance().getDevice("ios");
//        deviceThreadLocal.set(device);
//        AppiumDriver<MobileElement> driver = device.getDriver();
//        AppiumLibrary appiumLibrary = new AppiumLibrary(driver);
//
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//        ChangeProfilePage changeProfilePage = new ChangeProfilePage(driver);
//        WorksheetPage worksheetPage = new WorksheetPage(driver);
//        SettingsPage settingsPage = new SettingsPage(driver);
//
//        onBoardingPage.clickAlreadyRegister();
//        onBoardingPage.clickHomeLogin();
//        loginPage.loginWith("va+elan4@splashlearn.com", "123456");
//        Assert.assertFalse(appiumLibrary.isElementPresent(MobileBy.xpath("//XCUIElementTypeAlert[@name=\"Error\"]"), 10), "Email ID/ Password incorrect.");
//        parentDashboardPage.clickMenuBS();
//        parentDashboardPage.clickChangePRofileIpad();
//        Assert.assertNotEquals(changeProfilePage.getChildName().size(), 3, "Already 3 child exist");
//        changeProfilePage.isChildPresent();
//        Assert.assertFalse(appiumLibrary.isElementPresent(MobileBy.xpath("//XCUIElementTypeButton[@name=\"Subscribe\"]")), "User is not subscribed, So Add child flow is terminated.");
//        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("You can add more accounts from Settings."), 1)) {
//            changeProfilePage.selectGrade();
//        }
//        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("This will help us personalize your experience."))) {
//            onBoardingPage.parentPersona();
//            onBoardingPage.clickNext();
//        }
//        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("This will help us personalize your experience..."), 3)) {
//            onBoardingPage.childPersona();
//            onBoardingPage.clickDoneChildPersona();
//        }
//        String expected = "Guru";
//        changeProfilePage.enterChildName(expected);
//        parentDashboardPage.clickLater();
//        SplashMathLibrary.sleep(3000);
//        parentDashboardPage.playFirstLPCard();
//        parentDashboardPage.clickMenuBS();
//        parentDashboardPage.clickSettingsButton();
//        parentDashboardPage.agePasscode();
//        driver.findElement(MobileBy.AccessibilityId("SettingsCell33")).click();              //Online Sync
//        settingsPage.clickHomeSettings();
//        parentDashboardPage.clickMenuBS();
//        parentDashboardPage.clickChangeProfileBS();
//        Assert.assertEquals(changeProfilePage.getSelectedChildName(), expected, "Child is not added successfully");
//    }
//
//    @Test
//    public void changeFocusAreaDashboard() throws MalformedURLException {
//
//        Device device = DeviceFactory.getInstance().getDevice("ios");
//        deviceThreadLocal.set(device);
//        AppiumDriver<MobileElement> driver = device.getDriver();
//        AppiumLibrary appiumLibrary = new AppiumLibrary(driver);
//
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//        ContentGroupPage contentGroupPage = new ContentGroupPage(driver);
//        WorksheetPage worksheetPage = new WorksheetPage(driver);
//
//        onBoardingPage.clickAlreadyRegister();
//        onBoardingPage.clickHomeLogin();
//        loginPage.loginWith("va+elan3@splashlearn.com", "123456");
//        Assert.assertFalse(appiumLibrary.isElementPresent(MobileBy.xpath("//XCUIElementTypeAlert[@name=\"Error\"]"), 10), "Email ID/ Password incorrect.");
//        SplashMathLibrary.sleep(3000);
//        String expected = parentDashboardPage.getSecondContentGroupNameIpad();
//        parentDashboardPage.clickSecondContentGroup();
//        contentGroupPage.clickSetAsFocusArea();
//        contentGroupPage.agePasscode();
//        contentGroupPage.clickOk();
//        contentGroupPage.clickContentBackButton();
//        parentDashboardPage.clickNoThanks();
//        parentDashboardPage.playFirstLPCard();
//        parentDashboardPage.clickUpArrow();
//        Assert.assertEquals(parentDashboardPage.getFirstContentGroupName(), expected, "Focus area is not changed");
//    }
//
//    @Test
//    public void changeFocusAreaFromSettings() throws MalformedURLException {
//
//        Device device = DeviceFactory.getInstance().getDevice("ios");
//        deviceThreadLocal.set(device);
//        AppiumDriver<MobileElement> driver = device.getDriver();
//        AppiumLibrary appiumLibrary = new AppiumLibrary(driver);
//
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//
//        onBoardingPage.clickAlreadyRegister();
//        onBoardingPage.clickHome();
//        loginPage.loginWith("va+elan3@splashlearn.com", "123456");
//        Assert.assertFalse(appiumLibrary.isElementPresent(MobileBy.xpath("//XCUIElementTypeAlert[@name=\"Error\"]"), 10), "Email ID/ Password incorrect.");
//        String expected = parentDashboardPage.dashboardChildName();
//        parentDashboardPage.clickMenuBS();
//        parentDashboardPage.clickSettingsButton();
//        parentDashboardPage.agePasscode();
//        SplashMathLibrary.sleep(3000);
//        driver.findElementByAccessibilityId(expected).click();
//    }
//
//    @Test
//    public void gamesFromChildAchievement() throws InterruptedException, MalformedURLException {
//
//        Device device = DeviceFactory.getInstance().getDevice("ios");
//        deviceThreadLocal.set(device);
//        AppiumDriver<MobileElement> driver = device.getDriver();
//        AppiumLibrary appiumLibrary = new AppiumLibrary(driver);
//
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//
//        onBoardingPage.clickAlreadyRegister();
//        onBoardingPage.clickHomeLogin();
//        loginPage.loginWith("va+elan3@splashlearn.com", "123456");
//        Assert.assertFalse(appiumLibrary.isElementPresent(MobileBy.xpath("//XCUIElementTypeAlert[@name=\"Error\"]"), 10), "Email ID/ Password incorrect.");
//        parentDashboardPage.clickChildAchievement();
//        if (appiumLibrary.isElementPresent(MobileBy.xpath("(//XCUIElementTypeImage[@name=\"ChildAchievementDownloadFull\"])[1]"))) {
//            parentDashboardPage.clickPlayAquariumGame();
//        } else {
//            parentDashboardPage.clickPlayGame();
//        }
//        SplashMathLibrary.sleep(90000);
//        if (appiumLibrary.isElementPresent(MobileBy.xpath("(//XCUIElementTypeButton[@name=\"Button\"])[1]"))) {
//            parentDashboardPage.clickPlayGame();
//        }
//
//        SplashMathLibrary.sleep(90000);
//        appiumLibrary.tap(961, 121);
//        Assert.assertTrue(appiumLibrary.isElementPresent(MobileBy.xpath("(//XCUIElementTypeButton[@name=\"Button\"])[1]"), 10), "Game closing is failed.");
//    }
//
//    @Test
//    public void googleLogInFromFirstLandingPage() throws InterruptedException, MalformedURLException {
//
//        Device device = DeviceFactory.getInstance().getDevice("ios");
//        deviceThreadLocal.set(device);
//        AppiumDriver<MobileElement> driver = device.getDriver();
//        AppiumLibrary appiumLibrary = new AppiumLibrary(driver);
//
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//        WorksheetPage worksheetPage = new WorksheetPage(driver);
//
//        onBoardingPage.clickAlreadyRegister();
//        onBoardingPage.clickIAmParentTeacher();
//        loginPage.googleLoginIpad();
//        parentDashboardPage.playFirstLPCard();
//        parentDashboardPage.clickMenuBS();
//        parentDashboardPage.clickSettingsButton();
//        parentDashboardPage.agePasscode();
//        Assert.assertNotEquals(appiumLibrary.isElementPresent(MobileBy.AccessibilityId("Signed in as " + loginPage.googleEmailID.toLowerCase())), loginPage.googleEmailID, "Email Id is not matching");
//    }
//
//    @Test
//    public void googleLoginfromSignupPage() throws InterruptedException, MalformedURLException {
//
//        Device device = DeviceFactory.getInstance().getDevice("ios");
//        deviceThreadLocal.set(device);
//        AppiumDriver<MobileElement> driver = device.getDriver();
//        AppiumLibrary appiumLibrary = new AppiumLibrary(driver);
//
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//        WorksheetPage worksheetPage = new WorksheetPage(driver);
//
//        onBoardingPage.onBoardingFlowTillSignupPage();
//        loginPage.googleLoginIpad();
//        parentDashboardPage.playFirstLPCard();
//        parentDashboardPage.clickMenuBS();
//        parentDashboardPage.clickSettingsButton();
//        parentDashboardPage.agePasscode();
//        Assert.assertNotEquals(appiumLibrary.isElementPresent(MobileBy.AccessibilityId("Signed in as " + loginPage.googleEmailID.toLowerCase())), loginPage.googleEmailID, "Email Id is not matching");
//    }
//
//    @Test
//    public void googleLoginFronFifthLandingPage() throws InterruptedException, MalformedURLException {
//
//        Device device = DeviceFactory.getInstance().getDevice("ios");
//        deviceThreadLocal.set(device);
//        AppiumDriver<MobileElement> driver = device.getDriver();
//        AppiumLibrary appiumLibrary = new AppiumLibrary(driver);
//
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//        WorksheetPage worksheetPage = new WorksheetPage(driver);
//        SettingsPage settingsPage = new SettingsPage(driver);
//
//        onBoardingPage.clickAlreadyRegister();
//        onBoardingPage.clickHomeLogin();
//        loginPage.loginWith("va+elan2@splashlearn.com", "123456");
//        Assert.assertFalse(appiumLibrary.isElementPresent(MobileBy.xpath("//XCUIElementTypeAlert[@name=\"Error\"]"), 10), "Email Id/Password is incorrect.");
//        parentDashboardPage.clickMenuBS();
//        parentDashboardPage.clickSettingsButton();
//        parentDashboardPage.agePasscode();
//        settingsPage.clickSignOut();
//        settingsPage.clickSignOutA();
//        loginPage.clickLogin();
//        onBoardingPage.clickIAmParentTeacher();
//        loginPage.googleLoginIpad();
//        SplashMathLibrary.sleep(10000);
//        parentDashboardPage.playFirstLPCard();
//        parentDashboardPage.clickMenuBS();
//        parentDashboardPage.clickSettingsButton();
//        parentDashboardPage.agePasscode();
//        Assert.assertNotEquals(appiumLibrary.isElementPresent(MobileBy.AccessibilityId("Signed in as " + loginPage.googleEmailID.toLowerCase())), loginPage.googleEmailID, "Email Id is not matching");
//    }
//
//    @Test
//    public void mathGames() throws InterruptedException, MalformedURLException {
//
//        Device device = DeviceFactory.getInstance().getDevice("ios");
//        deviceThreadLocal.set(device);
//        AppiumDriver<MobileElement> driver = device.getDriver();
//        AppiumLibrary appiumLibrary = new AppiumLibrary(driver);
//
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//        ContentGroupPage contentGroupPage = new ContentGroupPage(driver);
//        WorksheetPage worksheetPage = new WorksheetPage(driver);
//        MathGamesPage mathGamesPage = new MathGamesPage(driver);
//
//        onBoardingPage.clickAlreadyRegister();
//        onBoardingPage.clickHomeLogin();
//        loginPage.loginWith("va+elan3@splashlearn.com", "123456");
//        Assert.assertFalse(appiumLibrary.isElementPresent(MobileBy.xpath("//XCUIElementTypeAlert[@name=\"Error\"]"), 10), "Email ID/ Password incorrect.");
//        parentDashboardPage.clickMathGamesButton();
//
//        mathGamesPage.checkGamePlay("Stranded");
//        mathGamesPage.checkGamePlay("Make Way");
//        mathGamesPage.checkGamePlay("Sky Lands");
//
//    }

}
