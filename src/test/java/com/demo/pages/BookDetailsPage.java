package com.demo.pages;


import com.demo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookDetailsPage {

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;

    public BookDetailsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void addToCart() {
        addToCartButton.click();
    }
}
