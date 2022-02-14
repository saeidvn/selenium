package com.solvd.selenium;

import com.solvd.selenium.adidas.AdidasHomePage;
import com.solvd.selenium.adidas.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Locale;

public class AdidasTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdidasTest.class);

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/svahidnia/selenium/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void checkProductName() {
        AdidasHomePage adidasHomePage = new AdidasHomePage(driver);
        adidasHomePage.typeInSearchInput("BLACKHAWKS HOME AUTHENTIC JERSEY");
        adidasHomePage.submitSearchButton();

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        List<WebElement> searchProductResult = searchResultPage.getProductResult();
//        Assert.assertFalse(searchProductResult.isEmpty(), "Product not found.");

        SoftAssert softAssert = new SoftAssert();
        searchProductResult.forEach(searchItem -> {
            softAssert.assertTrue(searchItem.getText().toLowerCase(Locale.ROOT).contains("blackhawks home authentic jersey"));
            LOGGER.info(searchItem.getText());
        });
        softAssert.assertAll();
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}