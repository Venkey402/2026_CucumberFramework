package com.naukri.StepDefs;

import com.naukri.PageObjects.HomePage;
import com.naukri.TestContext.TestContext;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

public class HomePageStepDef {

    private static final Logger log = LoggerFactory.getLogger(HomePageStepDef.class);
    HomePage homePage;
    TestContext testContext;

    public HomePageStepDef(TestContext testContext) throws IOException {
        this.testContext=testContext;
    }

    @When("verify user lands on home page")
    public void verifyUserLandsOnHomePage() {
        HomePage homePage = new HomePage(testContext.driver);
        homePage.clickViewProfile();
    }
}
