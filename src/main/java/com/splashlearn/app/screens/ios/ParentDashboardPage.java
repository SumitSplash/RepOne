package com.splashlearn.app.screens.ios;

import com.splashlearn.app.library.AppiumLibrary;
import com.splashlearn.app.library.SplashMathLibrary;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ParentDashboardPage extends BasePage {

    public ParentDashboardPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    WorksheetPage worksheetPage = new WorksheetPage(driver);

    @iOSXCUITFindBy(accessibility = "NoThanksIdentifier")
    private MobileElement noThanks;

    @iOSXCUITFindBy(accessibility = "SPSetWeeklyGoalCrossButton")
    private MobileElement setGoalCrossButton;

    @iOSXCUITFindBy(accessibility = "SettingsButtonIdentifier")
    public MobileElement settingButton;

    @iOSXCUITFindBy(accessibility = "Enable Notifications")
    public MobileElement enableNotifications;

    @iOSXCUITFindBy(accessibility = "Allow")
    private MobileElement allow;

    @iOSXCUITFindBy(accessibility = "CAGreenButton")
    private MobileElement caGreenButton;

    @iOSXCUITFindBy(accessibility = "Set a practice Schedule")
    private MobileElement setGoal;

    @iOSXCUITFindBy(accessibility = "SPSetWeeklyGoalCrossButton")
    private MobileElement crossGoal;

    @iOSXCUITFindBy(accessibility = "Save Goal")
    private MobileElement saveGoal;

    @iOSXCUITFindBy(accessibility = "Settings")
    private MobileElement settings;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"2\"]")
    private MobileElement digitTwo;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"0\"]")
    private MobileElement digitZero;

    @iOSXCUITFindBy(accessibility = "Later")
    private MobileElement later;

    @iOSXCUITFindBy(accessibility = "SPCurriculumNavMenu")
    public MobileElement menuBS;

    @iOSXCUITFindBy(accessibility = "BSSideDrawerSettings")
    private MobileElement settingsBS;

    @iOSXCUITFindBy(accessibility = "BSSideDrawerChangeProfile")
    private MobileElement changeProfileBS;

    @iOSXCUITFindBy(accessibility = "CSSwitchButtonYellow")
    private MobileElement changeProfileIpad;

    @iOSXCUITFindBy(accessibility = "SPCurriculumUpArrowIcon")
    private MobileElement upArrow;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[5]")
    private MobileElement secondContentGroup;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[6]")
    private MobileElement secondContentGroupUnpaid;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[5]")
    private MobileElement secondContentGroupIpad;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[6]")
    private MobileElement secondContentGroupIpadUnpaid;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]")
    private MobileElement firsLPPlayable;

    @iOSXCUITFindBy(accessibility = "Login")
    private MobileElement loginCF;

    @iOSXCUITFindBy(accessibility = "BalloonCell0")
    private MobileElement balloonOne;

    @iOSXCUITFindBy(accessibility = "Start")
    private MobileElement startContentCF;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"SplashLearn\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther")
    private MobileElement childAchievement;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeButton")
    private MobileElement playAquariumGames;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Play\"])[2]")
    private MobileElement playJungleGames;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Button\"])[1]")
    private MobileElement gameplay;

    @iOSXCUITFindBy(accessibility = "WVCSettingsButton")
    private MobileElement settingsBSiPad;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]")
    private MobileElement mathGamesIpad;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]")
    private MobileElement mathGamesIphone;

    @iOSXCUITFindBy(accessibility = "byteSizeDashboardFloatingBox")
    public MobileElement byteSize2PLayButton;


    public void clickNoThanks() {
        appiumLibrary.click(noThanks);
    }

    public void clickSettingButton() {
        appiumLibrary.click(settingButton);
    }

    public void clickEnableNotification() {
        appiumLibrary.click(enableNotifications);
    }

    public void clickAllow() {
        appiumLibrary.click(allow);
    }

    public void clickCAGreenButton() {
        appiumLibrary.click(caGreenButton);
    }


    public void selectGrade(String grades) {
        appiumLibrary.click(MobileBy.AccessibilityId(grades));
    }

    public void clickSetGoal() {
        appiumLibrary.click(setGoal);
    }

    public void clickCrossGoal() {
        appiumLibrary.click(crossGoal);
    }

    public void clickSaveGoal() {
        appiumLibrary.click(saveGoal);
    }

    public void clickSettings() {
        appiumLibrary.click(settings);
    }

    public void clickGoalCross() {
        appiumLibrary.click(setGoalCrossButton);
    }

    public void clickLater() {
        appiumLibrary.click(later);
    }

    public void clickMenuBS() {
        appiumLibrary.click(menuBS);
    }

    public void clickChangeProfileBS() {
        appiumLibrary.click(changeProfileBS);
    }

    public void clickChangePRofileIpad() {
        appiumLibrary.click(changeProfileIpad);
    }

    public void clickUpArrow() {
        appiumLibrary.click(upArrow);
    }

    public void clickBalloonOne() {
        appiumLibrary.click(balloonOne);
    }

    public void clickStartContentCF() {
        appiumLibrary.click(startContentCF);
    }

    public void clickLoginCF() {
        appiumLibrary.click(loginCF);
    }

    public void clickByteSize2PlayButton() {
        appiumLibrary.click(byteSize2PLayButton);
    }

    public void clickFirstLP() {
        appiumLibrary.click(firsLPPlayable);
    }

    public void playFirstLPCard() {
        clickFirstLP();
        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("Downloading sounds for the game..."), 5)) {
            worksheetPage.clickPlayAnyway();
        }
        Assert.assertTrue(appiumLibrary.isElementPresent(MobileBy.AccessibilityId("QPPause"), 90), "Content is unable to load");
        worksheetPage.clickPause();
        worksheetPage.clickHome();
    }

//    public void clickSecondContentGroup() {
//        appiumLibrary.click(secondContentGroup);
//    }
//
//    public void clickSecondContentGroupIpad() {
//    public void clickSecondContentGroupIpad() {
//        appiumLibrary.click(secondContentGroupIpad);
//    }

    public void passPaternalGate() {
        appiumLibrary.click(digitTwo);
        int i;
        for (i = 0; i <= 2; i++) {
            appiumLibrary.click(digitZero);
        }
    }

    public String getplayableName() {
        String name = driver.findElement(By.xpath("//XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText")).getAttribute("name");
        System.out.println(name);
        return name;
    }

    public String getFirstContentGroupName() {
        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("SPCurriculumUnlockContent"), 1)) {
            String name = driver.findElement(By.xpath("//XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[5]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText")).getAttribute("name");
            System.out.println(name);
            return name;
        } else {
            String name = driver.findElement(By.xpath("//XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText")).getAttribute("name");
            System.out.println(name);
            return name;
        }
    }

    public String getFirstContentGroupNameIphone() {
        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("SPCurriculumUnlockContent"), 1)) {
            String name = driver.findElement(By.xpath("//XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[5]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText")).getAttribute("name");
            System.out.println(name);
            return name;
        } else {
            String name = driver.findElement(By.xpath("//XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText")).getAttribute("name");
            System.out.println(name);
            return name;
        }
    }


    public String getFirstContentGroupNameIpad() {
        String name = driver.findElement(By.xpath("//XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[4]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText")).getAttribute("name");
        System.out.println(name);
        return name;
    }

    public String getSecondContentGroupName() {
        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("SPCurriculumUnlockContent"), 1)) {
            String name = driver.findElement(By.xpath("//XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[6]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText")).getAttribute("name");
            System.out.println(name);
            return name;
        } else {
            String name = driver.findElement(By.xpath("//XCUIElementTypeOther[4]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[5]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText")).getAttribute("name");
            System.out.println(name);
            return name;
        }
    }

    public String getSecondContentGroupNameIpad() {
        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("SPCurriculumUnlockContent"), 1)) {
            String name = driver.findElement(By.xpath("//XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[6]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText")).getAttribute("name");
            System.out.println(name);
            return name;
        } else {
            String name = driver.findElement(By.xpath("//XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[5]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText")).getAttribute("name");
            System.out.println(name);
            return name;
        }
    }

    public void clickSecondContentGroupPaid() {
        int i = 0;
        while (++i < 10)
            if (appiumLibrary.isElementPresent(secondContentGroupIpad, 10)) {
                appiumLibrary.click(secondContentGroupIpad);
                return;
            } else if (appiumLibrary.isElementPresent(secondContentGroup, 10)) {
                appiumLibrary.click(secondContentGroup);
                return;
            }
    }


    public void clickSecondContentGroupUnpaid() {
        int i = 0;
        while (++i < 10)
            if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("SPCurriculumUnlockContent"), 1)) {
                if (appiumLibrary.isElementPresent(secondContentGroupIpadUnpaid, 10)) {
                    appiumLibrary.click(secondContentGroupIpadUnpaid);
                    return;
                } else if (appiumLibrary.isElementPresent(secondContentGroupUnpaid, 10)) {
                    appiumLibrary.click(secondContentGroupUnpaid);
                    return;
                }
            }
    }

    public void clickSecondContentGroup(){
        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("SPCurriculumUnlockContent"), 1)) {
            clickSecondContentGroupUnpaid();
        } else {
            clickSecondContentGroupPaid();
        }
    }

    public void clickSettingsButton() {
        int i = 0;
        while (++i < 10)
            if (appiumLibrary.isElementPresent(settingsBSiPad, 10)) {
                appiumLibrary.click(settingsBSiPad);
                return;
            } else if (appiumLibrary.isElementPresent(settingsBS, 10)) {
                appiumLibrary.click(settingsBS);
                return;
            }
    }

    public void clickMathGamesButton() {
        int i = 0;
        while (++i < 10)
            if (appiumLibrary.isElementPresent(mathGamesIpad, 10)) {
                appiumLibrary.click(mathGamesIpad);
                return;
            } else if (appiumLibrary.isElementPresent(mathGamesIphone, 10)) {
                appiumLibrary.click(mathGamesIphone);
                return;
            }
    }



    public String dashboardChildName() {
        SplashMathLibrary.sleep(10000);
        String name = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Playing Math\"]/preceding-sibling::XCUIElementTypeStaticText[1]")).getAttribute("name");
        System.out.println(name);
        return name;
    }

    public void clickChildAchievement() {
        appiumLibrary.click(childAchievement);
    }

    public void clickPlayAquariumGame() {
        appiumLibrary.click(playAquariumGames);
    }

    public void clickPlayJungleGame() {
        appiumLibrary.click(playJungleGames);
    }


    public void clickPlayGame() {
        appiumLibrary.click(gameplay);
    }


}
