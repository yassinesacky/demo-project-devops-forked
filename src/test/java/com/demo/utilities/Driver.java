package com.demo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Driver {

    private Driver(){}


    private static WebDriver driver; // default value = null

    public static WebDriver getDriver(){
        if(driver == null){
            String browserType = System.getProperty("browser") !=null?System.getProperty("browser"): ConfigurationReader.getProperty("browser");
            switch (browserType){
                case "chrome":
                    driver=new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "chrome-headless":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                    driver=new ChromeDriver(options);
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    driver=new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox-headless":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--headless");
                    driver=new FirefoxDriver(firefoxOptions);
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "remote-chrome":
                    DesiredCapabilities capabilities = new DesiredCapabilities();
                    capabilities.setBrowserName("chrome");

                    try {
                         driver = new RemoteWebDriver(new URL(ConfigurationReader.getProperty("local.grid")+"/wd/hub"), capabilities);
                    } catch (MalformedURLException e) {

                    }
                    break;

                case "remote-firefox":
                    DesiredCapabilities firefox = new DesiredCapabilities();
                    firefox.setBrowserName("firefox");

                    try {
                        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefox);
                    } catch (MalformedURLException e) {

                    }
                    break;


                case "remote-chrome-aws":
                    ChromeOptions remoteOptions = new ChromeOptions();
                    remoteOptions.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu");
                    try {
                        driver = new RemoteWebDriver(new URL("http://54.89.147.119:4444/wd/hub"), remoteOptions);
                    } catch (MalformedURLException e) {

                    }
                    break;

                case "remote-firefox-aws":
                    FirefoxOptions firefoxOptions1 = new FirefoxOptions();
                    firefoxOptions1.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu");
                    try {
                        driver = new RemoteWebDriver(new URL("http://54.89.147.119:4444/wd/hub"), firefoxOptions1);
                    } catch (MalformedURLException e) {

                    }
                    break;

            }
        }
        return driver;

    }

    public static void closeDriver(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }

}
