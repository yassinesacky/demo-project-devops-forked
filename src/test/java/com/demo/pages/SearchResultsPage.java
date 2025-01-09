package com.demo.pages;


import com.demo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

    public SearchResultsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void selectBookByTitle(String bookTitle) {
        WebElement book = Driver.getDriver().findElement(By.xpath("//span[text()='" + bookTitle + "']"));
        book.click();
    }
}
