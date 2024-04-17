package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Accounts_tab_locator {
    private final WebDriver driver;
    public Accounts_tab_locator(WebDriver driver){

        this.driver = driver;

    }
    public WebElement account_tab_open()
    {
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/aside/ul/li[3]/a/span"));
    }
}
