package com.naukri.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="[title='Venkatarao Mamidi']")
    WebElement profileLbl;

    @FindBy(css="a[href='/mnjuser/profile']")
    WebElement viewProfilelnk;

    //action methods

    public boolean isProfileDisplayed()
    {
        return profileLbl.isDisplayed();
    }

    public void clickViewProfile()
    {
        viewProfilelnk.click();
    }
    public boolean verifyCurrentUrlContainsHomepage()
    {
        return driver.getCurrentUrl().contains("homepage");
    }

}
