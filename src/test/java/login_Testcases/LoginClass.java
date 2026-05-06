package login_Testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;

import java.time.Duration;

public class LoginClass {

    WebDriver driver;
    SoftAssert softAssert;
    pages.LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @Test
    public void LoginTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
        softAssert = new SoftAssert();

        loginPage.ValidLogin("standard_user", "secret_sauce");
        loginPage.loginBtn();

        String actualUrl = driver.getCurrentUrl();
        softAssert.assertEquals(actualUrl, "https://www.saucedemo.com/inventory.html");

        boolean ismenuDisplayed = driver.findElement(By.id("menu_button_container")).isDisplayed();



        softAssert.assertTrue(ismenuDisplayed);
        softAssert.assertAll();
    }

    @Test
    public void invalidLogin() {
        softAssert = new SoftAssert();
        loginPage = new LoginPage(driver);

        loginPage.insertInvalidEmail("invalid_username@Gmail.com", "invalid-password");
        loginPage.loginBtn();

        String invalidLoginMsg = driver.findElement(
                By.cssSelector("div[class=\"error-message-container error\"]")
        ).getText();

        String errorMSgColorRgba = driver.findElement(
                By.cssSelector("h3[data-test=\"error\"]")
        ).getCssValue("color");

        String errorMsgColorHex = Color.fromString(errorMSgColorRgba).asHex();

        softAssert.assertEquals(errorMsgColorHex, "#ffffff");
        softAssert.assertTrue(invalidLoginMsg.contains("Epic sadface: Username and password do not match any user in this service"));
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}