package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import javax.swing.*;
import java.nio.file.WatchEvent;
import java.util.Set;

// 1-	Yeni bir class olusturalim: D14_MouseActions1

public class C03_MouseActions1 extends TestBase {

    @Test
            public void rightClick() throws InterruptedException {

        // 2-	https://the-internet.herokuapp.com/context_menu sitesine gidelim
    driver.get("https://the-internet.herokuapp.com/context_menu");

      //  3-	Cizili alan uzerinde sag click yapalim

        Actions actions=new Actions(driver);
      WebElement ciziliAlan= driver.findElement(By.xpath("//*[@id=\"hot-spot\"]"));

      actions.contextClick(ciziliAlan).perform();
        // 4-	Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.

       String expectedAlertYazisi="You selected a context menu";
       String actualAlertYazisi=driver.switchTo().alert().getText();

        Assert.assertEquals(actualAlertYazisi,expectedAlertYazisi,"mesaj istenen kelime icermiyor");
        //  5-	Tamam diyerek alert’I kapatalim
        driver.switchTo().alert().accept();

//  6-	Elemental Selenium linkine tiklayalim
        String ilkSayfaHandle=driver.getWindowHandle();
      driver.findElement(By.linkText("Elemental Selenium")).click();

       // 7-	Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        Set<String> windowTumHandlelar=driver.getWindowHandles();
        String ikinciSayfaHandle="";
        for (String each:windowTumHandlelar
        ) {
            if (!each.equals(ilkSayfaHandle)){
                ikinciSayfaHandle=each;
            }
        }
        driver.switchTo().window(ikinciSayfaHandle);
        String expectedIkinciSayfaYazi="Elemental Selenium";
        String actualIkinciSayfaYazisi=driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(actualIkinciSayfaYazisi,expectedIkinciSayfaYazi,"ikinci sayfadaki yai istenenden farkli");



      /*   Thread.sleep(5000);
        driver.switchTo().window(driver.getWindowHandle());
        Thread.sleep(3000);
        String actualh1=driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText();
        String expectedh1="Elemental Selenium";


        Assert.assertEquals(actualh1,expectedh1,"h1 tagında ifade icermiyor");*/



    }

}
