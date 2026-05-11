package register_Testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class RegisterNopcommerce {

    WebDriver driver;
    WebDriverWait wait;

    public RegisterNopcommerce(WebDriver driver) {
    }

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://demo.nopcommerce.com/register");
    }

    @Test
    public void registernop(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        pages.RegisterNopcommerce registerPage = new pages.RegisterNopcommerce(driver);
        registerPage.chooseGender("mail");
        registerPage.insertName("omar","harb","oharb@gmail.com");
        registerPage.insertCompany("NTG clarity");
        registerPage.insertPass("Oharb123456","Oharb123456");
        registerPage.registerationBtn();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
