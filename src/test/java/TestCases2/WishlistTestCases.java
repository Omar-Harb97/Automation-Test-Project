package TestCases2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class WishlistTestCases {
    WebDriver driver;

    @Test
    public void test1() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(RelativeLocator.with(By.cssSelector("button[class=\"button-2 add-to-wishlist-button\"]")).
                below(By.partialLinkText("HTC - One (M8) 4G LTE Cell Phone with 32GB Memory - Gunmetal (Sprint)"))).click();

        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        //It waits until the green notification bar disappears
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("bar-notification")));
        driver.findElement(By.className("wishlist-label")).click();
    }

}