package com.naukri.StepDefs;

import com.naukri.PageObjects.HomePage;
import com.naukri.PageObjects.ProfilePage;
import com.naukri.TestContext.TestContext;
import com.naukri.Utilities.config.ReadConfig;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ProfilePageStepDef {

    ReadConfig readConfig = new ReadConfig();

    String resumeHeadline=readConfig.getResumeHeadline();
    TestContext testContext;
    ProfilePage profilePage;
    HomePage homePage;

    public ProfilePageStepDef(TestContext testContext) {
        this.testContext=testContext;
        profilePage = new ProfilePage(testContext.driver);
        homePage = new HomePage(testContext.driver);
    }
    @When("users updates profile summary")
    public void users_updates_profile_summary() {
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
    }
    @Then("verify profile summary is updated")
    public void user_resume_is_updated() {
        Assert.assertTrue(profilePage.isResumeHeadlineSaved());
    }
}
