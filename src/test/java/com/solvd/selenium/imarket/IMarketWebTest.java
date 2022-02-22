package com.solvd.selenium.imarket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class IMarketWebTest {

    public static final Logger LOGGER = LogManager.getLogger(IMarketWebTest.class);

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/svahidnia/selenium/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testSearchQuery() {
        HomePage homePage = new HomePage(driver);
        homePage.typeInSearchLine("nike");
        homePage.clickSearchButton();

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        List<WebElement> searchProductResults = searchResultPage.getProductResults();

        Assert.assertFalse(searchProductResults.isEmpty(), "Sorry, there are no such products");

        List<WebElement> productTitles = searchResultPage.getProductTitles();

        productTitles.forEach(item -> {
            item.getText();
            LOGGER.info("\nTitle: " + item.getText());
        });
    }

    @AfterClass
    public void afterTest() {
        driver.quit();
    }

}