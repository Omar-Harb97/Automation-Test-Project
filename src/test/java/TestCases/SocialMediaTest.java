//cleaned and smarter way

package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
        import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class SocialMediaTest {

    WebDriver driver;
    SoftAssert softAssert;

    String baseUrl = "https://demo.nopcommerce.com/";

    // Locators
    By facebookIcon = By.cssSelector("a[href*='facebook']");
    By twitterIcon = By.cssSelector("a[href*='twitter']");
    By youtubeIcon = By.cssSelector("a[href*='youtube']");
    By instagramIcon = By.cssSelector("a[href*='instagram']");

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        softAssert = new SoftAssert();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(baseUrl);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void validateSocialMediaLinks() {

        validateSocialLink(facebookIcon, "facebook");
        validateSocialLink(twitterIcon, "x.com");
        validateSocialLink(youtubeIcon, "youtube");
        validateSocialLink(instagramIcon, "instagram");

        softAssert.assertAll();
    }

    public void validateSocialLink(By locator, String expectedUrlPart) {

        String parentWindow = driver.getWindowHandle();

        driver.findElement(locator).click();

        switchToNewTab(parentWindow);

        String actualUrl = driver.getCurrentUrl();

        softAssert.assertTrue(actualUrl.contains(expectedUrlPart),
                "URL mismatch. Actual: " + actualUrl);

        driver.close();
        driver.switchTo().window(parentWindow);
    }

    public void switchToNewTab(String parentWindow) {
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
    }
}