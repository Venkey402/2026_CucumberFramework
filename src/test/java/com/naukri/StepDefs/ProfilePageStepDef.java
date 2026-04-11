package com.naukri.StepDefs;

import com.naukri.PageObjects.HomePage;
import com.naukri.PageObjects.LoginPage;
import com.naukri.PageObjects.ProfilePage;
import com.naukri.TestContext.TestContext;
import com.naukri.Utilities.config.ReadConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class ProfilePageStepDef {

    private static final Logger log = LoggerFactory.getLogger(ProfilePageStepDef.class);
    ReadConfig readConfig = new ReadConfig();

    String resumeHeadline=readConfig.getResumeHeadline();
    String email=readConfig.getEmail();
    String pass=readConfig.getPassword();
    String url=readConfig.getUrl();
    LoginPage loginPage;
    HomePage homePage;
    ProfilePage profilePage;
    WebDriver driver;

    public ProfilePageStepDef(TestContext testContext) throws IOException {
        driver=testContext.driver;
    }
    @When("users updates profile summary")
    public void users_updates_profile_summary() {
        System.out.println("user logins into naukri application");
    }
    @Then("verify user resume is updated")
    public void user_resume_is_updated() {
        System.out.println("user logins into naukri application");
    }
}
