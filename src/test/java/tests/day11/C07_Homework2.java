package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C07_Homework2 extends TestBase {

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        Thread.sleep(1000);
        driver.findElement(By.linkText("Yeni Hesap Oluştur")).click();
        Thread.sleep(2000);
        WebElement name = driver.findElement(By.xpath("//input[@class='inputtext _58mg _5dba _2ph-']"));
        Actions actions = new Actions(driver);
        name.sendKeys("Tarik");
        WebElement genderswoman = driver.findElement(By.xpath("//input[@value = '1']"));
        WebElement gendersman = driver.findElement(By.xpath("//input[@value = '2']"));
        Thread.sleep(2000);
        actions.
                sendKeys(Keys.TAB).
                sendKeys("kumcu").
                sendKeys(Keys.TAB).
                sendKeys("51565").
                sendKeys(Keys.TAB).
                sendKeys("12345").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                click().
                sendKeys(Keys.ARROW_UP).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_UP).
                sendKeys(Keys.TAB).doubleClick(gendersman).
                perform();
        driver.findElement(By.name("websubmit")).click();
        Thread.sleep(2000);
    }
}

