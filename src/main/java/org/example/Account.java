package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

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
        TP_portal tp = new TP_portal(driver);
        WebElement btn =tp.account_details_option();
        btn.click();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void wallet_no_insert() throws InterruptedException {
        TP_portal tp = new TP_portal(driver);
        WebElement wallet =tp.wallet_no_input_path();
        String Wallet = properties.getProperty("Wallet");
        wallet.sendKeys(Wallet);



        WebElement btn =tp.wallet_no_input_taking_btn();
        btn.click();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void Details_txn_2_tab_open() throws InterruptedException {

        TP_portal tp = new TP_portal(driver);
        // Create an instance of the Actions class
        Actions actions = new Actions(driver);


        // Find the WebElement for the link you want to open in a new tab
        WebElement btn =tp.accounts_details_open_btn();

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

        // Find the WebElement for the link you want to open in a new tab
        WebElement btn2 =tp.Txn_info_open_btn();
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
        TP_portal tp = new TP_portal(driver);
        WebElement btn =tp.click_refresh_btn();
        btn.click();
        Thread.sleep(2000);

    }

    @Test(priority = 8)
    public void update_wallet_status() throws InterruptedException {
        TP_portal tp = new TP_portal(driver);
        WebElement dropdown =tp.choose_status_dropdown();
        Thread.sleep(2000);
        Select select = new Select(dropdown);
        String status_name = properties.getProperty("Set_status");

// Select an option by visible text
        //select.selectByVisibleText(status_name);

// Or select an option by value
        select.selectByValue(status_name);

// Or select an option by index (e.g., 3rd option)
        //select.selectByIndex(3);

        // select set_status button
        WebElement btn =tp.click_set_status_button();
        btn.click();

    }


    @Test(priority = 9)
    public void write_remark_for_set_status() throws InterruptedException {
        TP_portal tp = new TP_portal(driver);
        WebElement wallet =tp.click_remark_input();
        String remark = properties.getProperty("remark_input");
        wallet.sendKeys(remark);
    }

    @Test(priority = 10)
    public void set_status_confirm_btn() throws InterruptedException {
        TP_portal tp = new TP_portal(driver);
        WebElement btn =tp.set_status_confirm_btn();
        btn.click();
        Thread.sleep(4000);
    }
    @Test(priority = 11,enabled = false)
    public void set_status_cancel_btn() throws InterruptedException {
        TP_portal tp = new TP_portal(driver);
        WebElement btn =tp.set_status_cancel_btn();
        btn.click();
        Thread.sleep(4000);

    }
    @Test(priority = 12,enabled = true)
    public void send_otp_for_pin_reset() throws InterruptedException {

        /*TP_portal tp = new TP_portal(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the element is clickable
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(tp.send_otp_for_PIN_reset()));

        btn.click();*/
        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-v-2999d20f]")));
        button.click();*/
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate and click the close button of the modal (adjust the selector as necessary)
        // Assuming the close button has the class "close" and is within the modal
        /*WebElement closeModalButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#__BVID__44 button.close")));
        closeModalButton.click();
*/
        // Wait for the modal to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#__BVID__44")));

        // Now that the modal is closed, try clicking the button again
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-v-2999d20f]")));
        button.click();
    }
    @Test(priority = 13,enabled = true)
    public void cancel_send_otp_for_pin_reset() throws InterruptedException {
        TP_portal tp = new TP_portal(driver);
        WebElement btn =tp.send_otp_for_PIN_reset_cancel_btn();
        btn.click();
    }
    @Test(priority = 14,enabled = false)
    public void confirm_send_otp_for_pin_reset() throws InterruptedException {
        TP_portal tp = new TP_portal(driver);
        WebElement btn =tp.send_otp_for_PIN_reset_confirm_btn();
        btn.click();
    }

    @Test(priority = 15,enabled = true)
    public void set_from_and_to_date() throws InterruptedException {
        Thread.sleep(3000);
        TP_portal tp = new TP_portal(driver);
        WebElement btn =tp.select_calender1();
        btn.click();

        WebElement btn2 =tp.from_date_select();
        btn2.click();

        WebElement btn_ =tp.select_calender2();
        btn_.click();

        WebElement btn3 =tp.to_date_select();
        btn3.click();
    }

    @Test(priority = 16,enabled = true)
    public void result_size() throws InterruptedException {
        TP_portal tp = new TP_portal(driver);
        //WebElement input2 =tp.result_size_input();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        // Locate the input element using XPath and wait until it is clickable
        WebElement input2 = wait.until(ExpectedConditions.elementToBeClickable(tp.result_size_input()));

        input2.clear();
        String size = properties.getProperty("result_size_val");
        input2.sendKeys(size);

    }

    @Test(priority = 17,enabled = true)
    public void transaction_id_search() throws InterruptedException {
        TP_portal tp = new TP_portal(driver);
        WebElement input_field =tp.txn_id_input();
        String value = properties.getProperty("transaction_id");
        input_field.sendKeys(value);

    }

    @Test(priority = 18,enabled = true)
    public void txn_type_select() throws InterruptedException {
        TP_portal tp = new TP_portal(driver);
        WebElement dropdown =tp.choose_txn_type_dropdown();
        Thread.sleep(2000);
        Select select = new Select(dropdown);
        String type_name = properties.getProperty("txn_type");

// Select an option by visible text
        //select.selectByVisibleText(status_name);

// Or select an option by value
        select.selectByValue(type_name);

// Or select an option by index (e.g., 3rd option)
        //select.selectByIndex(3);

        // select set_status button

    }

    @Test(priority = 19,enabled = true)
    public void txn_status_select() throws InterruptedException {
        TP_portal tp = new TP_portal(driver);
        WebElement dropdown =tp.choose_txn_status_dropdown();
        Thread.sleep(2000);
        Select select = new Select(dropdown);
        String status_name = properties.getProperty("txn_status");

// Select an option by visible text
        //select.selectByVisibleText(status_name);

// Or select an option by value
        select.selectByValue(status_name);

// Or select an option by index (e.g., 3rd option)
        //select.selectByIndex(3);

        // select set_status button

    }

    @Test(priority = 20,enabled = true)
    public void search() throws InterruptedException {
        TP_portal tp = new TP_portal(driver);
        WebElement btn =tp.search_button();
        btn.click();

    }



}
