package register_Testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.RegisterPage2;
import pages.LoginPage2;
import java.time.Duration;

public class RegisterTestCases2 {
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

    @Test(priority = 1)
    public void register2(){
        RegisterPage2 regTest2 = new RegisterPage2(driver);
        //need to change the username everytime we run this function
        regTest2.insertusername("omarharb71","SuperSecretPassword!","SuperSecretPassword!");
        regTest2.registerationBtn();
        regTest2.CheckReg();

    }


    //depend on the first test method (registration)
    @Test(priority = 2)
    public void LoginPage2(){
        LoginPage2 loginPage2=new LoginPage2(driver);
        loginPage2.ValidLogin2("practice","SuperSecretPassword!");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}