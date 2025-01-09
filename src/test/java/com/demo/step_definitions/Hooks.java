package com.demo.step_definitions;

import com.demo.pages.AmazonHomePage;
import com.demo.utilities.BrowserUtils;
import com.demo.utilities.ConfigurationReader;
import com.demo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {

    AmazonHomePage amazonHomePage;

    @Before (value = "@cydeo")
    public void login_cydeo_scenario_before(){
        Driver.getDriver().get(ConfigurationReader.getProperty("cydeo.url"));
    }

    @Before (value = "@amazon")
    public void amazon_home_scenario_before(){
        Driver.getDriver().get(ConfigurationReader.getProperty("amazon.url"));

        amazonHomePage = new AmazonHomePage();
      //  amazonHomePage.selectLocation("76205");
        Driver.getDriver().navigate().refresh();

    }

    @After
    public void teardownMethod(Scenario scenario){

        BrowserUtils.sleep(2);
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        Driver.closeDriver();

    }


}
