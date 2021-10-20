package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    protected WebDriver driver;
    /* -Biz test base class'ı sadece extends ile inherit ederek kullanacagız
    dolayısıyla oluşturdugumuz driver variable'ı icin protected access modifier'ı seçiyoruz.
    - Abstract yaparak o class'tan obje olusturulmasının önüne geçeriz.
     */

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

   @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

