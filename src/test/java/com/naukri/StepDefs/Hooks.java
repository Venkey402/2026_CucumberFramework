package com.naukri.StepDefs;

import com.naukri.TestContext.TestContext;
import com.naukri.Utilities.config.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.time.Duration;

public class Hooks {
    TestContext testContext;
    ReadConfig readConfig = new ReadConfig();

    public Hooks(TestContext testContext)
    {
        this.testContext=testContext;
    }

    @Before
    public void beforeScenario()
    {
        System.out.println(" ************** before Scenario ****************");
        testContext.driver.manage().window().maximize();
        testContext.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        testContext.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        testContext.driver.get(readConfig.getUrl());
    }

    @After
    public void afterScenario()
    {
        System.out.println(" ************** after Scenario ****************");
        testContext.driver.quit();
    }
}

