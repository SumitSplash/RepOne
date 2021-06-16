package com.splashlearn.app.screens.ios;

import com.splashlearn.app.library.SplashMathLibrary;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OnBoardingPage extends BasePage {

    public OnBoardingPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    ParentDashboardPage parentDashboardPage = new ParentDashboardPage(driver);

    @iOSXCUITFindBy(accessibility = "Get Started")
    private MobileElement getStarted;

    @iOSXCUITFindBy(accessibility = "Home")
    private MobileElement home;

    @iOSXCUITFindBy(accessibility = "Done")
    private MobileElement done;

    @iOSXCUITFindBy(accessibility = "view_all_plans")
    private MobileElement viewAllPlans;

    @iOSXCUITFindBy(accessibility = "View Plans")
    private MobileElement viewPlans;

    @iOSXCUITFindBy(accessibility = "crossButtonTrialPurchase")
    private MobileElement crossButtonTrialPurchase;

    @iOSXCUITFindBy(accessibility = "Already Registered?")
    private MobileElement alreadyRegister;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"I am a Parent/Teacher\"]")
    private MobileElement parentTeacher;

    @iOSXCUITFindBy(accessibility = "Grade 3")
    private MobileElement grade3;

    @iOSXCUITFindBy(accessibility = "Grade 3")
    private MobileElement grade1;

    @iOSXCUITFindBy(accessibility = "Place Value & Number Sense")
    private MobileElement topic1;

    @iOSXCUITFindBy(accessibility = "CurriculumBuyPageCrossButton")
    private MobileElement crossBuyBS;

    @iOSXCUITFindBy(accessibility = "emailFieldISignUpIdentifier")
    private MobileElement emailField;

    @iOSXCUITFindBy(accessibility = "Continue")
    private MobileElement emailContinue;

    @iOSXCUITFindBy(accessibility = "passwordLogin")
    private MobileElement passwordLogin;

    @iOSXCUITFindBy(accessibility = "Choose for me")
    private MobileElement chooseForMe;

    @iOSXCUITFindBy(accessibility = "crossButtonSignUp")
    private MobileElement signupCrossButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"SplashLearn\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeButton[1]")
    private MobileElement termsOfUse;

    @iOSXCUITFindBy(accessibility = "OkAction")
    private MobileElement ok;

    @iOSXCUITFindBy(xpath = "\"//XCUIElementTypeAlert[@name=\\\"Error\\\"]\"")
    public MobileElement error;

    @iOSXCUITFindBy(accessibility = "SPByteSizeOnBoardingDone")
    private MobileElement doneChildPersona;

    @iOSXCUITFindBy(accessibility = "NameFieldAddChild")
    private MobileElement enterChildNameCF;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeSecureTextField[@name=\"passwordLogin\"])[2]")
    private MobileElement passwordFieldWB;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"doneButtonLogin\"])[2]")
    private MobileElement loginPasswordScreenWB;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView/XCUIElementTypeCell[1]/XCUIElementTypeOther")
    private MobileElement parentpersona;

    @iOSXCUITFindBy(accessibility = "SPFreeTrialCross")
    private MobileElement freeTrialCrossbutton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"SplashLearn\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeButton[1]")
    private MobileElement elaBuyCrossButton;

    @iOSXCUITFindBy(accessibility = "MATH")
    private MobileElement mathsButtonELA;

    @iOSXCUITFindBy(accessibility = "READING")
    private MobileElement readingButtonELA;

    public void selectGrade(String grade) {
        appiumLibrary.click(MobileBy.AccessibilityId(grade));
    }

    public void selectPreferredTopic(String topic) {
        appiumLibrary.click(MobileBy.AccessibilityId(topic));
    }

    public void clickGetStarted() {
        appiumLibrary.click(getStarted);
    }

    public void clickHome() {
        appiumLibrary.click(home);
    }

    public void clickDone() {
        appiumLibrary.click(done);
    }

    public void clickAlreadyRegister() {
        appiumLibrary.click(alreadyRegister);
    }

    public void clickIAmParentTeacher() {
        appiumLibrary.click(parentTeacher);
    }

    public void clickViewAllPlans() {
        SplashMathLibrary.sleep(10000);
        int i = 0;
        while (++i < 10)
            if (appiumLibrary.isElementPresent(viewPlans, 1)) {
                appiumLibrary.click(viewPlans);
                return;
            } else if (appiumLibrary.isElementPresent(viewAllPlans, 1)) {
                appiumLibrary.click(viewAllPlans);
                return;
            }
        Assert.fail("Unable to find View Plans/View All Plans found");
    }

    public void clickPurchaseCross() {
        appiumLibrary.click(crossButtonTrialPurchase);
    }

    public void clickGrade3() {
        appiumLibrary.click(grade3);
    }

    public void clickGrade1() {
        appiumLibrary.click(grade1);
    }

    public void clickTopic1() {
        appiumLibrary.click(topic1);
    }

    public void clickCrossBuyBS() {
        appiumLibrary.click(crossBuyBS);
    }

    public void emailField(String emailField) {
        appiumLibrary.enterText(this.emailField, emailField);
        System.out.println(emailField);
    }

    public void clickContinue() {
        appiumLibrary.click(emailContinue);
    }

    public void passwordLogin(String passwordLogin) {
        appiumLibrary.enterText(this.passwordLogin, passwordLogin);
    }

    public void clickChooseForMe() {
        appiumLibrary.click(chooseForMe);
    }

    public void clickSignupCrossButton() {
        appiumLibrary.click(signupCrossButton);
    }

    public void clickTermsOFUse() {
        appiumLibrary.click(termsOfUse);
    }

    public void clickOkButton() {
        appiumLibrary.click(ok);
    }

    public void clickDoneChildPersona() {
        appiumLibrary.click(doneChildPersona);
    }

    public void clickParentPersona() {
        appiumLibrary.click(parentpersona);
    }

    public void clickMathsButtonELA() {
        appiumLibrary.click(mathsButtonELA);
    }

    public void clickReadingButtonELA() {
        appiumLibrary.click(readingButtonELA);

    }


    public void clickELABuyCrossButton() {
        appiumLibrary.click(elaBuyCrossButton);
    }

    public String enterChildNameCF(String name) {
        appiumLibrary.enterText(this.enterChildNameCF, name);
        appiumLibrary.click(MobileBy.AccessibilityId("Next"));
        return name;
    }


    public void selectGender() {
        List<String> genders = new ArrayList<>();
        genders.add("BoyButton");
        genders.add("Girl");
        Random rand = new Random();
        String gender = genders.get(rand.nextInt(genders.size()));
        appiumLibrary.click(MobileBy.AccessibilityId(gender));
        System.out.println(gender);
    }

    public void selectSubject(){
        List<String> subjects = new ArrayList<>();
        subjects.add("MATH");
        subjects.add("READING");
        Random rand = new Random();
        String subject = subjects.get(rand.nextInt(subjects.size()));
        appiumLibrary.click(MobileBy.AccessibilityId(subject));
        System.out.println(subject);
    }

    public void enterPasswordWB(String password) {
        appiumLibrary.enterText(this.passwordFieldWB, password);
    }

    public void clickLoginWB(){
        appiumLibrary.click(loginPasswordScreenWB);
    }

    public void onBoardingFlow() throws InterruptedException {
        clickGetStarted();
        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("Please accept Terms of Use to continue using SplashLearn."), 1)) {
            clickTermsOFUse();
            clickOkButton();
        }
        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("Home"), 1)) {
            clickHome();
        }
//        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("You can add more accounts from Settings."), 2)) {
//            selectGrade();
//            Assert.assertTrue(appiumLibrary.isElementPresent(MobileBy.AccessibilityId("You can add more accounts from Settings.")), "You can add more accounts from Settings is not available");
//        }
        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("What grade is your child in?"), 2)) {
            selectGrade();
//            Assert.assertTrue(appiumLibrary.isElementPresent(MobileBy.AccessibilityId("What grade is your child in?")), "What grade is your child in is not available");
        }
        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("This will help us personalize your experience."), 2)) {
            parentPersona();
            clickNext();
        }
        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("This will help us personalize your experience..."), 2)) {
            childPersona();
            clickDoneChildPersona();
        }
        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("Select Preferred Topics"), 1)) {
            System.out.println("Bytesize 3.0/2.0 flow.");
            chooseContentGroup();
            clickDone();
            clickViewAllPlans();
            if (appiumLibrary.isElementPresent(crossBuyBS, 1)) {
                clickCrossBuyBS();
            } else {
                appiumLibrary.tap(975, 43);
            }
            clickSignupCrossButton();
        } else if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("NameFieldAddChild"), 1)) {
            System.out.println("Control flow.");
            enterChildNameCF("Raj");
            selectGender();
            selectGradeCF();
            clickSignupCrossButton();
            clickViewAllPlans();
            SplashMathLibrary.sleep(3000);
            appiumLibrary.tap(975, 43);
            if (appiumLibrary.isElementPresent(parentDashboardPage.enableNotifications, 2)) {
                parentDashboardPage.clickEnableNotification();
                parentDashboardPage.clickAllow();
            }

        } else if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("You can modify this selection any time."), 1)) {
            System.out.println("Bytesize 3.0/2.0 flow.");
            clickChooseForMe();
            if (appiumLibrary.isElementPresent(viewAllPlans)) {
                clickViewAllPlans();

                SplashMathLibrary.sleep(3000);
                if (appiumLibrary.isElementPresent(crossBuyBS, 1)) {
                    clickCrossBuyBS();
                } else {
                    appiumLibrary.tap(975, 43);
                }
//                appiumLibrary.tap(975, 43);
                for (int i = 0; i < 2; i++) {
                    appiumLibrary.tap(210, 550);
                }
                clickSignupCrossButton();
            }
        } else if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("Start your free trial"), 1)) {
            System.out.println("ELA flow");
            clickELABuyCrossButton();
            clickSignupCrossButton();
            selectSubject();
            if (appiumLibrary.isElementPresent(chooseForMe, 1)) {
                clickChooseForMe();
            }
            for (int i = 0; i < 3; i++) {
                appiumLibrary.tap(400, 280);
            }
        }
    }

    public void onBoardingFlowTillSignupPage() throws InterruptedException {
        clickGetStarted();
        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("Please accept Terms of Use to continue using SplashLearn."), 1)) {
            clickTermsOFUse();
            clickOkButton();
        }
        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("Home"), 1)) {
            clickHome();
        }
//        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("You can add more accounts from Settings."), 1)) {
//            selectGrade();
//        }
        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("What grade is your child in?"), 2)) {
            selectGrade();
        }
        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("This will help us personalize your experience."), 1)) {
            parentPersona();
            clickNext();
        }
        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("This will help us personalize your experience..."), 1)) {
            childPersona();
            clickDoneChildPersona();
        }
        if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("Select Preferred Topics"), 1)) {
            System.out.println("Bytesize 3.0 flow.");
            chooseContentGroup();
            clickDone();
            clickViewAllPlans();
            clickCrossBuyBS();
        } else if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("NameFieldAddChild"), 1)) {
            System.out.println("Control flow.");
            enterChildNameCF("Raj");
            selectGender();
            selectGradeCF();
            clickSignupCrossButton();
        } else if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("You can modify this selection any time."), 1)) {
            System.out.println("Bytesize 2.0 flow.");
            clickChooseForMe();
            clickViewAllPlans();
            SplashMathLibrary.sleep(3000);
            appiumLibrary.tap(975, 43);
        } else if (appiumLibrary.isElementPresent(MobileBy.AccessibilityId("Start your free trial"), 1)) {
            System.out.println("ELA flow");
            clickELABuyCrossButton();
        }
    }
}