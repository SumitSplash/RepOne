package com.splashlearn.app.screens.ios;

import com.splashlearn.app.library.AppiumLibrary;
import com.splashlearn.app.library.SplashMathLibrary;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

import java.util.Set;

public class LoginPage extends BasePage {

    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @iOSXCUITFindBy(accessibility = "emailFieldLogin")
    private MobileElement email;

    @iOSXCUITFindBy(accessibility = "passworcleadLogin")
    private MobileElement password;

    @iOSXCUITFindBy(accessibility = "doneButtonLogin")
    private MobileElement done;

    @iOSXCUITFindBy(accessibility = "Login")
    private MobileElement login;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"SplashLearn\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeSegmentedControl/XCUIElementTypeButton[2]")
    private MobileElement teacherToggle;

    @iOSXCUITFindBy(accessibility = "SPLoginTypeSelectionHomeButton")
    private MobileElement homeLogin;

    @iOSXCUITFindBy(accessibility = "google")
    private MobileElement googleLogin;

    @iOSXCUITFindBy(accessibility = "facebook")
    private MobileElement facebookLogin;

    @iOSXCUITFindBy(accessibility = "Email or phone")
    private MobileElement googleEmail;

    @iOSXCUITFindBy(accessibility = "Enter your password")
    private MobileElement googlePassword;

    @iOSXCUITFindBy(accessibility = "Continue")
    private MobileElement continueGoogle;

    @iOSXCUITFindBy(accessibility = "GoogleLoginButton")
    private MobileElement googleLoginSignUpPage;


    public void clickDone() {
        appiumLibrary.click(done);
    }

    public void clickLogin() {
        appiumLibrary.waitForElement(login);
        appiumLibrary.click(login);
    }

    public void clickTeacherToggle() {
        appiumLibrary.click(teacherToggle);
    }

    public String loginWith(String email, String password) {
        System.out.println(email);
        appiumLibrary.enterText(this.email, email);
        appiumLibrary.enterText(this.password, password);
        appiumLibrary.click(done);
        return email;
    }

    public String loginfromMenu(String email, String password) {
        System.out.println(email);
        appiumLibrary.enterText(this.email, email);
        appiumLibrary.enterText(this.password, password);
        appiumLibrary.click(login);
        return email;
    }


    public void teacherLogin(String email, String password) {
        appiumLibrary.enterText(this.email, email);
        appiumLibrary.enterText(this.password, password);
        appiumLibrary.click(login);
    }

    public void clickHomeLogin() {
        appiumLibrary.click(homeLogin);
    }

    public void clickGoogleLogin() {
        appiumLibrary.click(googleLogin);
    }

    public void clickGoogleSignUpPage() {
        appiumLibrary.click(googleLoginSignUpPage);
    }

    public void clickfacebookLogin() {
        appiumLibrary.click(facebookLogin);
    }

    public void googleEmailField(String email) {
        appiumLibrary.enterText(this.googleEmail, email);
    }

    public void googlePasswordField(String password) {
        appiumLibrary.enterText(this.googlePassword, password);
    }

    public void clickContinueGoogle() {
        appiumLibrary.click(continueGoogle);
    }

    public void clickGoogleButton() {
        int i = 0;
        while (++i < 5)
            if (appiumLibrary.isElementPresent(googleLogin, 1)) {
                clickGoogleLogin();
                return;
            } else if (appiumLibrary.isElementPresent(googleLoginSignUpPage, 1)) {
                clickGoogleSignUpPage();
                return;
            }
        Assert.fail("Unable to find Google button");
    }

    public String googleEmailID;

    public void googleLoginIpad() throws InterruptedException {
        clickGoogleButton();
        agePasscode();
        clickContinueGoogle();
        SplashMathLibrary.sleep(10000);
        Set<String> contextHandles = driver.getContextHandles();
        for (String s : contextHandles) {
            System.out.println("Context:" + s);
            if (s.contains("WEBVIEW")) {
                driver.context(contextHandles.toArray()[1].toString());
            }
        }
        SplashMathLibrary.sleep(5000);
        googleEmailID = "vaibhav.splashlearn1@gmail.com";
        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("Email or phone"), 2)) {
            SplashMathLibrary.sleep(1000);
            googleEmailField(googleEmailID);
            if (driver.getCapabilities().getCapability("deviceType").toString().equalsIgnoreCase("iPhone")) {
                driver.hideKeyboard();
                googlePasswordField("splashlearn1234");
                driver.hideKeyboard();
            } else {
                appiumLibrary.tap(694, 508);
                googlePasswordField("splashlearn1234");
                appiumLibrary.tap(694, 508);
            }
        } else {
            if (driver.getCapabilities().getCapability("deviceType").toString().equalsIgnoreCase("iPhone")) {
                appiumLibrary.tap(80, 290);
            } else {
                appiumLibrary.tap(380, 330);
            }
        }
        driver.context("NATIVE_APP");

    }

    public void googleLoginIphone() throws InterruptedException {
        clickGoogleButton();
        agePasscode();
        clickContinueGoogle();
        SplashMathLibrary.sleep(10000);
        Set<String> contextHandles = driver.getContextHandles();
        for (String s : contextHandles) {
            System.out.println("Context:" + s);
            if (s.contains("WEBVIEW")) {
                driver.context(contextHandles.toArray()[1].toString());
            }
        }
        SplashMathLibrary.sleep(5000);
        googleEmailID = "vaibhav.splashlearn1@gmail.com";
        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("Email or phone"), 2)) {
            SplashMathLibrary.sleep(1000);
            googleEmailField(googleEmailID);
            driver.hideKeyboard();
            googlePasswordField("splashlearn1234");
            driver.hideKeyboard();
        } else {
            appiumLibrary.tap(80, 290);
        }
        driver.context("NATIVE_APP");

    }


}
