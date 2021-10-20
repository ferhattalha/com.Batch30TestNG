package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;


/*

● Bir class olusturun: C02_IframeTest
  ● https://the-internet.herokuapp.com/iframe adresine gidin.
  ● Bir metod olusturun: iframeTest
 ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda  yazdirin.
 ○ Text Box’a “Merhaba Dunya!” yazin.
 ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.
 */

public class C02_IframeTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void iframeTest() throws InterruptedException {
// ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda     yazdirin.

        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement baslikyaziElementi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(baslikyaziElementi.isEnabled(), "baslik yazisi erişilebilir degil");
        System.out.println(baslikyaziElementi.getText());

        //      ○ Text Box’a “Merhaba Dunya!” yazin.

        driver.switchTo().frame(0);  // index ile gittik(0)   String seçip id ile gidebiliriz ("mce_0_ifr")
        WebElement yaziKutusu = driver.findElement(By.xpath("//*[@id='tinymce']"));

        yaziKutusu.clear();
        yaziKutusu.sendKeys("Merhaba Dünya");
        driver.switchTo().defaultContent();

        //      ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //      dogrulayin ve  konsolda yazdirin.

        WebElement elementalLinki = driver.findElement(By.linkText("Elemental Selenium"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(elementalLinki.isDisplayed());
        softAssert.assertAll();
        System.out.println(elementalLinki.getText());

         Thread.sleep(5000);
    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }
}