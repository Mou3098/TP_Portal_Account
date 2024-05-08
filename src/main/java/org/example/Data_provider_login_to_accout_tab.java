package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class Data_provider_login_to_accout_tab {
    @DataProvider(name = "dataProvider")
    public static Object[][] provideData() {
        // Get WebDriver instance from the first test class
        WebDriver driver = new Tp_portal_login_test().getDriver();

        // Get the session ID of the WebDriver instance
        String sessionId = ((ChromeDriver) driver).getSessionId().toString();

        // Return session ID as data to be used by the second test class
        return new Object[][]{{sessionId}};
    }
}
