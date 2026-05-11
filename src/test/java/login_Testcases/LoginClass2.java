package login_Testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class LoginClass2 {  WebDriver driver;
    SoftAssert softAssert;
    pages.LoginPage2 loginPage2;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.navigate().to("https://practice.expandtesting.com/login");
    }

    @Test
    public void LoginTest2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage2 = new pages.LoginPage2(driver);
        softAssert = new SoftAssert();
        loginPage2.ValidLogin2("practice", "SuperSecretPassword!");
        loginPage2.loginBtn2();

        boolean isMesgDisplayed = this.driver.findElement(By.cssSelector("#flash")).isDisplayed();
        String actualUrl = driver.getCurrentUrl();
        softAssert.assertEquals(actualUrl, "https://practice.expandtesting.com/secure");
        softAssert.assertTrue(isMesgDisplayed);
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

