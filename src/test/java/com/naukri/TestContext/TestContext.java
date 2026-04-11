package com.naukri.TestContext;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestContext {

    public WebDriver driver;
    String browser;
    public TestContext()
    {
        try {
            browser = System.getProperty("browser");
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/Drivers/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("edge")) {
                System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/test/resources/Drivers/msedgedriver.exe");
                driver = new EdgeDriver();
            } else {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/Drivers/chromedriver.exe");
                driver = new ChromeDriver();
            }
        }catch (Exception e){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/Drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }
    }
}
