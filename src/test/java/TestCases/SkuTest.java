package TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SkuSearchPage;
import java.time.Duration;

public class SkuTest {

        WebDriver driver;
        SkuSearchPage SkuSearch;
        SkuSearchPage SkuSearchPage;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(ops);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.navigate().to("https://demo.nopcommerce.com/");
    }

        @Test
        public void searchSku() {

            SkuSearchPage skuSearchPages = new SkuSearchPage(driver);
            skuSearchPages.Sku("M8_HTC_5L");
            skuSearchPages.searchBtn();
            skuSearchPages.Product();
            skuSearchPages.check();
        }
        @AfterMethod
        public void tearDown(){
            driver.quit();
        }
}
