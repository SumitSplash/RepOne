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
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//public class ParentControlTest extends Hooks {
//
//
//    @Test
//    public void switchChild() throws InterruptedException {
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//        ChangeProfilePage changeProfilePage = new ChangeProfilePage(driver);
//
//        onBoardingPage.clickAlreadyRegister();
//        loginPage.loginWith("va+ela101@splashmath.com", "123456");
//        SplashMathLibrary.sleep(7000);
//        if (new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("SPCurriculumNavMenu"))) {
//            parentDashboardPage.clickMenuBS();
//            parentDashboardPage.clickChangeProfileBS();
//            List<String> childNames = changeProfilePage.getChildName();
//            changeProfilePage.getChildCount();
//            String expected = childNames.get(1);
//            changeProfilePage.switchToChild(expected);
//            parentDashboardPage.clickMenuBS();
//            parentDashboardPage.clickChangeProfileBS();
//            Assert.assertEquals(changeProfilePage.getSelectedChildName(), expected, "Unable to switch child successfully.");
//
//        } else {
//            parentDashboardPage.clickEnableNotification();
//            parentDashboardPage.clickAllow();
//            parentDashboardPage.clickSettingButton();
//            changeProfilePage.clickChangeProfile();
//            List<String> childNames = changeProfilePage.getChildName();
//            changeProfilePage.getChildCount();
//            String expected = childNames.get(1);
//            changeProfilePage.switchToChild(expected);
//            parentDashboardPage.clickCrossGoal();
//            parentDashboardPage.clickLater();
//            parentDashboardPage.clickSettingButton();
//            changeProfilePage.clickChangeProfile();
//            Assert.assertEquals(changeProfilePage.getSelectedChildName(), expected, "Unable to switch child successfully.");
//        }
//    }
//
////
//    @Test
//   public void switchGrade() throws InterruptedException {
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//        ChangeProfilePage changeProfilePage = new ChangeProfilePage(driver);
//
//        onBoardingPage.clickAlreadyRegister();
//        loginPage.loginWith("va+staging@splashmath.com", "123456");
//        parentDashboardPage.clickEnableNotification();
//        parentDashboardPage.clickAllow();
//        SplashMathLibrary.sleep(5000);
//        List<String> grades = new ArrayList<>();
//        grades.add("Math Facts");
//        grades.add("Kindergarten");
//        grades.add("Grade 1");
//        grades.add("Grade 2");
//        grades.add("Grade 3");
//        grades.add("Grade 4");
//        grades.add("Grade 5");
//        Random rand = new Random();
//        String grade = grades.get(rand.nextInt(grades.size()));
//        String expected = grade;
//        changeProfilePage.selectGrade();
////        Assert.assertNotEquals(new AppiumLibrary(driver).isSelected(MobileBy.AccessibilityId(expected)), expected, "Switch Grade is not matched");
//    }
////
//    @Test
//    public void addChild() throws InterruptedException {
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//        ChangeProfilePage changeProfilePage = new ChangeProfilePage(driver);
//        SettingsPage settingsPage = new SettingsPage(driver);
//
//        onBoardingPage.clickAlreadyRegister();
//        loginPage.loginWith("va+staging@splashmath.com", "123456");
//        parentDashboardPage.clickEnableNotification();
//        parentDashboardPage.clickAllow();
//        parentDashboardPage.clickSettingButton();
//        changeProfilePage.clickChangeProfile();
//        Assert.assertNotEquals(changeProfilePage.getChildName().size(), 3, "Already 3 child exist");
//        changeProfilePage.isChildPresent();
//        String expected = "vasy";
//        changeProfilePage.enterChildName(expected);
//        changeProfilePage.clickBoy();
//        List<String> grades = new ArrayList<>();
//        grades.add("K");
//        grades.add("1");
//        grades.add("2");
//        grades.add("3");
//        grades.add("4");
//        grades.add("5");
//        Random rand = new Random();
//        String grade = grades.get(rand.nextInt(grades.size()));
//        onBoardingPage.selectGrade(grade);
//        parentDashboardPage.clickSetGoal();
//        parentDashboardPage.clickSaveGoal();
//        parentDashboardPage.clickLater();
//        parentDashboardPage.clickSettingButton();
//        changeProfilePage.clickChangeProfile();
//        parentDashboardPage.clickSettings();
//        parentDashboardPage.agePasscode();
//        settingsPage.clickOnlineSync();
//        Assert.assertNotEquals(changeProfilePage.getSelectedChildName(), expected, "Child is not added successfully");
//    }
//
//
//    @Test
//    public void editChildDetails() {
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//        SettingsPage settingPage = new SettingsPage(driver);
//        onBoardingPage.clickAlreadyRegister();
//        loginPage.loginWith("va+staging@splashmath.com", "123456");
//        parentDashboardPage.clickNoThanks();
//        parentDashboardPage.clickSettingButton();
//        parentDashboardPage.clickSettings();
//        parentDashboardPage.passPaternalGate();
//        settingPage.clickChildOne();
//        settingPage.editChildName("true");
//        settingPage.clickBackButton();
//    }
//
//    @Test
//    public void loginAfterLogout() {
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//        SettingsPage settingPage = new SettingsPage(driver);
//        BasePage basePage = new BasePage(driver);
//
//        onBoardingPage.clickAlreadyRegister();
//        loginPage.loginWith("va+staging@splashmath.com", "123456");
//        parentDashboardPage.clickEnableNotification();
//        parentDashboardPage.clickAllow();
//        parentDashboardPage.clickSettingButton();
//        parentDashboardPage.clickSettings();
//        parentDashboardPage.passPaternalGate();
//        settingPage.clickSignOut();
//        settingPage.clickSignOutA();
//        loginPage.clickLogin();
//        String expected = "va+ela101@splashmath.com";
//        loginPage.loginWith(expected, "123456");
//        parentDashboardPage.clickMenuBS();
//        parentDashboardPage.clickSettingsButton();
//        basePage.agePasscode();
//        SplashMathLibrary.sleep(3000);
//        Assert.assertNotEquals(new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("Signed in as " + expected.toLowerCase())), expected, "Email Id is not matching");
//    }
//
//    @Test
//    public void loginFromWelcomeBack() throws InterruptedException {
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        BasePage basePage = new BasePage(driver);
//        ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);
//        onBoardingPage.clickGetStarted();
//        onBoardingPage.clickGrade1();
//        onBoardingPage.clickTopic1();
//        onBoardingPage.clickDone();
//        onBoardingPage.clickViewAllPlans();
//        onBoardingPage.clickCrossBuyBS();
//        String expected = "va+ela101@splashmath.com";
//        onBoardingPage.emailField(expected);
//        onBoardingPage.clickContinue();
//        basePage.agePasscode();
//        onBoardingPage.passwordLogin("123456");
//        basePage.clickLoginButton();
//        parentDashboardPage.clickMenuBS();
//        parentDashboardPage.clickSettingsButton();
//        basePage.agePasscode();
//        SplashMathLibrary.sleep(3000);
//        Assert.assertNotEquals(new AppiumLibrary(driver).isElementPresent(MobileBy.AccessibilityId("Signed in as " + expected.toLowerCase())), expected, "Email id is not matching");
//    }
//
//}