package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class RegisterPage2 {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By confirmationField = By.name("confirmPassword");
    By registerBtn = By.cssSelector("button[type='submit']");

    public RegisterPage2(WebDriver driver) {
        this.driver = driver;
    }


    public void insertusername(String username, String password, String confirmationField) {
        this.driver.findElement(this.usernameField).sendKeys(new CharSequence[]{username});
        this.driver.findElement(this.passwordField).sendKeys(new CharSequence[]{password});
        this.driver.findElement(this.confirmationField).sendKeys(new CharSequence[]{confirmationField});
    }

    public void registerationBtn() {
        this.driver.findElement(this.registerBtn).click();
    }

    public void CheckReg() {
        String actualUrl = this.driver.getCurrentUrl();
        boolean isMesgDisplayed = this.driver.findElement(By.cssSelector("#flash")).isDisplayed();
        this.softAssert.assertEquals(actualUrl, "https://practice.expandtesting.com/login");
        this.softAssert.assertEquals(isMesgDisplayed, true);
        this.softAssert.assertTrue(isMesgDisplayed);
        this.softAssert.assertAll();
    }
}
