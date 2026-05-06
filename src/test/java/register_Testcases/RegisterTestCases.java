package register_Testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegisterPage;
import java.time.Duration;

public class RegisterTestCases {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://practice.expandtesting.com/register");
    }

    @Test
    public void register(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.insertusername("omar-harb","SuperSecretPassword!","SuperSecretPassword!");
        registerPage.registerationBtn();

    }


/*    public void validateCorrectDayisChosen(){
        registerPage.selectDayFromDayDropDown("10");
        //String actualResult = driver.findElement(By.cssSelector("[name=\"DateOfBirthDay\"]>[value=\"10\"]")).getText();
        String actualResult = registerPage.getDayText("10");
        Assert.assertEquals(actualResult,"10");
    }*/

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    /*@Test
    public void testDeleteBtns() throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        SoftAssert softAssert = new SoftAssert();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        driver.findElement(By.cssSelector("button[onclick=\"addElement()\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("added-manually")).click();

        //softAssert.assertFalse(driver.findElement(By.className("added-manually")).isDisplayed());
        int numOfDeleteBtns = driver.findElements(By.className("added-manually")).size();
        softAssert.assertEquals(numOfDeleteBtns, 0);

        driver.findElement(By.cssSelector("button[onclick=\"addElement()\"]")).click();
        driver.findElement(By.cssSelector("button[onclick=\"addElement()\"]")).click();
        driver.findElement(By.cssSelector("button[onclick=\"addElement()\"]")).click();

        numOfDeleteBtns = driver.findElements(By.className("added-manually")).size();
        softAssert.assertEquals(numOfDeleteBtns, 3);


        //To find the second Delete button using findElements
        driver.findElements(By.className("added-manually")).get(1).click();

        //To find the second Delete button using xpath with index
        //driver.findElement(By.xpath("(//button[@class='added-manually'])[1]")).click();

        Thread.sleep(2000);
        driver.quit();
    }*/

}