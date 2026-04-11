package com.naukri.StepDefs;

import com.naukri.TestContext.TestContext;
import com.naukri.Utilities.config.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import java.time.Duration;

public class Hooks {
    ;

    @Before
    public void beforeScenario()
    {
        System.out.println(" ************** before Scenario ****************");

    }

    @After
    public void afterScenario()
    {
        System.out.println(" ************** after Scenario ****************");
    }
}

