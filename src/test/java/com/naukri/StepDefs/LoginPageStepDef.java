package com.naukri.StepDefs;

import com.naukri.PageObjects.HomePage;
import com.naukri.PageObjects.LoginPage;
import com.naukri.TestContext.TestContext;
import com.naukri.Utilities.config.ReadConfig;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class LoginPageStepDef {

    ReadConfig readConfig = new ReadConfig();
    String email=readConfig.getEmail();
    String pass=readConfig.getPassword();
    LoginPage loginPage;
    HomePage homePage;
    TestContext testContext;

    public LoginPageStepDef(TestContext testContext){
        this.testContext=testContext;
        loginPage = new LoginPage(testContext.driver);
        homePage = new HomePage(testContext.driver);
    }

    @Given("user logins into naukri application")
    public void user_logins_into_naukri_application() throws InterruptedException {
        loginPage.clickOnLoginLink();
        loginPage.enterEmail(email);
        loginPage.enterPassword(pass);
        loginPage.clickOnLogin();
        Thread.sleep(2000);
    }
}
