package com.checkers.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Driver {

    //create a private constructor to remove access to this object
    private Driver(){

    }

    private static WebDriver driver;//default value = bull

    //Create a reusable utility method that will return the same driver instance once we call it
    //if instance doesn't exist it will create it first and then it will always return the same instance
    public static WebDriver getDriver(){
        if(driver == null){
            //we will read our browser type from configuration.properties file
            //this way we can control which browser is opened from outside the code
            String browserType = ConfigurationReader.getProperty("browser");
            browserType = browserType.trim().toLowerCase();

            /*
            depending on the browser type returned from configuration.properties
            switch statement will determine the "case" and open the matching browser
             */
            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
            }

        }

        return driver;
    }

    /*Driver.closeDriver() will use the .quit() method
     to quit browser and then set driver value back to null
     */

    public static void closeDriver(){
        if(driver != null){
            //this line will terminate currently existing driver completely. It will not exist going forward
            driver.quit();
            //we assign the value back to null so that my singleton can create a newer one if needed
            driver = null;
        }
    }




}
