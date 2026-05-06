package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase {
    @Test
    public void test(){
        //System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

        WebElement dayDropdownelement = driver.findElement(By.name("DateOfBirthDay"));
        Select selectDay = new Select(dayDropdownelement);
        //selectDay.selectByVisibleText("10");
        //selectDay.selectByValue("9");
        selectDay.selectByIndex(6);
        WebElement monthDropdownelement = driver.findElement(By.name("DataOfBirthMonth"));
        Select selectMonth = new Select(monthDropdownelement);
        selectMonth.selectByIndex(6);
        WebElement yearDropdownelement = driver.findElement(By.name("DataOfBirthYear"));
        Select selectYear = new Select(monthDropdownelement);
        selectYear.selectByIndex(6);


        driver.quit();

    }
}
