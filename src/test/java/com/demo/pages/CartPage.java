package com.demo.pages;


import com.demo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    @FindBy(css = ".a-size-medium-plus")
    private WebElement confirmationMessage;

    public CartPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }
}
