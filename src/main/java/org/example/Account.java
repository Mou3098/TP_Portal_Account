package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
//import org.example.pageofall.

public class Account {
    public WebDriver driver;
    Properties properties = new Properties();


    public Account()
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
        TP_portal tp = new TP_portal(driver);
        WebElement otp = tp.otp_input_locator();
        String OTP = properties.getProperty("OTP");
        otp.sendKeys(OTP);


        WebElement btn = tp.otp_btn_locator();
        btn.click();
        Thread.sleep(2000);

    }

    @Test(priority = 3)
    public void go_accounts() throws InterruptedException {
        TP_portal tp = new TP_portal(driver);
        WebElement btn =tp.account_tab_open();
        btn.click();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void go_accounts_details_page() throws InterruptedException {
        WebElement btn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/aside/ul/li[3]/ul/li[1]/a"));
        btn.click();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void wallet_no_insert() throws InterruptedException {
        WebElement wallet = driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/main/div[2]/div[2]/div/div/div/div/form/div/div[1]/input"));
        String Wallet = properties.getProperty("Wallet");
        wallet.sendKeys(Wallet);


        WebElement btn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/main/div[2]/div[2]/div/div/div/div/form/div/button"));
        btn.click();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void Details_txn_2_tab_open() throws InterruptedException {

        // Create an instance of the Actions class
        Actions actions = new Actions(driver);
        // Find the WebElement for the link you want to open in a new tab
        WebElement btn = driver.findElement(By.xpath("//*[@id=\"wallet-xxx\"]/div/div/table/tbody/tr/td[7]/a[1]"));

        // Perform the action to open the link in a new tab (simulating CTRL + click)
        actions.keyDown(Keys.CONTROL).click(btn).keyUp(Keys.CONTROL).perform();

        // You can also use the following code if you want to open the link in a new window instead of a new tab
        // actions.keyDown(Keys.SHIFT).click(btn).keyUp(Keys.SHIFT).perform();

        // Wait for some time to let the new tab/window open (Adjust the time as needed)
        Thread.sleep(2000);

        // Switch to the new tab
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));


        // Switch back to the original tab/window if needed
        driver.switchTo().window(tabs.get(0));
        WebElement btn2 = driver.findElement(By.xpath("//*[@id=\"wallet-xxx\"]/div/div/table/tbody/tr/td[7]/a[2]"));

        // Perform the action to open the link in a new tab (simulating CTRL + click)
        actions.keyDown(Keys.CONTROL).click(btn2).keyUp(Keys.CONTROL).perform();

        // You can also use the following code if you want to open the link in a new window instead of a new tab
        // actions.keyDown(Keys.SHIFT).click(btn).keyUp(Keys.SHIFT).perform();

        // Wait for some time to let the new tab/window open (Adjust the time as needed)
        Thread.sleep(2000);

        // Switch to the new tab
        ArrayList<String> tab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(2));  // 0-for main tab, 1 -for details tab, 2- for txn info tab

        // You can now perform actions in the new tab/window

        // Optionally, you can close the new tab/window when you're done with it
        // driver.close();
    }

    @Test(priority = 7)
    public void Refresh_btn_current_blnc() throws InterruptedException {
        WebElement btn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/main/div[2]/div[2]/div/div[1]/div/div/div/div/div[1]/div/div[2]/h3/button"));
        btn.click();
        Thread.sleep(2000);

    }


}
