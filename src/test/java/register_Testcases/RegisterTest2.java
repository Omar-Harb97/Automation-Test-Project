package register_Testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegTest2;
import pages.LoginPage2;
import java.time.Duration;

public class RegisterTest2 {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://practice.expandtesting.com/register");
    }

    @Test
    public void register2(){
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        RegTest2 regTest2 = new RegTest2(driver);
        regTest2.insertusername("omar-harb","SuperSecretPassword!","SuperSecretPassword!");
        regTest2.registerationBtn();
    }

    @Test(dependsOnMethods = "register2")
    public void LoginPage2(){
        LoginPage2 loginPage2=new LoginPage2(driver);
        loginPage2.ValidLogin2("practice","SuperSecretPassword!");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}