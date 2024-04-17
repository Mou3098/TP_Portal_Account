package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Tp_portal_login_test {

    public WebDriver driver;
    Properties properties = new Properties();


    public Tp_portal_login_test()
    {
        driver = new ChromeDriver();
        try (FileInputStream fis = new FileInputStream("src/main/resources/conf.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    }



    @Test(priority = 0)
    public void portal_login_display_load() throws InterruptedException {
        String tp_url = properties.getProperty("Tp_portal_url");
        driver.get(tp_url);
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void portal_login_input() throws InterruptedException {
        Tp_portal_login_locator tp = new Tp_portal_login_locator(driver);
        WebElement usr_name = tp.portal_login_usrname_locator();
        String username = properties.getProperty("Username");
        usr_name.sendKeys(username);

        WebElement password = tp.portal_login_password_locator();
        String paswrd = properties.getProperty("password");
        password.sendKeys(paswrd);

        WebElement login = tp.portal_login_button();
        login.click();
        Thread.sleep(2000);

    }

    @Test(priority = 2)
    public void portal_otp_input() throws InterruptedException {
        Tp_portal_login_locator tp = new Tp_portal_login_locator(driver);
        WebElement otp = tp.otp_input_locator();
        String OTP = properties.getProperty("OTP");
        otp.sendKeys(OTP);


        WebElement btn = tp.otp_btn_locator();
        btn.click();
        Thread.sleep(2000);

    }

}
