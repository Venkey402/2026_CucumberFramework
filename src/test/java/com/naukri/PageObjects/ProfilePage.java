package com.naukri.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
    WebDriver driver;
    public ProfilePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="#lazyResumeHead span.edit")
    WebElement profileEditIcon;

    @FindBy(css="#resumeHeadlineTxt")
    WebElement resumeHeadlineTxt;

    @FindBy(xpath = "//button[text()='Save']")
    WebElement saveBtn;

    @FindBy(xpath = "//*[text()='Resume Headline has been successfully saved.']")
    WebElement resumeHeadlineSavedMsg;

//Action methods

    public void clickProfileEdit()
    {
        profileEditIcon.click();
    }

    public String getResumeHeadline()
    {
        return resumeHeadlineTxt.getText();
    }

    public void setResumeHeadline(String headline)
    {
        resumeHeadlineTxt.clear();
        resumeHeadlineTxt.sendKeys(headline);
    }

    public void clickSave()
    {
        saveBtn.click();
    }

    public boolean isResumeHeadlineSaved()
    {
       return resumeHeadlineSavedMsg.isDisplayed();
    }

}
