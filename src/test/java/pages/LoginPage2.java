package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class LoginPage2 {
    WebDriver driver;
    SoftAssert softAssert;
    By usernameField = By.id("username");
    By passwordField = By.name("password");
    By loginByn = By.name("submit-login");

    public LoginPage2(WebDriver _driver) {this.driver = _driver;}

    public void ValidLogin2(String username, String password) {
        this.driver.findElement(this.usernameField).sendKeys(new CharSequence[]{username});
        this.driver.findElement(this.passwordField).sendKeys(new CharSequence[]{password});
    }

    public void loginBtn2() {
        this.driver.findElement(this.loginByn).click();
    }
    public void CheckLogin2() {
        String actualUrl = this.driver.getCurrentUrl();
        boolean isMesgDisplayed = this.driver.findElement(By.cssSelector("#flash")).isDisplayed();
        this.softAssert.assertEquals(actualUrl, "https://practice.expandtesting.com/secure");
        this.softAssert.assertEquals(isMesgDisplayed, true);
        this.softAssert.assertTrue(isMesgDisplayed);
        this.softAssert.assertAll();
    }


}
