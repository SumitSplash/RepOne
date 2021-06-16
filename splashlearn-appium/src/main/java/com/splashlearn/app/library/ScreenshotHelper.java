package com.splashlearn.app.library;

import com.splashlearn.app.util.SplashMathConstants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;

public class ScreenshotHelper  {

    private static final Logger logger = LogManager.getRootLogger();

    public static String captureScreenshot(AppiumDriver<MobileElement> driver, String testName) {
        File screenshot = driver.getScreenshotAs(OutputType.FILE);
        String screenshotName = testName.replace(" ", "_") + "_" + SplashMathLibrary.now() + ".png";
        String newFile = SplashMathConstants.SCREENSHOT_PATH  + "/" + screenshotName;
        try {
            FileUtils.copyFile(screenshot, new File(newFile));
        } catch (IOException e) {
            logger.error(String.format("Unable to capture screenshot for test %s. Got error : %s", testName, e.getMessage()));
        }
        return newFile;
    }

    public static String captureScreenshotAsBase64(AppiumDriver<MobileElement> driver) {
        return "data:image/png;base64," + driver.getScreenshotAs(OutputType.BASE64);
    }

}
