package com.naukri.StepDefs;

import com.naukri.PageObjects.LoginPage;
import com.naukri.Utilities.config.ReadConfig;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class LoginStepDef {

    private static final Logger log = LoggerFactory.getLogger(LoginStepDef.class);
    ReadConfig readConfig = new ReadConfig();

    String resumeHeadline=readConfig.getResumeHeadline();
    String email=readConfig.getEmail();
    String pass=readConfig.getPassword();
    String url=readConfig.getUrl();

    public LoginStepDef() throws IOException {
    }

    @Given("user logins into naukri application")
    public void user_logins_into_naukri_application() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/Drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.get(url);

        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickOnLoginLink();
        loginPage.enterEmail(email);
        loginPage.enterPassword(pass);
        loginPage.clickOnLogin();

        // Beginning of  Home page

        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.naukri.com/mnjuser/homepage"));
        Assert.assertTrue(driver.findElement(By.cssSelector("[title='Venkat Mamidi']")).isDisplayed());

        driver.findElement(By.cssSelector("a[href='/mnjuser/profile']")).click();


        //driver.findElement(By.cssSelector("[value='Update resume']")).sendKeys(System.getProperty("user.dir")+"/src/test/resources/Attachments/Venkatrao Mamidi.pdf");
        //Thread.sleep(2000);

        // Beginning of profile page
        driver.findElement(By.cssSelector("#lazyResumeHead span.edit")).click();
        String currentResumeText=driver.findElement(By.cssSelector("#resumeHeadlineTxt")).getText();
        driver.findElement(By.cssSelector("#resumeHeadlineTxt")).clear();
        if(currentResumeText.equalsIgnoreCase(resumeHeadline)) {
            driver.findElement(By.cssSelector("#resumeHeadlineTxt")).sendKeys(resumeHeadline+".");
        }
        else {
            driver.findElement(By.cssSelector("#resumeHeadlineTxt")).sendKeys(resumeHeadline);
        }
        driver.findElement(By.xpath("//button[text()='Save']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Resume Headline has been successfully saved.']")).isDisplayed());
        driver.quit();
    }
    @When("user uploads resume")
    public void user_uploads_resume() {
        System.out.println("user logins into naukri application");
    }
    @When("users updates profile summary")
    public void users_updates_profile_summary() {
        System.out.println("user logins into naukri application");
    }
    @Then("user resume is updated")
    public void user_resume_is_updated() {
        System.out.println("user logins into naukri application");
    }
}
