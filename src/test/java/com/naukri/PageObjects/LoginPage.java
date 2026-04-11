package com.naukri.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#login_Layer")
    WebElement loginLnk;

    @FindBy(css = "[placeholder='Enter your active Email ID / Username']")
    WebElement emailIDTxt;

    @FindBy(css = "[placeholder='Enter your password']")
    WebElement passwordTxt;

    @FindBy(css = ".loginButton")
    WebElement loginButton;

    // action methods

    public void clickOnLoginLink()
    {
        loginLnk.click();
    }

    public void enterEmail(String email)
    {
        emailIDTxt.sendKeys(email);
    }

    public void enterPassword(String pass)
    {
        passwordTxt.sendKeys(pass);
    }

    public void clickOnLogin()
    {
        loginButton.click();
    }

}
