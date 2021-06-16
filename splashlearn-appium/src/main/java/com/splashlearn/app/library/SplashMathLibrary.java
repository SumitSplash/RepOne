package com.splashlearn.app.library;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplashMathLibrary extends BaseLibrary {

    public SplashMathLibrary(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

//     Method for Entering age passcode
//	public static void agePasscode() throws IOException {
//		for(char c : SplashM3athConstants.DEFAULT_AGE_FOR_PASSCODE.toCharArray())
//			new AppiumLibrary(driver).click(MobileBy.AccessibilityId(String.valueOf(c)));
//	}

    // Method for Entering passcode
    public void clickOnPassCode() {
        try {
            if (driver.findElementByAccessibilityId("To access, enter the following numbers").isDisplayed()) {
                Map<String, String> data = GetNameValue();
                List<MobileElement> element = driver.findElementByClassName("XCUIElementTypeWindow")
                        .findElements(By.className("XCUIElementTypeStaticText"));
                String completeText = element.get(2).getText();
                String[] strArr = completeText.split(" ");
                for (int j = 0; j < strArr.length; j++) {
                    try {
                        driver.findElementByName(data.get(strArr[j])).click();
                        System.out.println("Tapping on random passcode value");
                    } catch (Exception e) {
                        System.out.println("Not found");
                    }

                }
            }

        } catch (Exception e) {
            System.out.println("Entering Age Verification passcode");
            driver.findElementByAccessibilityId("1").click();
            driver.findElementByAccessibilityId("9").click();
            driver.findElementByAccessibilityId("6").click();
            driver.findElementByAccessibilityId("3").click();

        }
    }

    public Map<String, String> GetNameValue() {
        Map<String, String> data = new HashMap<>();
        data.put("ZERO", "0");
        data.put("ONE", "1");
        data.put("TWO", "2");
        data.put("THREE", "3");
        data.put("FOUR", "4");
        data.put("FIVE", "5");
        data.put("SIX", "6");
        data.put("SEVEN", "7");
        data.put("EIGHT", "8");
        data.put("NINE", "9");
        return data;
    }


    public void ByteSize2Login() throws InterruptedException, IOException {
        driver.findElementByAccessibilityId("alreadyRegistered").click();
        if (!driver.findElements(By.name("SPLoginTypeSelectionHomeButton")).isEmpty()) {
            System.out.println("Game Test will proceed on IPAD");
            driver.findElementByAccessibilityId("SPLoginTypeSelectionHomeButton").click();
            driver.findElementByAccessibilityId("emailFieldLogin").sendKeys("ak+bt2.0@splashmath.com");
            driver.findElementByAccessibilityId("passwordLogin").sendKeys("123456");
            driver.findElementByAccessibilityId("doneButtonLogin").click();
            sleep(10000);
            //driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"K-5 Splash Math\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSegmentedControl/XCUIElementTypeButton[2]").click();

        } else {
            System.out.println("Game Test will proceed on IPHONE");
            driver.findElementByAccessibilityId("emailFieldLogin").sendKeys("ak+bt2.0@splashmath.com");
            driver.findElementByAccessibilityId("passwordLogin").sendKeys("123456");
            driver.findElementByAccessibilityId("doneButtonLogin").click();
            sleep(10000);
            //driver.findElementByXPath("//XCUIElementTypeApplication[@name=\"K-5 Splash Math\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSegmentedControl/XCUIElementTypeButton[2]").click();

        }

    }

    public static void sleep(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
        }
    }

    public static String now() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }


}
