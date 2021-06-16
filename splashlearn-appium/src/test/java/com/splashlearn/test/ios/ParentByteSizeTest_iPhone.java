//package com.splashlearn.test.ios;
//
//import com.splashlearn.app.library.AppiumLibrary;
//import com.splashlearn.app.library.SplashMathLibrary;
//import com.splashlearn.app.screens.ios.*;
//import com.splashlearn.test.Hooks;
//import io.appium.java_client.MobileBy;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//public class ParentByteSizeTest_iPhone extends Hooks {
//
//    @Test
//    public void onboarding() throws InterruptedException {
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//        WorksheetPage worksheetPage = new WorksheetPage(driver);
//
////        onBoardingPage.clickGetStarted();
////        if (new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("Please accept Terms of Use to continue using SplashLearn."),2)) {
////            onBoardingPage.clickTermsOFUse();
////            onBoardingPage.clickOkButton();
////        }
////        if (new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("Home"),2)) {
////            onBoardingPage.clickHome();
////        }
////        if (new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("What grade is your child in?"),2)) {
////            onBoardingPage.selectGrade();
////            if (new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("This will help us personalize your experience."),2)) {
////                onBoardingPage.clickParentPersona();
////                onBoardingPage.clickNext();
////            }
////            if (new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("How does your child feel about math?"), 3)) {
////                onBoardingPage.childPersona();
////                onBoardingPage.clickDoneChildPersona();
////            }
////            onBoardingPage.clickChooseForMe();
////            onBoardingPage.clickViewAllPlans();
////            onBoardingPage.clickCrossBuyBS();
////            onBoardingPage.clickSignupCrossButton();
////            SplashMathLibrary.sleep(10000);
////            parentDashboardPage.getplayableName();
////            parentDashboardPage.playFirstLPCard();
////            Assert.assertTrue(new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("SPCurriculumNavMenu")), "Bytesize 3.0/ELA flow onboarding is unsuccessful");
////        } else if (new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("NameFieldAddChild"))) {
////            onBoardingPage.enterChildNameCF("Raj");
////            onBoardingPage.selectGender();
////            onBoardingPage.selectGradeCF();
////            onBoardingPage.clickSignupCrossButton();
////            onBoardingPage.clickViewAllPlans();
////            onBoardingPage.clickPurchaseCross();
////            parentDashboardPage.clickBalloonOne();
////            parentDashboardPage.clickStartContentCF();
////            if (new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("Downloading sounds for the game..."), 5)) {
////                worksheetPage.clickPlayAnyway();
////            }
////            Assert.assertTrue(new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("QPPause"), 90), "Content is unable to load");
////            worksheetPage.clickPause();
////            worksheetPage.clickHome();
////            Assert.assertTrue(new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("BalloonCell0")), "Control flow onboarding is unsuccessful");
////        }
////    }
//
//        onBoardingPage.onBoardingFlow();
//        if (new AppiumLibrary(driver).isElementPresent(parentDashboardPage.menuBS)) {
//            parentDashboardPage.playFirstLPCard();
//            Assert.assertTrue(new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("SPCurriculumNavMenu")), "Bytesize 3.0/ELA flow onboarding is unsuccessful");
//        } else if (new AppiumLibrary(driver).isElementPresent(parentDashboardPage.settingButton)) {
//            parentDashboardPage.clickBalloonOne();
//            parentDashboardPage.clickStartContentCF();
//            if (new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("Downloading sounds for the game..."), 5)) {
//                worksheetPage.clickPlayAnyway();
//            }
//            Assert.assertTrue(new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("QPPause"), 90), "Content is unable to load");
//            worksheetPage.clickPause();
//            worksheetPage.clickHome();
//            Assert.assertTrue(new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("BalloonCell0")), "Control flow onboarding is unsuccessful");
//        } else if (new AppiumLibrary(driver).isElementPresent(parentDashboardPage.byteSize2PLayButton)) {
//            parentDashboardPage.clickByteSize2PlayButton();
//        }
//    }
//
//    @Test
//    public void loginFromMenu() {
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//        BasePage basePage = new BasePage(driver);
//        WorksheetPage worksheetPage = new WorksheetPage(driver);
//
//        onBoardingPage.clickGetStarted();
//        if (new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("Please accept Terms of Use to continue using SplashLearn."))) {
//            onBoardingPage.clickTermsOFUse();
//            onBoardingPage.clickOkButton();
//        }
//        if (new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("What grade is your child in?"))) {
//            onBoardingPage.clickGrade3();
//            if (new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("How does your child feel about math?"), 3)) {
//                onBoardingPage.childPersona();
//                onBoardingPage.clickDoneChildPersona();
//            }
//            onBoardingPage.clickChooseForMe();
//            onBoardingPage.clickViewAllPlans();
//            onBoardingPage.clickCrossBuyBS();
//            onBoardingPage.clickSignupCrossButton();
//            parentDashboardPage.clickMenuBS();
//            parentDashboardPage.clickLoginButton();
//            String expected = "va+ela101@splashmath.com";
//            loginPage.loginWith(expected, "123456");
//            Assert.assertFalse(new AppiumLibrary(driver).isElementPresent(MobileBy.xpath("//XCUIElementTypeAlert[@name=\"Error\"]"), 10), "Email ID/ Password incorrect.");
//            parentDashboardPage.playFirstLPCard();
//            parentDashboardPage.clickMenuBS();
//            parentDashboardPage.clickSettingsButton();
//            basePage.agePasscode();
//            Assert.assertNotEquals(new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("Signed in as " + expected.toLowerCase())), expected, "Email id is not matched.");
//        } else if (new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("NameFieldAddChild"))) {
//            if (new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("Please accept Terms of Use to continue using SplashLearn."))) {
//                onBoardingPage.clickTermsOFUse();
//                onBoardingPage.clickOkButton();
//            }
//            onBoardingPage.enterChildNameCF("Raj");
//            onBoardingPage.selectGender();
//            onBoardingPage.selectGradeCF();
//            onBoardingPage.clickSignupCrossButton();
//            parentDashboardPage.clickSettingButton();
//            driver.findElement(MobileBy.AccessibilityId("Login")).click();
//            String expected = "va+ela101@splashmath.com";
//            loginPage.loginWith(expected, "123456");
//            Assert.assertFalse(new AppiumLibrary(driver).isElementPresent(MobileBy.xpath("//XCUIElementTypeAlert[@name=\"Error\"]"), 10), "Email ID/ Password incorrect.");
//            parentDashboardPage.playFirstLPCard();
//            parentDashboardPage.clickMenuBS();
//            parentDashboardPage.clickSettingsButton();
//            basePage.agePasscode();
//            Assert.assertNotEquals(new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("Signed in as " + expected.toLowerCase())), expected, "Email id is not matched.");
//        }
//    }
//
//    @Test
//    public void loginFromFirstLandingPage() {
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//        WorksheetPage worksheetPage = new WorksheetPage(driver);
//
//        onBoardingPage.clickAlreadyRegister();
//        String expected = "va+elan2@splashlearn.com";
//        loginPage.loginWith(expected, "123456");
//        Assert.assertFalse(new AppiumLibrary(driver).isElementPresent(MobileBy.xpath("//XCUIElementTypeAlert[@name=\"Error\"]"), 10), "Email Id/Password is incorrect.");
//        if (new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("Enable Notifications"))) {
//            parentDashboardPage.clickEnableNotification();
//            parentDashboardPage.clickAllow();
//        }
//        parentDashboardPage.playFirstLPCard();
//        parentDashboardPage.clickMenuBS();
//        parentDashboardPage.clickSettingsButton();
//        parentDashboardPage.passPaternalGate();
//        Assert.assertNotEquals(new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("Signed in as " + expected.toLowerCase())), expected, "Email Id is not matching");
//    }
//
//    @Test
//    public void loginFromWelcomeBack() throws InterruptedException {
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        BasePage basePage = new BasePage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//        WorksheetPage worksheetPage = new WorksheetPage(driver);
//
//        onBoardingPage.clickGetStarted();
//        if (new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("Please accept Terms of Use to continue using SplashLearn."))) {
//            onBoardingPage.clickTermsOFUse();
//            onBoardingPage.clickOkButton();
//
//            onBoardingPage.selectGrade();
//            if (new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("How does your child feel about math?"), 3)) {
//                onBoardingPage.childPersona();
//                onBoardingPage.clickDoneChildPersona();
//            }
//            onBoardingPage.clickChooseForMe();
//            onBoardingPage.clickViewAllPlans();
//            onBoardingPage.clickCrossBuyBS();
//            String expected = "va+elan3@splashlearn.com";
//            onBoardingPage.emailField(expected);
//            onBoardingPage.clickContinue();
//            basePage.agePasscode();
//            onBoardingPage.passwordLogin("123456");
//            driver.hideKeyboard();
//            SplashMathLibrary.sleep(3000);
//            parentDashboardPage.playFirstLPCard();
//            parentDashboardPage.clickMenuBS();
//            parentDashboardPage.clickSettingsButton();
//            basePage.agePasscode();
//            Assert.assertNotEquals(new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("Signed in as " + expected.toLowerCase())), expected, "Email id is not matching");
//        } else if (new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("NameFieldAddChild"))) {
//            if (new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("Please accept Terms of Use to continue using SplashLearn."))) {
//                onBoardingPage.clickTermsOFUse();
//                onBoardingPage.clickOkButton();
//            }
//            onBoardingPage.enterChildNameCF("Raj");
//            onBoardingPage.selectGender();
//            onBoardingPage.selectGradeCF();
//            String expected = "va+elan3@splashlearn.com";
//            onBoardingPage.emailField(expected);
//            onBoardingPage.clickDone();
//            onBoardingPage.agePasscode();
//            onBoardingPage.enterPasswordWB("123456");
//            parentDashboardPage.playFirstLPCard();
//            parentDashboardPage.clickMenuBS();
//            parentDashboardPage.clickSettingsButton();
//            basePage.agePasscode();
//            Assert.assertNotEquals(new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("Signed in as " + expected.toLowerCase())), expected, "Email id is not matching");
//        }
//    }
//
//    @Test
//    public void loginFromFifthLandingPage() {
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//        SettingsPage settingPage = new SettingsPage(driver);
//        BasePage basePage = new BasePage(driver);
//        WorksheetPage worksheetPage = new WorksheetPage(driver);
//
//        onBoardingPage.clickAlreadyRegister();
//        loginPage.loginWith("va+elan2@splashmath.com", "123456");
//        Assert.assertFalse(new AppiumLibrary(driver).isElementPresent(MobileBy.xpath("//XCUIElementTypeAlert[@name=\"Error\"]"), 10), "Email ID/ Password incorrect.");
//        if (new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("Enable Notifications"))) {
//            parentDashboardPage.clickEnableNotification();
//            parentDashboardPage.clickAllow();
//        }
//        if (new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("SPCurriculumNavMenu"))) {
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
//        String expected = "va+ela101@splashmath.com";
//        loginPage.loginWith(expected, "123456");
//        Assert.assertFalse(new AppiumLibrary(driver).isElementPresent(MobileBy.xpath("//XCUIElementTypeAlert[@name=\"Error\"]"), 10), "Email ID/ Password incorrect.");
//        if (new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("Enable Notifications"))) {
//            parentDashboardPage.clickEnableNotification();
//            parentDashboardPage.clickAllow();
//        }
//        parentDashboardPage.playFirstLPCard();
//        if (new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("SPCurriculumNavMenu"))) {
//            parentDashboardPage.clickMenuBS();
//            parentDashboardPage.clickSettingsButton();
//        } else {
//            parentDashboardPage.clickSettingButton();
//            parentDashboardPage.clickSettings();
//        }
//        basePage.agePasscode();
//        SplashMathLibrary.sleep(3000);
//        Assert.assertNotEquals(new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("Signed in as " + expected.toLowerCase())), expected, "Email Id is not matching");
//    }
//
//    @Test
//    public void switchChild() throws InterruptedException {
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//        ChangeProfilePage changeProfilePage = new ChangeProfilePage(driver);
//        WorksheetPage worksheetPage = new WorksheetPage(driver);
//
//        onBoardingPage.clickAlreadyRegister();
//        loginPage.loginWith("va+ela101@splashmath.com", "123456");
//        Assert.assertFalse(new AppiumLibrary(driver).isElementPresent(MobileBy.xpath("//XCUIElementTypeAlert[@name=\"Error\"]"), 10), "Email ID/ Password incorrect.");
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
//    public void addChild() {
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//        ChangeProfilePage changeProfilePage = new ChangeProfilePage(driver);
//        WorksheetPage worksheetPage = new WorksheetPage(driver);
//        SettingsPage settingsPage = new SettingsPage(driver);
//
//        onBoardingPage.clickAlreadyRegister();
//        loginPage.loginWith("va+elan4@splashlearn.com", "123456");
//        Assert.assertFalse(new AppiumLibrary(driver).isElementPresent(MobileBy.xpath("//XCUIElementTypeAlert[@name=\"Error\"]"), 10), "Email ID/ Password incorrect.");
//        parentDashboardPage.clickMenuBS();
//        parentDashboardPage.clickChangeProfileBS();
//        Assert.assertNotEquals(changeProfilePage.getChildName().size(), 3, "Already 3 child exist");
//        changeProfilePage.isChildPresent();
//        Assert.assertFalse(new AppiumLibrary(driver).isElementPresent(MobileBy.xpath("//XCUIElementTypeButton[@name=\"Subscribe\"]")), "User is not subscribed, So Add child flow is terminated.");
//        if (new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("What grade is your child in?"), 1)) {
//            changeProfilePage.selectGrade();
//            if (new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("Avoid it"), 3)) {
//                changeProfilePage.childPersona();
//                onBoardingPage.clickChooseForMe();
//            }
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
//    public void changeFocusAreaDashboard() {
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//        ContentGroupPage contentGroupPage = new ContentGroupPage(driver);
//        WorksheetPage worksheetPage = new WorksheetPage(driver);
//
//        onBoardingPage.clickAlreadyRegister();
//        loginPage.loginWith("va+elan3@splashlearn.com", "123456");
//        Assert.assertFalse(new AppiumLibrary(driver).isElementPresent(MobileBy.xpath("//XCUIElementTypeAlert[@name=\"Error\"]"), 10), "Email ID/ Password incorrect.");
//        parentDashboardPage.clickUpArrow();
//        String expected = parentDashboardPage.getSecondContentGroupName();
//        parentDashboardPage.clickSecondContentGroup();
//        contentGroupPage.getPlayableNames();
//        contentGroupPage.clickSetAsFocusArea();
//        contentGroupPage.agePasscode();
//        contentGroupPage.clickOk();
//        contentGroupPage.clickContentBackButton();
//        parentDashboardPage.clickNoThanks();
//        parentDashboardPage.clickUpArrow();
//        parentDashboardPage.playFirstLPCard();
//        parentDashboardPage.clickUpArrow();
//        Assert.assertEquals(parentDashboardPage.getFirstContentGroupNameIphone(), expected, "Focus area is not changed");
//    }
//
//    @Test
//    public void changeFocusAreaFromSettings() {
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//
//        onBoardingPage.clickAlreadyRegister();
//        loginPage.loginWith("va+elan3@splashlearn.com", "123456");
//        Assert.assertFalse(new AppiumLibrary(driver).isElementPresent(MobileBy.xpath("//XCUIElementTypeAlert[@name=\"Error\"]"), 10), "Email ID/ Password incorrect.");
//        String expected = parentDashboardPage.dashboardChildName();
//        parentDashboardPage.clickMenuBS();
//        parentDashboardPage.clickSettingsButton();
//        parentDashboardPage.agePasscode();
//        SplashMathLibrary.sleep(3000);
//        driver.findElementByAccessibilityId(expected).click();
//    }
//
//    @Test
//    public void gamesFromChildAchievement() throws InterruptedException {
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//
//        onBoardingPage.clickAlreadyRegister();
//        onBoardingPage.clickHomeLogin();
//        loginPage.loginWith("va+elan3@splashlearn.com", "123456");
//        Assert.assertFalse(new AppiumLibrary(driver).isElementPresent(MobileBy.xpath("//XCUIElementTypeAlert[@name=\"Error\"]"), 10), "Email ID/ Password incorrect.");
//        parentDashboardPage.clickChildAchievement();
//        if (new AppiumLibrary(driver).isElementPresent(MobileBy.xpath("(//XCUIElementTypeImage[@name=\"ChildAchievementDownloadFull\"])[1]"))) {
//            parentDashboardPage.clickPlayAquariumGame();
//        }
//        SplashMathLibrary.sleep(90000);
//        if (new AppiumLibrary(driver).isElementPresent(MobileBy.xpath("(//XCUIElementTypeButton[@name=\"Button\"])[1]"))) {
//            parentDashboardPage.clickPlayAquariumGame();
//        }
//        new AppiumLibrary(driver).tap(548, 41);
//    }
//
//
//    @Test
//    public void googleLogInFromFirstLandingPage() throws InterruptedException {
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//        WorksheetPage worksheetPage = new WorksheetPage(driver);
//
//        onBoardingPage.clickAlreadyRegister();
//        loginPage.googleLoginIphone();
//        SplashMathLibrary.sleep(10000);
//        parentDashboardPage.playFirstLPCard();
//        parentDashboardPage.clickMenuBS();
//        parentDashboardPage.clickSettingsButton();
//        parentDashboardPage.agePasscode();
//        Assert.assertNotEquals(new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("Signed in as " + loginPage.googleEmailID.toLowerCase())), loginPage.googleEmailID, "Email id is not matching");
//
//    }
//
//    @Test
//    public void googleLoginfromSignupPage() throws InterruptedException {
//
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//        WorksheetPage worksheetPage = new WorksheetPage(driver);
//        SettingsPage settingsPage = new SettingsPage(driver);
//
//        onBoardingPage.onBoardingFlow();
//        loginPage.googleLoginIphone();
////        parentDashboardPage.playFirstLPCard();
//        parentDashboardPage.clickMenuBS();
//        parentDashboardPage.clickSettingsButton();
//        parentDashboardPage.agePasscode();
//        Assert.assertNotEquals(new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("Signed in as " + loginPage.googleEmailID.toLowerCase())), loginPage.googleEmailID, "Email id is not matching");
//    }
//
//
//    @Test
//    public void googleLoginFronFifthLandingPage() throws InterruptedException {
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//        WorksheetPage worksheetPage = new WorksheetPage(driver);
//        SettingsPage settingsPage = new SettingsPage(driver);
//
//        onBoardingPage.clickAlreadyRegister();
//
//        loginPage.loginWith("va+elan2@splashlearn.com", "123456");
//        Assert.assertFalse(new AppiumLibrary(driver).isElementPresent(MobileBy.xpath("//XCUIElementTypeAlert[@name=\"Error\"]"), 10), "Email Id/Password is incorrect.");
//        parentDashboardPage.clickMenuBS();
//        parentDashboardPage.clickSettingsButton();
//        parentDashboardPage.agePasscode();
//        settingsPage.clickSignOut();
//        settingsPage.clickSignOutA();
//        loginPage.clickLogin();
//        loginPage.googleLoginIphone();
//        SplashMathLibrary.sleep(10000);
////        parentDashboardPage.playFirstLPCard();
//        parentDashboardPage.clickMenuBS();
//        parentDashboardPage.clickSettingsButton();
//        parentDashboardPage.agePasscode();
//        Assert.assertNotEquals(new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("Signed in as " + loginPage.googleEmailID.toLowerCase())), loginPage.googleEmailID, "Email id is not matching");
//    }
//
//    @Test
//    public void mathGames() throws InterruptedException {
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//        ContentGroupPage contentGroupPage = new ContentGroupPage(driver);
//        WorksheetPage worksheetPage = new WorksheetPage(driver);
//        MathGamesPage mathGamesPage = new MathGamesPage(driver);
//
//        onBoardingPage.clickAlreadyRegister();
//        loginPage.loginWith("va+elan3@splashlearn.com", "123456");
//        Assert.assertFalse(new AppiumLibrary(driver).isElementPresent(MobileBy.xpath("//XCUIElementTypeAlert[@name=\"Error\"]"), 10), "Email ID/ Password incorrect.");
//        parentDashboardPage.clickUpArrow();
//        parentDashboardPage.clickMathGamesButton();
//        mathGamesPage.checkGamePlay("Stranded");
//        mathGamesPage.checkGamePlay("Make Way");
//        mathGamesPage.checkGamePlay("Sky Lands");
//
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
