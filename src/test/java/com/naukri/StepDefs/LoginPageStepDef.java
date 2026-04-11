package com.naukri.StepDefs;

import com.naukri.PageObjects.HomePage;
import com.naukri.PageObjects.LoginPage;
import com.naukri.TestContext.TestContext;
import com.naukri.Utilities.config.ReadConfig;
import io.cucumber.java.en.*;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class LoginPageStepDef {

    ReadConfig readConfig = new ReadConfig();
    String email=readConfig.getEmail();
    String pass=readConfig.getPassword();
    String url=readConfig.getUrl();
    LoginPage loginPage;
    HomePage homePage;
    TestContext testContext;


    public LoginPageStepDef(TestContext testContext) throws IOException {
        this.testContext=testContext;
        loginPage = new LoginPage(testContext.driver);
        homePage = new HomePage(testContext.driver);
    }

    @Given("user logins into naukri application")
    public void user_logins_into_naukri_application() throws InterruptedException {
        testContext.driver.manage().window().maximize();
        testContext.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        testContext.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        testContext.driver.get(url);

        loginPage.clickOnLoginLink();
        loginPage.enterEmail(email);
        loginPage.enterPassword(pass);
        loginPage.clickOnLogin();
        Thread.sleep(2000);

        Assert.assertTrue(homePage.isProfileDisplayed());
    }
}
