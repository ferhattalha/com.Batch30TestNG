package tests.day11;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_Homework1 extends TestBase {

    //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
    @Test
    public void test() throws InterruptedException {
//2- Hover over Me First" kutusunun ustune gelin
        driver.get("http://webdriveruniversity.com/Actions");
        WebElement firstbtn= driver.findElement(By.xpath("//button[text()='Hover Over Me First!']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(firstbtn).perform();
        //3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[text()='Link 1'])[1]")).click();
        Thread.sleep(3000);
        //4- Popup mesajini yazdirin
        String   mesaj1=driver.switchTo().alert().getText();
        System.out.println(mesaj1);
        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6- "Click and hold" kutusuna basili tutun
        WebElement dont=driver.findElement(By.xpath("(//div[@id='click-box'])[1]"));
        actions.clickAndHold(dont).perform();
        //7-"Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement wellDoneMesaj=driver.findElement(By.xpath("(//div[@id='click-box'])[1]"));
        Thread.sleep(3000);
        System.out.println(wellDoneMesaj.getText());
//8- "Double click me" butonunu cift tiklayi
        WebElement doubleClick=driver.findElement(By.tagName("h2"));
        actions.doubleClick(doubleClick).perform();
    }
}
