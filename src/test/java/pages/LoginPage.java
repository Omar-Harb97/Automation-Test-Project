package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class LoginPage {
    WebDriver driver;
    SoftAssert softAssert;
    By usernameField = By.id("user-name");
    By passwordField = By.name("password");
    By invalidEmailField = By.name("user-name");
    By invalidpasswordField = By.name("password");
    By loginByn = By.name("login-button");

    public LoginPage(WebDriver _driver) {
        this.driver = _driver;
    }

    public void ValidLogin(String email, String password) {
        this.driver.findElement(this.usernameField).sendKeys(new CharSequence[]{email});
        this.driver.findElement(this.passwordField).sendKeys(new CharSequence[]{password});
    }

    public void insertInvalidEmail(String invalidemail, String invalidpassword) {
        this.driver.findElement(this.invalidEmailField).sendKeys(new CharSequence[]{invalidemail});
        this.driver.findElement(this.invalidpasswordField).sendKeys(new CharSequence[]{invalidpassword});
    }

    public void CheckLogin() {
        String actualUrl = this.driver.getCurrentUrl();
        boolean isMenuDisplayed = this.driver.findElement(By.id("menu_button_container")).isDisplayed();
        this.softAssert.assertEquals(actualUrl, "https://www.saucedemo.com/inventory.html");
        this.softAssert.assertEquals(isMenuDisplayed, true);
        this.softAssert.assertTrue(isMenuDisplayed);
        this.softAssert.assertAll();
    }

    public void loginBtn() {
        this.driver.findElement(this.loginByn).click();
    }
}
