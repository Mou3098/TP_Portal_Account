//locator class

package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TP_portal {

    private final WebDriver driver;
    public TP_portal(WebDriver driver){

        this.driver = driver;

    }
    //private  WebElement element = null;

    public WebElement portal_login_usrname_locator()
    {
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/section[2]/div[2]/form[1]/div/div[1]/input"));
    }
    public WebElement portal_login_password_locator()
    {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/section[2]/div[2]/form[1]/div/div[2]/input"));
        return element;
    }
    public WebElement portal_login_button()
    {
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/section[2]/div[2]/form[1]/div/div[3]/button"));
    }
    public WebElement otp_input_locator()
    {
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/section[2]/div[2]/form[1]/div/div[1]/div/input"));
    }
    public WebElement otp_btn_locator()
    {
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/section[2]/div[2]/form[1]/div/div[2]/button"));
    }
    public WebElement account_tab_open()
    {
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/aside/ul/li[3]/a/span"));
    }


}
