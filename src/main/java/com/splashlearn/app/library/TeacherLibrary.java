package com.splashlearn.app.library;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TeacherLibrary extends AppiumLibrary {

    private final Logger logger = LogManager.getRootLogger();

    public TeacherLibrary(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void login() {
        SplashMathLibrary.sleep(10000);

        driver.findElementByAccessibilityId("alreadyRegistered").click();
        SplashMathLibrary.sleep(2000);
        driver.findElementByAccessibilityId("I am a Parent/Teacher").click();
        SplashMathLibrary.sleep(2000);
        driver.findElementByAccessibilityId("Second").click();
        driver.findElementByAccessibilityId("emailFieldLogin").sendKeys("vv+teach22@splashmath.com");

        driver.findElementByAccessibilityId("passwordLogin").sendKeys("123456");
        driver.findElementByAccessibilityId("doneButtonLogin").click();

        SplashMathLibrary.sleep(30000);

        // driver.findElementByAccessibilityId("my class").click();
        driver.findElementByXPath(
                "//XCUIElementTypeApplication[@name=\"K-5 Splash Math\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther")
                .click();
        ;

        // driver.findElementByAccessibilityId("Assi").click();

        driver.findElementByXPath(
                "//XCUIElementTypeApplication[@name=\"K-5 Splash Math\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther")
                .click();

        SplashMathLibrary.sleep(10000);
        try {
            SplashMathLibrary.sleep(10000);
            if (driver.findElementByAccessibilityId("sync").isDisplayed()) {
                System.out.println("User language is ENGLISH and Syncing data");

                driver.findElementByAccessibilityId("sync").click();
            }
        } catch (Exception e) {

            {
                SplashMathLibrary.sleep(10000);
                System.out.println("User language is SPANISH and Syncing data");
                driver.findElementByAccessibilityId("sync es").click();
            }
        }

        SplashMathLibrary.sleep(15000);

        // Tapping on Special balloon in not found will tap on Topic balloon

        System.out.println("Tapping on Special ballon /MyTO DO");
        if (driver.findElementByAccessibilityId("CSSpecialBalloon").isDisplayed()) {
            SplashMathLibrary.sleep(10000);
            driver.findElementByAccessibilityId("SpecialBalloonCellIdentifier").click();
            SplashMathLibrary.sleep(4000);
            driver.findElementByAccessibilityId("WVCSkillToBePlayedChangeLevelB").click();
        } else if (driver.findElementByAccessibilityId("BalloonCell1").isDisplayed()) {
            System.out.println("Tapping on Topic ballon");
            SplashMathLibrary.sleep(10000);
            // driver.findElementByAccessibilityId("Kindergarten").click();
            SplashMathLibrary.sleep(10000);
            driver.findElementByAccessibilityId("BalloonCell1").click();
            SplashMathLibrary.sleep(2000);
            driver.findElementByAccessibilityId("StartButtonIdentifier").click();
            // driver.findElementByAccessibilityId("1").click(); // Tapped on Skill
            SplashMathLibrary.sleep(10000);
        }

        // driver.findElementByAccessibilityId("BalloonCell0").click(); // Tapped on
        // Balloon
        System.out.println("Content loaded Sucessfully");
        driver.findElementByAccessibilityId("QPPause").click(); // Tapped on Pause Button
        System.out.println("Tapped on Pause Button");
        SplashMathLibrary.sleep(1000);
        driver.findElementByAccessibilityId("QPHome").click(); // Tapped on Home button
        System.out.println("Tapped on Home Button in content");
        SplashMathLibrary.sleep(2000);
        driver.findElementByAccessibilityId("SettingsButtonIdentifier").click();
        System.out.println("Opened Setting Drawer");
        SplashMathLibrary.sleep(2000);
        driver.findElementByAccessibilityId("SettingsButton").click();
        System.out.println("Tapped on Setting Opton");
        SplashMathLibrary.sleep(2000);

        driver.findElementByAccessibilityId("1").click();
        driver.findElementByAccessibilityId("9").click();
        driver.findElementByAccessibilityId("6").click();
        driver.findElementByAccessibilityId("3").click();
        System.out.println("Passcode Entered");
        SplashMathLibrary.sleep(8000);
        // driver.findElementByAccessibilityId("DebugPass").click();

        try {
            if (driver.findElementByAccessibilityId("Sign out").isDisplayed()) {
                System.out.println("Tapped on Signout Opton");
                driver.findElementByAccessibilityId("Sign out").click();
                SplashMathLibrary.sleep(10000);
                driver.findElementByName("Sign out").click();
            }
        } catch (Exception e) {

            // if (driver.findElementByAccessibilityId("Desconectarse").isDisplayed()){
            System.out.println("Tapped on Desconectarse Opton");
            driver.findElementByAccessibilityId("Desconectarse").click();
            SplashMathLibrary.sleep(4000);
            driver.findElementByAccessibilityId("Desconectarse").click();
        }

        System.out.println("Tapped on Singout on popup");
        // driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Sign
        // out\"]").click();

        System.out.println("User successfully signout");
        SplashMathLibrary.sleep(10000);
        // driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Sign
        // out\"]").click();

    }

    public void privacyPolicy() {
        System.out.println("Tapped on Privacy Policy link");
        driver.runAppInBackground(Duration.ofSeconds(5));
        driver.findElementByAccessibilityId("PrivacyPolicy").click();
        SplashMathLibrary.sleep(10000);
        System.out.println("Tapping on Passcode");
        //commonModule.ClickOnPassCode();
        new SplashMathLibrary(driver).clickOnPassCode();
        SplashMathLibrary.sleep(10000);
        driver.findElementByAccessibilityId("Done").click();
        SplashMathLibrary.sleep(10000);
        System.out.println("User is on 1st Landing page");
    }

    public void Dashboard_Learning_Path_Button_Display() {
        if (driver.findElementByName("byteSizeDashboardPlayButton").isDisplayed()) {
            logger.debug("Learning path button is displayed.");
        }

    }

    public void Dashboard_Math_Facts_Button_Display() {
        if (driver.findElementByName("Math Facts").isDisplayed()) {
            logger.debug("Math Facts button is displayed.");
        }
    }

    public void Dashboard_Reports_Button_Display() {
        if (driver.findElementByName("SPByteSizeNavSpotlightButton i").isDisplayed()) {
            logger.debug("Reports button is displayed.");
        }
    }

    public void Dashboard_Menu_Button_Display() {

        if (driver.findElementByName("SPByteSizeNavMenuButton iphone").isDisplayed()) {
            logger.debug("Menu button is displayed.");

        }

    }

    public void Dashboard_Curriculum_Tab_Display() {
        if (driver.findElementByXPath(
                "//XCUIElementTypeApplication[@name=\"K-5 Splash Math\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSegmentedControl/XCUIElementTypeButton[1]")
                .isDisplayed()) {
            logger.debug("Curriculum tab is displayed.");

        }

    }

    public void Dashboard_Learning_Tab_Display() {

        if (driver.findElementByXPath(
                "//XCUIElementTypeApplication[@name=\"K-5 Splash Math\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSegmentedControl/XCUIElementTypeButton[2]")
                .isDisplayed()) {
            logger.debug("Learning tab is displayed.");

        }

    }

    public void Dashboard_Child_Name_Child_Grade_Display() {
        if (driver.findElementByName("Childone").isDisplayed()
                && driver.findElementByName("Currently Playing Kindergarten").isDisplayed()) {
            logger.debug("Child Name and Grade is displayed.");

        }
    }

    // Byte size Daily challenge played
    public void Learning_Path_screen_Display() {
        driver.findElementByName("byteSizeDashboardPlayButton").click();
        logger.debug("DailyByte Play Button is clicked");
        SplashMathLibrary.sleep(2000);
        if (driver.findElementByName("My Learning Path").isDisplayed()) {
            logger.debug("Learning Path screen is displayed");
        }
    }

    public void Learning_Path_Daily_Cards_Scrolling() {
        scroll(605, 207, 140, 207, 1000);
        SplashMathLibrary.sleep(1000);
        logger.debug("Scrolled 1st time");
        scroll(605, 207, 140, 207, 1000);
        SplashMathLibrary.sleep(1000);
        logger.debug("Scrolled 2nd time");
        scroll(605, 207, 140, 207, 1000);
        SplashMathLibrary.sleep(1000);
        logger.debug("Scrolled 3rd time");
        if (driver.findElementByName("SPByteSizeDashboardGiftBG").isDisplayed()) {
            logger.debug("Daily Gift is displayed.");
        }
    }

    public void Learning_Path_1st_Daily_Cards_Play_All_Question() {
        scroll(140, 207, 605, 207, 1000);
        SplashMathLibrary.sleep(1000);
        logger.debug("Scrolled Back 1st time");
        scroll(140, 207, 605, 207, 1000);
        SplashMathLibrary.sleep(1000);
        logger.debug("Scrolled Back 2nd time");
        scroll(140, 207, 605, 207, 1000);
        SplashMathLibrary.sleep(1000);
        logger.debug("Scrolled Back 3rd time");
        SplashMathLibrary.sleep(1000);

        driver.findElementByXPath(
                "//XCUIElementTypeApplication[@name=\"K-5 Splash Math\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther")
                .click();
        SplashMathLibrary.sleep(4000);

        do {

            try {
                driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Study Pad\"]/XCUIElementTypeOther[5]")
                        .click();

                WebElement element = driver.findElementByName("Next");
                new Actions(driver).moveToElement(element).click().perform();

            } catch (Exception e) {

                System.out.println(e);
            }

        }

        while (driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Study Pad\"]/XCUIElementTypeOther[5]")
                .isDisplayed());

    }

    public void Learning_Path_1st_Card_Completion_Popup_Displayed() {

        if (driver.findElementByName("1").isDisplayed()) {
            logger.debug("1st card complition popup is displayed");
            SplashMathLibrary.sleep(1000);
        }

        WebElement element = driver.findElementByName("SPBytesizeQuestionLevelButton");
        new Actions(driver).moveToElement(element).click().perform();

    }

    public void Learning_Path_2nd_Daily_Cards_Play_All_Question() {
        do {
            try {
                driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Study Pad\"]/XCUIElementTypeOther[5]")
                        .click();

                WebElement element = driver.findElementByName("Next");
                new Actions(driver).moveToElement(element).click().perform();

            } catch (Exception e) {
                System.out.println(e);
            }

        } while (driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Study Pad\"]/XCUIElementTypeOther[5]")
                .isDisplayed());

        // logger.debug("1st card popup Next button is clicked.");
    }

    public void Learning_Path_2nd_Daily_Completion_pitchstop() {
        if (driver.findElementByName("2").isDisplayed()) {
            logger.debug("2nd card complition popup is displayed");
            SplashMathLibrary.sleep(1000);
        }
        WebElement element = driver.findElementByName("SPBytesizeQuestionLevelButton");
        new Actions(driver).moveToElement(element).click().perform();

    }

    public void Learning_Path_3rd_Daily_Cards_Play_All_Question() {
        do {

            try {

                driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Study Pad\"]/XCUIElementTypeOther[5]")
                        .click();

                WebElement element = driver.findElementByName("Next");
                new Actions(driver).moveToElement(element).click().perform();

            } catch (Exception e) {

                System.out.println(e);
            }

        }

        while (driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Study Pad\"]/XCUIElementTypeOther[5]")
                .isDisplayed());

    }

    public void Learning_Path_3rd_Card_Completion_pitstop() {
        if (driver.findElementByName("3").isDisplayed()) {
            logger.debug("3rd card completion popup is displayed");
            SplashMathLibrary.sleep(1000);
        }

        WebElement element = driver.findElementByName("SPBytesizeQuestionLevelButton");
        new Actions(driver).moveToElement(element).click().perform();
    }

    public void Learning_Path_pet_Congratulation_pitstop() {
        if (driver.findElementByName("SPBytesizeQuestionLevelFinalBu").isDisplayed()) {
            logger.debug("Pet Congratulation popup is displayed.");
            SplashMathLibrary.sleep(1000);
        }

        WebElement element = driver.findElementByName("SPBytesizeQuestionLevelFinalBu");
        new Actions(driver).moveToElement(element).click().perform();
    }

    public void Learning_Path_pet_Play_Now_pitstop() throws InterruptedException {
        if (driver.findElementByName("SPBytesizeQuestionLevelRewardEarnGift").isDisplayed()) {
            logger.debug("Pet play Now popup is displayed.");
            SplashMathLibrary.sleep(1000);
        }

        WebElement element = driver.findElementByName("SPBytesizeQuestionLevelRewardE");
        new Actions(driver).moveToElement(element).click().perform();
        SplashMathLibrary.sleep(5000);
    }

    public String GetCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }

    public void BetaGamesContent() throws InterruptedException, IOException {
        // SkyLand
        new SplashMathLibrary(driver).ByteSize2Login();
        driver.findElementByXPath(
                "//XCUIElementTypeApplication[@name=\"K-5 Splash Math\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSegmentedControl/XCUIElementTypeButton[2]")
                .click();
        driver.findElementByAccessibilityId("Sky Lands").click();
        driver.findElementByAccessibilityId("1").click();
        File srcFile1 = driver.getScreenshotAs(OutputType.FILE);
        File targetFile1 = new File(
                "/Users/ashishkumar/Documents/Workspace/SplashmathFramework/apps-test-automation/src/test/resources/roughWork/ScreenShotContentGames/SkyLand"
                        + GetCurrentTimeStamp() + ".jpg");
        FileUtils.copyFile(srcFile1, targetFile1);
        driver.runAppInBackground(Duration.ofSeconds(1));
        driver.findElementByXPath(
                "//XCUIElementTypeOther[@name=\"StudyPad-Games\"]/XCUIElementTypeOther/XCUIElementTypeImage[3]")
                .click();
        driver.findElementByAccessibilityId("SPByteSizeGameCross").click();

        // Bird Trouble

        driver.findElementByAccessibilityId("Bird Trouble").click();
        driver.findElementByAccessibilityId("1").click();
        SplashMathLibrary.sleep(5000);
        File srcFile2 = driver.getScreenshotAs(OutputType.FILE);
        File targetFile2 = new File(
                "/Users/ashishkumar/Documents/Workspace/SplashmathFramework/apps-test-automation/src/test/resources/roughWork/ScreenShotContentGames/BirdTrouble"
                        + GetCurrentTimeStamp() + ".jpg");
        FileUtils.copyFile(srcFile2, targetFile2);
        driver.runAppInBackground(Duration.ofSeconds(1));
        driver.findElementByXPath(
                "//XCUIElementTypeOther[@name=\"StudyPad-Games\"]/XCUIElementTypeOther/XCUIElementTypeImage[3]")
                .click();
        driver.findElementByAccessibilityId("SPByteSizeGameCross").click();

        // SplashParty

        driver.findElementByAccessibilityId("Splash Party").click();
        driver.findElementByAccessibilityId("1").click();
        File srcFile3 = driver.getScreenshotAs(OutputType.FILE);
        File targetFile3 = new File(
                "/Users/ashishkumar/Documents/Workspace/SplashmathFramework/apps-test-automation/src/test/resources/roughWork/ScreenShotContentGames/SplashParty"
                        + GetCurrentTimeStamp() + ".jpg");
        FileUtils.copyFile(srcFile3, targetFile3);
        driver.runAppInBackground(Duration.ofSeconds(1));
        driver.findElementByXPath(
                "//XCUIElementTypeOther[@name=\"StudyPad-Games\"]/XCUIElementTypeOther/XCUIElementTypeImage[3]")
                .click();
        driver.findElementByAccessibilityId("SPByteSizeGameCross").click();

        // HungrySnails

        driver.findElementByAccessibilityId("Hungry Snails").click();
        driver.findElementByAccessibilityId("1").click();
        SplashMathLibrary.sleep(5000);
        File srcFile4 = driver.getScreenshotAs(OutputType.FILE);
        File targetFile4 = new File(
                "/Users/ashishkumar/Documents/Workspace/SplashmathFramework/apps-test-automation/src/test/resources/roughWork/ScreenShotContentGames/HungarySnails"
                        + GetCurrentTimeStamp() + ".jpg");
        FileUtils.copyFile(srcFile4, targetFile4);
        driver.runAppInBackground(Duration.ofSeconds(1));
        driver.findElementByXPath(
                "//XCUIElementTypeOther[@name=\"StudyPad-Games\"]/XCUIElementTypeOther/XCUIElementTypeImage[3]")
                .click();
        driver.findElementByAccessibilityId("SPByteSizeGameCross").click();

        // Scrolling

        try {
            scroll(1000, 700, 300, 700, 1000);
            driver.findElementByAccessibilityId("Make way").isDisplayed();
            System.out.println("scroll successfull for ipad");
        } catch (Exception e) {
            scroll(800, 300, 300, 300, 1000);
            System.out.println("scroll successfull for iphone");

        }

        // IntoTheCave

        driver.findElementByAccessibilityId("Into the Cave").click();
        driver.findElementByAccessibilityId("1").click();
        SplashMathLibrary.sleep(5000);
        File srcFile5 = driver.getScreenshotAs(OutputType.FILE);
        File targetFile5 = new File(
                "/Users/ashishkumar/Documents/Workspace/SplashmathFramework/apps-test-automation/src/test/resources/roughWork/ScreenShotContentGames/IntoTheCave"
                        + GetCurrentTimeStamp() + ".jpg");
        FileUtils.copyFile(srcFile5, targetFile5);
        driver.runAppInBackground(Duration.ofSeconds(1));
        driver.findElementByXPath(
                "//XCUIElementTypeOther[@name=\"StudyPad-Games\"]/XCUIElementTypeOther/XCUIElementTypeImage[3]")
                .click();
        driver.findElementByAccessibilityId("SPByteSizeGameCross").click();

        // MakeWay
        driver.findElementByAccessibilityId("Make Way").click();
        driver.findElementByAccessibilityId("1").click();
        SplashMathLibrary.sleep(5000);
        File srcFile6 = driver.getScreenshotAs(OutputType.FILE);
        File targetFile6 = new File(
                "/Users/ashishkumar/Documents/Workspace/SplashmathFramework/apps-test-automation/src/test/resources/roughWork/ScreenShotContentGames/MakeWay"
                        + GetCurrentTimeStamp() + ".jpg");
        FileUtils.copyFile(srcFile6, targetFile6);
        driver.runAppInBackground(Duration.ofSeconds(1));
        driver.findElementByXPath(
                "//XCUIElementTypeOther[@name=\"StudyPad-Games\"]/XCUIElementTypeOther/XCUIElementTypeImage[3]")
                .click();
        driver.findElementByAccessibilityId("SPByteSizeGameCross").click();

        // CatOut

        driver.findElementByAccessibilityId("Cat Out").click();
        driver.findElementByAccessibilityId("1").click();
        SplashMathLibrary.sleep(5000);
        File srcFile7 = driver.getScreenshotAs(OutputType.FILE);
        File targetFile7 = new File(
                "/Users/ashishkumar/Documents/Workspace/SplashmathFramework/apps-test-automation/src/test/resources/roughWork/ScreenShotContentGames/CatOut"
                        + GetCurrentTimeStamp() + ".jpg");
        FileUtils.copyFile(srcFile7, targetFile7);
        driver.runAppInBackground(Duration.ofSeconds(2));
        driver.findElementByXPath(
                "//XCUIElementTypeOther[@name=\"StudyPad-Games\"]/XCUIElementTypeOther/XCUIElementTypeImage[3]")
                .click();
        driver.findElementByAccessibilityId("SPByteSizeGameCross").click();

        // HoppysList
        driver.findElementByAccessibilityId("Hoppy's List").click();
        driver.findElementByAccessibilityId("1").click();
        SplashMathLibrary.sleep(5000);
        File srcFile8 = driver.getScreenshotAs(OutputType.FILE);
        File targetFile8 = new File(
                "/Users/ashishkumar/Documents/Workspace/SplashmathFramework/apps-test-automation/src/test/resources/roughWork/ScreenShotContentGames/HoppysList"
                        + GetCurrentTimeStamp() + ".jpg");
        FileUtils.copyFile(srcFile8, targetFile8);
        driver.runAppInBackground(Duration.ofSeconds(1));
        driver.findElementByXPath(
                "//XCUIElementTypeOther[@name=\"StudyPad-Games\"]/XCUIElementTypeOther/XCUIElementTypeImage[3]")
                .click();
        driver.findElementByAccessibilityId("SPByteSizeGameCross").click();

        // Scrolling

        try {
            scroll(1000, 700, 200, 700, 1000);
            driver.findElementByAccessibilityId("Dial Shooter").isDisplayed();
            System.out.println("scroll successfull for ipad");
        } catch (Exception e) {
            scroll(800, 300, 200, 300, 1000);
            System.out.println("scroll successfull for iphone");
        }
        // IceTrap
        driver.findElementByAccessibilityId("Ice Trap").click();
        driver.findElementByAccessibilityId("1").click();
        SplashMathLibrary.sleep(5000);
        File srcFile9 = driver.getScreenshotAs(OutputType.FILE);
        File targetFile9 = new File(
                "/Users/ashishkumar/Documents/Workspace/SplashmathFramework/apps-test-automation/src/test/resources/roughWork/ScreenShotContentGames/IceTrap"
                        + GetCurrentTimeStamp() + ".jpg");
        FileUtils.copyFile(srcFile9, targetFile9);
        driver.runAppInBackground(Duration.ofSeconds(1));
        driver.findElementByXPath(
                "//XCUIElementTypeOther[@name=\"StudyPad-Games\"]/XCUIElementTypeOther/XCUIElementTypeImage[3]")
                .click();
        driver.findElementByAccessibilityId("SPByteSizeGameCross").click();

        // ZooZooTrain
        driver.findElementByAccessibilityId("Zoo Zoo Train").click();
        driver.findElementByAccessibilityId("1").click();
        SplashMathLibrary.sleep(5000);
        File srcFile10 = driver.getScreenshotAs(OutputType.FILE);
        File targetFile10 = new File(
                "/Users/ashishkumar/Documents/Workspace/SplashmathFramework/apps-test-automation/src/test/resources/roughWork/ScreenShotContentGames/ZooZooTrain"
                        + GetCurrentTimeStamp() + ".jpg");
        FileUtils.copyFile(srcFile10, targetFile10);
        driver.runAppInBackground(Duration.ofSeconds(1));
        driver.findElementByXPath(
                "//XCUIElementTypeOther[@name=\"StudyPad-Games\"]/XCUIElementTypeOther/XCUIElementTypeImage[3]")
                .click();
        driver.findElementByAccessibilityId("SPByteSizeGameCross").click();

        // Elevate
        driver.findElementByAccessibilityId("Elevate").click();
        driver.findElementByAccessibilityId("1").click();
        SplashMathLibrary.sleep(5000);
        File srcFile11 = driver.getScreenshotAs(OutputType.FILE);
        File targetFile11 = new File(
                "/Users/ashishkumar/Documents/Workspace/SplashmathFramework/apps-test-automation/src/test/resources/roughWork/ScreenShotContentGames/Elevate"
                        + GetCurrentTimeStamp() + ".jpg");
        FileUtils.copyFile(srcFile11, targetFile11);
        driver.runAppInBackground(Duration.ofSeconds(2));
        driver.findElementByXPath(
                "//XCUIElementTypeOther[@name=\"StudyPad-Games\"]/XCUIElementTypeOther/XCUIElementTypeImage[3]")
                .click();
        driver.findElementByAccessibilityId("SPByteSizeGameCross").click();

        // DialShooter
        driver.findElementByAccessibilityId("Dial Shooter").click();
        driver.findElementByAccessibilityId("1").click();
        SplashMathLibrary.sleep(5000);
        File srcFile12 = driver.getScreenshotAs(OutputType.FILE);
        File targetFile12 = new File(
                "/Users/ashishkumar/Documents/Workspace/SplashmathFramework/apps-test-automation/src/test/resources/roughWork/ScreenShotContentGames/DialShooter"
                        + GetCurrentTimeStamp() + ".jpg");
        FileUtils.copyFile(srcFile12, targetFile12);
        driver.runAppInBackground(Duration.ofSeconds(1));
        driver.findElementByXPath(
                "//XCUIElementTypeOther[@name=\"StudyPad-Games\"]/XCUIElementTypeOther/XCUIElementTypeImage[3]")
                .click();
        driver.findElementByAccessibilityId("SPByteSizeGameCross").click();

    }

}
