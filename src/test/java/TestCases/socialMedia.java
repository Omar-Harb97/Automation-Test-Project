package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;

public class socialMedia {
    WebDriver driver;
    SoftAssert softAssert;


    @Test
    public void validateNewElementalSeleniumTabIsOpen(){
        driver = new ChromeDriver();
        softAssert = new SoftAssert();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector("[href=\"https://www.facebook.com/nopCommerce\"]")).click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        String actuaulFBURL = driver.getCurrentUrl();
        softAssert.assertEquals(actuaulFBURL,"https://web.facebook.com/nopCommerce?_rdc=1&_rdr#");

        driver.switchTo().window(tabs.get(0));
        String actualNopCommerceURL = driver.getCurrentUrl();
        softAssert.assertEquals(actualNopCommerceURL,"https://demo.nopcommerce.com/");

        driver.findElement(By.cssSelector("[href=\"https://twitter.com/nopCommerce\"]")).click();
        ArrayList<String> Twittertab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(Twittertab.get(2));
        String actuaulTwitterURL = driver.getCurrentUrl();
        softAssert.assertEquals(actuaulTwitterURL,"https://x.com/nopCommerce");

        driver.switchTo().window(tabs.get(0));
        actualNopCommerceURL = driver.getCurrentUrl();
        softAssert.assertEquals(actualNopCommerceURL,"https://demo.nopcommerce.com/");

        driver.findElement(By.cssSelector("[href=\"https://www.youtube.com/user/nopCommerce\"]")).click();
        ArrayList<String> YouTubeTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(YouTubeTab.get(3));
        String actuaulYouTubeURL = driver.getCurrentUrl();
        softAssert.assertEquals(actuaulYouTubeURL,"https://www.youtube.com/user/nopCommerce");

        driver.switchTo().window(tabs.get(0));
        actualNopCommerceURL = driver.getCurrentUrl();
        softAssert.assertEquals(actualNopCommerceURL,"https://demo.nopcommerce.com/");

        driver.findElement(By.cssSelector("[href=\"https://www.instagram.com/nopcommerce_official\"]")).click();
        ArrayList<String> InstaTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(InstaTab.get(4));
        String actuaulBugURL = driver.getCurrentUrl();
        softAssert.assertEquals(actuaulBugURL,"https://www.instagram.com/nopcommerce_official");

        driver.switchTo().window(tabs.get(0));
        actualNopCommerceURL = driver.getCurrentUrl();
        softAssert.assertEquals(actualNopCommerceURL,"https://demo.nopcommerce.com/");

        String Check = null;
        if (actuaulBugURL == tabs.get(0))
        {
            Check = "True";

        } else if (actuaulBugURL != tabs.get(0)) {
            Check = "False";
            softAssert.assertEquals(actualNopCommerceURL,"https://demo.nopcommerce.com/");

        }
//        if (actualNopCommerceURL == "https://demo.nopcommerce.com/news/rss/1")
//        {
//            Check = "True";
//            softAssert.assertEquals(actualNopCommerceURL,"https://demo.nopcommerce.com/");
//
//        } else if (actualNopCommerceURL != "https://demo.nopcommerce.com/news/rss/1") {
//            Check = "False";
//        }
        softAssert.assertEquals(Check,"False");
        softAssert.assertAll();
    }
}
