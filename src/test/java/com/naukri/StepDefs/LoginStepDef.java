package com.naukri.StepDefs;

import com.naukri.PageObjects.HomePage;
import com.naukri.PageObjects.LoginPage;
import com.naukri.PageObjects.ProfilePage;
import com.naukri.TestContext.TestContext;
import com.naukri.Utilities.config.ReadConfig;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class LoginStepDef {

    private static final Logger log = LoggerFactory.getLogger(LoginStepDef.class);
    ReadConfig readConfig = new ReadConfig();

    String resumeHeadline=readConfig.getResumeHeadline();
    String email=readConfig.getEmail();
    String pass=readConfig.getPassword();
    String url=readConfig.getUrl();
    LoginPage loginPage;
    HomePage homePage;
    ProfilePage profilePage;
    WebDriver driver;

    public LoginStepDef(TestContext testContext) throws IOException {
        driver=testContext.driver;
    }

    @Given("user logins into naukri application")
    public void user_logins_into_naukri_application() throws InterruptedException {



        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.get(url);

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        profilePage = new ProfilePage(driver);

        loginPage.clickOnLoginLink();
        loginPage.enterEmail(email);
        loginPage.enterPassword(pass);
        loginPage.clickOnLogin();
        Thread.sleep(2000);
        homePage.isProfileDisplayed();
        homePage.clickViewProfile();
        profilePage.clickProfileEdit();
        String currentResumeText=profilePage.getResumeHeadline();
        if(currentResumeText.equalsIgnoreCase(resumeHeadline)) {
            profilePage.setResumeHeadline(resumeHeadline+".");
        }
        else {
            profilePage.setResumeHeadline(resumeHeadline);
        }
        profilePage.clickSave();
        Assert.assertTrue(profilePage.isResumeHeadlineSaved());
        driver.quit();
    }
    @When("user uploads resume")
    public void user_uploads_resume() {
        System.out.println("user logins into naukri application");
    }
    @When("users updates profile summary")
    public void users_updates_profile_summary() {
        System.out.println("user logins into naukri application");
    }
    @Then("user resume is updated")
    public void user_resume_is_updated() {
        System.out.println("user logins into naukri application");
    }
}
