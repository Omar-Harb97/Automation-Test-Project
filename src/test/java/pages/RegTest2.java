package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegTest2 {
    WebDriver driver;
    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By confirmationField = By.name("confirmPassword");
    By registerBtn = By.cssSelector("button[type='submit']");

    public RegTest2(WebDriver driver) {
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
}
