package com.naukri.StepDefs;

import com.naukri.PageObjects.HomePage;
import com.naukri.TestContext.TestContext;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class HomePageStepDef {

    HomePage homePage;
    TestContext testContext;

    public HomePageStepDef(TestContext testContext) {
        this.testContext=testContext;
        homePage = new HomePage(testContext.driver);
    }

    @When("verify user lands on home page")
    public void verifyUserLandsOnHomePage() {
        Assert.assertTrue(homePage.verifyCurrentUrlContainsHomepage());
        Assert.assertTrue(homePage.isProfileDisplayed());
    }
}
