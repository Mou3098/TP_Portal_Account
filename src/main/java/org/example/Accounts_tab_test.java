package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Accounts_tab_test {
    //public WebDriver driver;
    Properties properties = new Properties();


    /*public Accounts_tab_test(WebDriver driver)
    {
        //driver = new ChromeDriver();
        this.driver = driver;

    }*/

    public Accounts_tab_test() {
        try (FileInputStream fis = new FileInputStream("src/main/resources/conf.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }

    @Test(dataProvider = "dataProvider", dataProviderClass = Data_provider_login_to_accout_tab.class)
    public void testMethod(String sessionId) {
        // Initialize WebDriver using the session ID
        ChromeDriver driver = new ChromeDriver();
        driver.getSessionId().toString();

        try {
            // Reassign the session ID to the existing 'driver' variable
            driver = new ChromeDriver(ChromeDriverService.createDefaultService());

            // Your test logic here
            Accounts_tab_locator tp = new Accounts_tab_locator(driver);
            WebElement btn = tp.account_tab_open();
            btn.click();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close WebDriver
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
