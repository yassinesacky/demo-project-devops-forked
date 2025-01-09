package com.demo.pages;


import com.demo.utilities.BrowserUtils;
import com.demo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    @FindBy(id = "nav-global-location-popover-link")
    private WebElement locationSelection;

    @FindBy(id = "GLUXZipUpdateInput")
    private WebElement zipCodeSelection;

    @FindBy(xpath = "//span[.='Apply']//input")
    private WebElement applyButton;

    @FindBy(name = "glowDoneButton")
    private WebElement doneButton;

    @FindBy(xpath = "(//*[@id='GLUXConfirmClose'])[2]")
    private WebElement continueButton;





    public void selectLocation(String location) {
        locationSelection.click();
        zipCodeSelection.sendKeys(location);
        BrowserUtils.sleep(1);
        applyButton.click();
        BrowserUtils.sleep(1);
        continueButton.click();

    }


    public AmazonHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void searchForBook(String bookTitle) {
        searchBox.sendKeys(bookTitle);
        searchButton.click();
    }
}
