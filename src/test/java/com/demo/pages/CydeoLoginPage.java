package com.demo.pages;

import com.demo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CydeoLoginPage {

    public CydeoLoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(css = "button[type='submit']")
    public WebElement continueButton;



}
