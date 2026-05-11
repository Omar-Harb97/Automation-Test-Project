package TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class clicking_Test {
    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();
    WebDriverWait wait;


    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
    }
    @Test
    public void testDeleteBtns() throws InterruptedException {
        //to add new button
        driver.findElement(By.cssSelector("button[onclick=\"addElement()\"]")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));        //to delete the added button
        driver.findElement(By.className("added-manually")).click();
        int numOfDeleteBtns = driver.findElements(By.className("added-manually")).size();
        //verify that no delete button exist
        softAssert.assertEquals(numOfDeleteBtns, 0);
        //click 3 times to add 3 buttons
        driver.findElement(By.cssSelector("button[onclick=\"addElement()\"]")).click();
        driver.findElement(By.cssSelector("button[onclick=\"addElement()\"]")).click();
        driver.findElement(By.cssSelector("button[onclick=\"addElement()\"]")).click();
        //verify that 3 buttons added
        numOfDeleteBtns = driver.findElements(By.className("added-manually")).size();
        softAssert.assertEquals(numOfDeleteBtns, 3);

        //To find the second Delete button using findElements
        driver.findElements(By.className("added-manually")).get(1).click();

        //To find the third Delete button using xpath with index
        driver.findElement(By.xpath("(//button[@class='added-manually'])[2]")).click();
        softAssert.assertAll();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.quit();
    }
}
