//package com.splashlearn.test.ios;
//
//import com.splashlearn.app.library.ScreenshotHelper;
//import com.splashlearn.app.screens.ios.OnBoardingPage;
//import com.splashlearn.test.Hooks;
//import com.splashlearn.app.library.DeviceFactory;
//
//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileElement;
//import org.testng.annotations.Test;
//
//public class OnBoardingTest extends Hooks {
//
//    @Test
//    public void onBoarding() {
//
//        AppiumDriver<MobileElement> driver = DeviceFactory.getInstance().getDriver();
//        OnBoardingPage onBoardingPage = new OnBoardingPage(driver);
//        onBoardingPage.clickGetStarted();
//
//        ScreenshotHelper.captureScreenshot(testName.get());
//
//    }
//
//}
