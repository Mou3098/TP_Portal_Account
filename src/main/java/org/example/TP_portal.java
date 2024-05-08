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

    public WebElement account_details_option()
    {
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/aside/ul/li[3]/ul/li[1]/a"));
    }
    public WebElement wallet_no_input_path()
    {
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/main/div[2]/div[2]/div/div/div/div/form/div/div[1]/input"));
    }
    public WebElement wallet_no_input_taking_btn()
    {
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/main/div[2]/div[2]/div/div/div/div/form/div/button"));
    }
    public WebElement accounts_details_open_btn()
    {
        return driver.findElement(By.xpath("//*[@id=\"wallet-xxx\"]/div/div/table/tbody/tr/td[7]/a[1]"));
    }
    public WebElement Txn_info_open_btn()
    {
        return driver.findElement(By.xpath("//*[@id=\"wallet-xxx\"]/div/div/table/tbody/tr/td[7]/a[2]"));
    }
    public WebElement click_refresh_btn()
    {
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/main/div[2]/div[2]/div/div[1]/div/div/div/div/div[1]/div/div[2]/h3/button"));
    }
    public WebElement choose_status_dropdown()
    {
        return driver.findElement(By.cssSelector(".form-control.form-control-sm"));
    }
    public WebElement click_set_status_button()
    {
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/main/div[2]/div[2]/div/div[1]/div/div/div/div/div[3]/div/div[2]/div/div[1]/form/div/div[2]/button"));
    }
    public WebElement click_remark_input()
    {
        return driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/input"));
    }
    public WebElement set_status_confirm_btn()
    {
        return driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/footer/button[2]"));
    }
    public WebElement set_status_cancel_btn()
    {
        return driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/footer/button[1]"));
    }
    public WebElement send_otp_for_PIN_reset()
    {
        return driver.findElement(By.xpath("/html/body/div/div[4]/main/div[2]/div[2]/div/div[1]/div/div/div/div/div[3]/div/div[2]/div/div[2]/button"));
    }
    public WebElement send_otp_for_PIN_reset_cancel_btn()
    {
        return driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/footer/button[1]"));
    }
    public WebElement send_otp_for_PIN_reset_confirm_btn()
    {
        return driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/footer/button[2]"));
    }

    public WebElement select_calender1()
    {
        return driver.findElement(By.xpath("/html/body/div/div[4]/main/div[2]/div[2]/div/div[2]/div/div/div[2]/div/form/div/div[1]/div/div[1]/span/span"));
    }

    public WebElement from_date_select()
    {
        return driver.findElement(By.xpath("/html/body/div/div[4]/main/div[2]/div[2]/div/div[2]/div/div/div[2]/div/form/div/div[1]/div/div[2]/div/span[11]"));
    }

    public WebElement select_calender2()
    {
        return driver.findElement(By.xpath("/html/body/div/div[4]/main/div[2]/div[2]/div/div[2]/div/div/div[2]/div/form/div/div[2]/div/div[1]/span/span"));
    }

    public WebElement to_date_select()
    {
        return driver.findElement(By.xpath("/html/body/div/div[4]/main/div[2]/div[2]/div/div[2]/div/div/div[2]/div/form/div/div[2]/div/div[2]/div/span[14]"));
    }

    public WebElement result_size_input()
    {
        return driver.findElement(By.xpath("//input[@data-v-e825805c and @type='number']"));
    }

    public WebElement txn_id_input()
    {
        return driver.findElement(By.xpath("/html/body/div/div[4]/main/div[2]/div[2]/div/div[2]/div/div/div[2]/div/form/div/div[4]/input"));
    }

    public WebElement choose_txn_type_dropdown()
    {
        return driver.findElement(By.xpath("/html/body/div/div[4]/main/div[2]/div[2]/div/div[2]/div/div/div[2]/div/form/div/div[5]/select"));
    }
    public WebElement choose_txn_status_dropdown()
    {
        return driver.findElement(By.xpath("/html/body/div/div[4]/main/div[2]/div[2]/div/div[2]/div/div/div[2]/div/form/div/div[6]/select"));
    }

    public WebElement search_button()
    {
        return driver.findElement(By.xpath("/html/body/div/div[4]/main/div[2]/div[2]/div/div[2]/div/div/div[2]/div/form/div/div[7]/button"));
    }


}
