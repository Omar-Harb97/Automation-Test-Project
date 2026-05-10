package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
    WebDriver driver;
    By firstNameField = By.id("FirstName");
    By lastNameField = By.id("LastName");
    By dayDropDown = By.name("DateOfBirthDay");
    By monthDropDown = By.name("DateOfBirthMonth");
    By yearDropDown = By.name("DateOfBirthYear");
    By emailField = By.id("Email");
    By companyField = By.name("Company");
    By passwordField = By.id("password");
    By confirmationField = By.id("confirmPassword");
    By maleRadioBtn = By.id("gender-male");
    By femaleRadioBtn = By.id("gender-female");
    By registerBtn = By.cssSelector("button[type='submit']");

    public RegisterPage(WebDriver _driver) {
        this.driver = _driver;
    }

    public void selectDayFromDayDropDown(String day) {
        Select selectDay = new Select(this.driver.findElement(this.dayDropDown));
        selectDay.selectByValue(day);
    }

    public void selectMonthFromMonthDropDown(String month) {
        Select selectmonth = new Select(this.driver.findElement(this.monthDropDown));
        selectmonth.selectByVisibleText(month);
    }

    public void selectYearFromYearDropDown(String year) {
        Select selectYear = new Select(this.driver.findElement(this.yearDropDown));
        selectYear.selectByValue(year);
    }

    public void insertName(String firstName, String lastName) {
        this.driver.findElement(this.firstNameField).sendKeys(new CharSequence[]{firstName});
        this.driver.findElement(this.lastNameField).sendKeys(new CharSequence[]{lastName});
    }

    public void insertusername(String email, String password, String confirmationPass) {
        this.driver.findElement(this.emailField).sendKeys(new CharSequence[]{email});
        this.driver.findElement(this.passwordField).sendKeys(new CharSequence[]{password});
        this.driver.findElement(this.confirmationField).sendKeys(new CharSequence[]{confirmationPass});
    }

    public void selectDateOfBirth(String day, String month, String year) {
        Select selectDay = new Select(this.driver.findElement(this.dayDropDown));
        selectDay.selectByValue(day);
        Select selectmonth = new Select(this.driver.findElement(this.monthDropDown));
        selectmonth.selectByVisibleText(month);
        Select selectYear = new Select(this.driver.findElement(this.yearDropDown));
        selectYear.selectByValue(year);
    }

    public void chooseGender(String gender) {
        if (gender == "male") {
            this.driver.findElement(this.maleRadioBtn).click();
        } else if (gender == "female") {
            this.driver.findElement(this.femaleRadioBtn).click();
        }

    }

    public void registerationBtn() {
        this.driver.findElement(this.registerBtn).click();
    }

    public void insertCompany(String company) {
        this.driver.findElement(this.companyField).sendKeys(new CharSequence[]{company});
    }

    public String getDayText(String day) {
        return this.driver.findElement(By.cssSelector("[name=\"DateOfBirthDay\"]>[value=\"" + day + "\"]")).getText();
    }

    public String getMonthText(String month) {
        return this.driver.findElement(By.cssSelector("[name=\"DateOfBirthMonth\"]>[value=\"" + month + "\"]")).getText();
    }

    public String getYearText(String year) {
        return this.driver.findElement(By.cssSelector("[name=\"DateOfBirthYear\"]>[value=\"" + year + "\"]")).getText();
    }
}
