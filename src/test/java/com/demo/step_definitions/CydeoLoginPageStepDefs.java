package com.demo.step_definitions;

import com.demo.pages.CydeoLoginPage;
import com.demo.utilities.BrowserUtils;
import com.demo.utilities.ConfigurationReader;
import io.cucumber.java.en.*;

public class CydeoLoginPageStepDefs {

    CydeoLoginPage cydeoLoginPage;

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        cydeoLoginPage = new CydeoLoginPage();
        System.out.println("User is on the related page");
    }

    @When("User enters the valid username")
    public void user_enters_the_valid_username() {
        BrowserUtils.sleep(Integer.parseInt(ConfigurationReader.getProperty("slow.motion")));
        cydeoLoginPage.username.sendKeys(System.getenv("cydeo.username"));
    }

    @When("User enters the valid password")
    public void user_enters_the_valid_password() {
        BrowserUtils.sleep(Integer.parseInt(ConfigurationReader.getProperty("slow.motion")));
        cydeoLoginPage.password.sendKeys(System.getenv("cydeo.password"));
    }

    @When("User clicks the Continue button")
    public void user_clicks_the_continue_button() {
        BrowserUtils.sleep(Integer.parseInt(ConfigurationReader.getProperty("slow.motion")));
        cydeoLoginPage.continueButton.click();
    }

    @Then("Verify the user is on the dashboard page")
    public void verify_the_user_is_on_the_dashboard_page() {
        BrowserUtils.sleep(Integer.parseInt(ConfigurationReader.getProperty("slow.motion")));
        BrowserUtils.verifyTitle("Dashboard - Cydeo");
    }


    @When("User enters the invalid username as {string}")
    public void user_enters_the_invalid_username_as(String username) {
        BrowserUtils.sleep(Integer.parseInt(ConfigurationReader.getProperty("slow.motion")));
        cydeoLoginPage.username.sendKeys(username);
    }

    @When("User enters the invalid password as {string}")
    public void user_enters_the_invalid_password_as(String password) {
        BrowserUtils.sleep(5);
        cydeoLoginPage.password.sendKeys(password);

    }

    @Then("Verify the user is on the login page")
    public void verify_the_user_is_on_the_login_page() {
        BrowserUtils.sleep(5);
        BrowserUtils.verifyTitle("Log in | dashboard");

    }
}
