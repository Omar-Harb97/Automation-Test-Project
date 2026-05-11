package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class RegisterPage {
    WebDriver driver;
    By username = By.id("username");
    By passwordField = By.id("password");
    By confirmationField = By.id("confirmPassword");
    By registerBtn = By.cssSelector("button[type='submit']");

    public RegisterPage(WebDriver _driver) {
        this.driver = _driver;
    }

    public void insertusername(String username, String password, String confirmationPass) {
        this.driver.findElement(this.username).sendKeys(new CharSequence[]{username});
        this.driver.findElement(this.passwordField).sendKeys(new CharSequence[]{password});
        this.driver.findElement(this.confirmationField).sendKeys(new CharSequence[]{confirmationPass});
    }

    public void registerationBtn1() {
        this.driver.findElement(this.registerBtn).click();
    }

    public void registerationBtn(){

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(registerBtn));

        driver.findElement(registerBtn).click();
    }
}
