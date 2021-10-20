package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import javax.swing.*;

public class C04_MouseActions2 extends TestBase {


    @Test
    public void test(){

        driver.get("https://demoqa.com/droppable");
        // 2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions=new Actions(driver);
        WebElement dragElementi=driver.findElement(By.id("draggable"));
        WebElement dropElementi=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        actions.dragAndDrop(dragElementi,dropElementi).perform();
      //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement droppedYazisi= driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String actualDroppedYazisi=droppedYazisi.getText();
        String expectedDroppedYazisi="Dropped!";
        Assert.assertEquals(actualDroppedYazisi,expectedDroppedYazisi,"dropped yazisi beklenenden farkllı");



    }
}
