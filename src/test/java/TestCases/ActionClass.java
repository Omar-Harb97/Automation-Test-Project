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
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        driver.get("https://demo.nopcommerce.com/");

        Actions actions = new Actions(driver);

        WebElement computersCategory = driver.findElement(By.cssSelector("[href=\"/computers\"]"));

        actions.moveToElement(computersCategory).perform();
    }
}
