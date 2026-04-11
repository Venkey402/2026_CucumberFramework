package com.naukri.TestContext;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestContext {

    public WebDriver driver;

    public TestContext()
    {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }


}
