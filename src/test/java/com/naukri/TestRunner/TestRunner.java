package com.naukri.TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/com/naukri/Features",
        glue = "com/naukri/StepDefs",
        tags = "@ProfileSummaryUpdate",
        monochrome = true,
        plugin = {"pretty", "html:target/Cucumber.html"})
public class TestRunner extends AbstractTestNGCucumberTests {
}
