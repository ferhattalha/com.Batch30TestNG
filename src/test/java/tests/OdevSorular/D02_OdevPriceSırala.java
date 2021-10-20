package tests.OdevSorular;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class D02_OdevPriceSırala extends TestBase {

    /*
     * Navigate to  https://www.saucedemo.com/
     * Enter the user name  as standard_user
     * Enter the password as   secret_sauce
     * Click on login button
     * Choose price low to high
     * Verify item prices are sorted from low to high
     */

    @Test

    public void test() throws InterruptedException {
        // Navigate to  https://www.saucedemo.com/
        driver.get("https://www.saucedemo.com/");
        // Enter the user name  as standard_user
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        // Enter the password as   secret_sauce
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        // Click on login button
        driver.findElement(By.id("login-button")).click();

        // Choose price low to high

        WebElement dd= driver.findElement(By.className("product_sort_container"));
        Select select=new Select(dd);
        Thread.sleep(2000);
        select.selectByVisibleText("Price (low to high)");
        Thread.sleep(1000);
        String expected=driver.findElement(By.className("active_option")).getText();
        String actual="PRICE (LOW TO HIGH)";
        Assert.assertTrue(expected.equals(actual));
    }
}





