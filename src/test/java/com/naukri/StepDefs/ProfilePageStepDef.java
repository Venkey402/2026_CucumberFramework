package com.naukri.StepDefs;

import com.naukri.PageObjects.ProfilePage;
import com.naukri.TestContext.TestContext;
import com.naukri.Utilities.config.ReadConfig;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class ProfilePageStepDef {

    private static final Logger log = LoggerFactory.getLogger(ProfilePageStepDef.class);
    ReadConfig readConfig = new ReadConfig();

    String resumeHeadline=readConfig.getResumeHeadline();
    TestContext testContext;
    ProfilePage profilePage;

    public ProfilePageStepDef(TestContext testContext) {
        this.testContext=testContext;
        profilePage = new ProfilePage(testContext.driver);
    }
    @When("users updates profile summary")
    public void users_updates_profile_summary() {

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
    @Then("verify user resume is updated")
    public void user_resume_is_updated() {
        Assert.assertTrue(profilePage.isResumeHeadlineSaved());
    }
}
