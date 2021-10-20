package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class C01_WindowHandle2 extends TestBase {

    @Test

    public void test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement  actualText=driver.findElement(By.tagName("h3"));
        String expectedText="Opening a new window";

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualText,expectedText,"metin aynı degil");

        String expTitle="The Internet";
        String actualTitle= driver.getTitle();
        softAssert.assertEquals(actualTitle,expTitle, "baslık aynı degil");


        driver.switchTo().window(driver.getWindowHandle());
        driver.findElement(By.xpath("//*[@id='content']")).click();

        String expTitle2="New Window";
        String actualTitle2=driver.getTitle();
        softAssert.assertEquals(actualTitle2,expTitle2, "açılan baslık aynı degil");



        String actualYazi=driver.findElement(By.tagName("h3")).getText();

        String expectedYazi="New Window";

       softAssert.assertEquals(actualYazi,expectedYazi,"metin aynı degil");

       Thread.sleep(4000);
       driver.switchTo().defaultContent();

       Thread.sleep(4000);
        String expTitle1="The Internet";
        String actualTitle1= driver.getTitle();
        softAssert.assertEquals(actualTitle,expTitle, "baslık aynı degil");


    }

    public static class C05_IframeTest02 extends TestBase {

        @Test

        public void test() throws InterruptedException {

            driver.get("http://demo.guru99.com/test/guru99home/");

            int size = driver.findElements(By.tagName("iframe")).size();
            System.out.println(size);

            driver.switchTo().frame(0);
            WebElement iframeYoutube = driver.findElement(By.xpath("//div[@class='ytp-cued-thumbnail-overlay-image']"));

            driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();

            driver.switchTo().defaultContent();

            Thread.sleep(5000);

            driver.switchTo().frame("a077aa5e");


            driver.findElement(By.xpath("html/body/a/img")).click();
             Thread.sleep(5000);
        }
    }
}
