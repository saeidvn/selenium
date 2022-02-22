package com.solvd.selenium.adidas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AdidasTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdidasTest.class);

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/svahidnia/selenium/chromedriver");
        driver = new ChromeDriver();
    }

    @Test(description = "Search some product with a search bar")
    public void checkProductName() {
        AdidasHomePage adidasHomePage = new AdidasHomePage(driver);
        adidasHomePage.typeInSearchInput("BLACKHAWKS HOME AUTHENTIC JERSEY");
        adidasHomePage.submitSearchButton();

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        List<WebElement> searchProductResult = searchResultPage.getProductResult();

        Assert.assertFalse(searchProductResult.isEmpty(), "Sorry, there are no such products");
    }

    @Test(description = "Type special character in search bar")
    public void specialCharacterTest() {
        AdidasHomePage adidasHomePage = new AdidasHomePage(driver);
        adidasHomePage.typeInSearchInput("@!?#$%&*");
        adidasHomePage.submitSearchButton();

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        List<WebElement> searchProductResult = searchResultPage.getProductResult();

        Assert.assertTrue(searchProductResult.isEmpty(), "OOPS – NO RESULTS FOR '@!?#$%&*'.");
    }

    @Test(description = "Open help page.")
    public void checkHelpButton() {
        AdidasHomePage adidasHomePage = new AdidasHomePage(driver);
        adidasHomePage.clickHelpButton();

//        driver.navigate().to("https://www.adidas.com/us/help");
//        String pageTitle = driver.getTitle();
//        Boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Help page");
//        assertFalse(verifyTitle);

//        HelpPage helpPage = new HelpPage(driver);
//        WebElement helpResult = helpPage.getHelpResult();
//
//        Assert.assertTrue(helpResult.equals("https://www.adidas.com/us/help"), "Page not opened.");

    }

    @Test(description = "Login to account.")
    public void checkLogin() {
        AdidasHomePage adidasHomePage = new AdidasHomePage(driver);
        Assert.assertTrue(adidasHomePage.isPageOpened(), "Page not found.");
        adidasHomePage.clickLoginButton();
        adidasHomePage.clickLoginBox();
        adidasHomePage.typeLoginEmail("x7en0mx@yahoo.com");
        adidasHomePage.submitContinueButton();
        adidasHomePage.clickPasswordBox();
        adidasHomePage.typeLoginPassword("THP-bmy.ack1xed*amq");
        adidasHomePage.submitLoginAccountButton();

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        driver.getCurrentUrl();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(myAccountPage.pageContainName(),"Page not found.");

    }

    @Test(description = "Show wishlist.")
    public void checkWishList() {
        AdidasHomePage adidasHomePage = new AdidasHomePage(driver);
        adidasHomePage.clickWishListButton();

        WishList wishList = new WishList(driver);
        List<WebElement> wishListResult = wishList.getWishListResult();
        Assert.assertTrue(wishListResult.isEmpty(), "Wishlist is empty.");

        List<WebElement> wishListProducts = wishList.getWishListTitle();

        wishListProducts.forEach(item -> {
            item.getText();
            LOGGER.info("\nTitle: " + item.getText());
        });
    }

    @AfterClass
    public void afterTest() {
        driver.quit();
    }
}