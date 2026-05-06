package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionClass {
    WebDriver driver;

    @Test
    public void test1() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        driver.get("https://demo.nopcommerce.com/");

        //1- Create actions object
        Actions actions = new Actions(driver);

        WebElement computersCategory = driver.findElement(By.cssSelector("[href=\"/computers\"]"));

        //2- Call methods or actions from actions object, dnt forget to add perform() felakher
        actions.moveToElement(computersCategory).perform();
    }
}
