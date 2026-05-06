//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SkuSearchPage {
    WebDriver driver;
    By searchBtn = By.cssSelector("button[class=\"button-1 search-box-button\"");
    By product = By.partialLinkText("HTC - One (M8) 4G LTE Cell Phone with 32GB Memory - Gunmetal (Sprint)");
    By skuField = By.cssSelector("input[class=\"search-box-text ui-autocomplete-input\"]");

    public SkuSearchPage(WebDriver _driver) {
        this.driver = _driver;
    }

    public void Sku(String sku) {
        this.driver.findElement(this.skuField).sendKeys(new CharSequence[]{sku});
    }

    public void searchBtn() {
        this.driver.findElement(this.searchBtn).click();
    }

    public void Product() {
        this.driver.findElement(this.product).click();
    }

    public void check() {
        String SkuSearch = "M8_HTC_5L";
        boolean SkuDisplayed = this.driver.findElement(By.className("sku")).isDisplayed();
        Assert.assertTrue(SkuDisplayed);
        boolean SkuDisplayed2 = this.driver.findElement(By.id("sku-18")).isDisplayed();
        Assert.assertTrue(SkuDisplayed2);
        String SKUValue = this.driver.findElement(By.id("sku-18")).getText();
        Assert.assertEquals(SKUValue, SkuSearch);
    }
}
