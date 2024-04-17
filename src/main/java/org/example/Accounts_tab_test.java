package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Properties;

public class Accounts_tab_test {
    public WebDriver driver;
    Properties properties = new Properties();

    public void go_accounts() throws InterruptedException {
        TP_portal tp = new TP_portal(driver);
        WebElement btn =tp.account_tab_open();
        btn.click();
        Thread.sleep(2000);
    }
}
