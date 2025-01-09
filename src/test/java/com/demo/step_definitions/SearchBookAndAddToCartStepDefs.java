package com.demo.step_definitions;



import com.demo.pages.AmazonHomePage;
import com.demo.pages.BookDetailsPage;
import com.demo.pages.CartPage;
import com.demo.pages.SearchResultsPage;
import com.demo.utilities.BrowserUtils;
import com.demo.utilities.ConfigurationReader;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class SearchBookAndAddToCartStepDefs {
    AmazonHomePage homePage;
    SearchResultsPage resultsPage;
    BookDetailsPage detailsPage;
    CartPage cartPage;

    @Given("I am on the Amazon home page")
    public void i_am_on_the_amazon_home_page() {
        homePage = new AmazonHomePage();
        resultsPage = new SearchResultsPage();
        detailsPage = new BookDetailsPage();
        cartPage = new CartPage();
        System.out.println("User is on the related page");
    }

    @When("I search for {string}")
    public void i_search_for(String bookTitle) {
        BrowserUtils.sleep(Integer.parseInt(ConfigurationReader.getProperty("slow.motion")));
        homePage.searchForBook(bookTitle);
    }

    @When("I click on the book titled {string}")
    public void i_click_on_the_book_titled(String bookTitle) {
        BrowserUtils.sleep(Integer.parseInt(ConfigurationReader.getProperty("slow.motion")));

        resultsPage.selectBookByTitle(bookTitle);
    }

    @When("I add the book to the cart")
    public void i_add_the_book_to_the_cart() {
        BrowserUtils.sleep(Integer.parseInt(ConfigurationReader.getProperty("slow.motion")));

        detailsPage.addToCart();
    }

    @Then("I should see a confirmation message that the book was added to the cart")
    public void i_should_see_a_confirmation_message_that_the_book_was_added_to_the_cart() {
        BrowserUtils.sleep(Integer.parseInt(ConfigurationReader.getProperty("slow.motion")));
        String confirmationMessage = cartPage.getConfirmationMessage();
        Assert.assertTrue("Confirmation message is not displayed!", confirmationMessage.contains("Added to cart"));
    }
}
