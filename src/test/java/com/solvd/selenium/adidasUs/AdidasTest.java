package com.solvd.selenium.adidasUs;

import com.solvd.selenium.adidasUk.AccessoriesPage;
import com.solvd.selenium.adidasUk.HighPriceToLow;
import com.solvd.selenium.adidasUk.LowPriceToHigh;
import com.solvd.selenium.adidasUk.TopSellers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class AdidasTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdidasTest.class);

    private static final String EMAIL = "x7en0mx@yahoo.com";
    private static final String PASSWORD = "THP-bmy.ack1xed*amq";

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/svahidnia/selenium/chromedriver");
        driver = new ChromeDriver();
    }

    @Test(description = "Search some product with a search bar")
    public void checkProductName() {
        AdidasHomePage adidasHomePage = new AdidasHomePage(driver);
        adidasHomePage.typeInSearchInput("BLACKHAWKS HOME AUTHENTIC JERSEY\n");
        SearchResultPage searchResultPage = adidasHomePage.clickSearchButton();
        List<WebElement> searchProductResult = searchResultPage.getProductResult();

        Assert.assertTrue(searchProductResult.isEmpty(), "Sorry, there are no such products");
    }

    @Test(description = "Type special character in search bar")
    public void specialCharacterTest() {
        AdidasHomePage adidasHomePage = new AdidasHomePage(driver);
        adidasHomePage.typeInSearchInput("@!?#$%&*\n");
        SearchResultPage searchResultPage = adidasHomePage.clickSearchButton();
        List<WebElement> searchProductResult = searchResultPage.getProductResult();

        Assert.assertTrue(searchProductResult.isEmpty(), "OOPS – NO RESULTS FOR '@!?#$%&*'.");
    }

    @Test(description = "Open help page.")
    public void checkHelpButton() {
        AdidasHomePage adidasHomePage = new AdidasHomePage(driver);
//        adidasHomePage.clickHelpButton();

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
        Assert.assertTrue(adidasHomePage.isLoginBoxIsVisible());

        adidasHomePage.enterTextToLoginBox(EMAIL);
        Assert.assertEquals(adidasHomePage.getTextFromLoginBox(), EMAIL, "Email not equals");

        adidasHomePage.submitContinueButton();
        Assert.assertTrue(adidasHomePage.isPasswordBoxIsVisible());

        adidasHomePage.enterPasswordToPasswordBox(PASSWORD);
        Assert.assertEquals(adidasHomePage.getTextFromPasswordBox(), PASSWORD, "Password not equals");

        adidasHomePage.submitLoginAccountButton();

//        MyAccountPage myAccountPage = new MyAccountPage(driver);
//        myAccountPage.closePopUp();

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

    @Test
    public void CheckAccessoriesPage() {
        AccessoriesPage accessoriesPage = new AccessoriesPage(driver);
        Assert.assertTrue(accessoriesPage.isPageOpened(), "Page not found.");

        accessoriesPage.clickFilterButton();
        Assert.assertTrue(accessoriesPage.isFilterButtonIsVisible(), "Filter button is not visible.");

        accessoriesPage.clickLowPriceToHigh();
        Assert.assertTrue(accessoriesPage.isLowPriceToHighButtonIsVisible(),
                "Low price to high button not visible.");
        Assert.assertTrue(accessoriesPage.isApplyButtonIsVisible(), "Apply button should be visible");

        LowPriceToHigh lowPriceToHigh = accessoriesPage.clickApplyButton();

        accessoriesPage.closePopUp();
        List<WebElement> lowPriceResult = lowPriceToHigh.getLowPriceResult();
    }

    @Test
    public void CheckHighToLowPage() {
        AccessoriesPage accessoriesPage = new AccessoriesPage(driver);
        Assert.assertTrue(accessoriesPage.isPageOpened(), "Page not found.");

        accessoriesPage.clickFilterButton();
        Assert.assertTrue(accessoriesPage.isFilterButtonIsVisible(), "Filter button is not visible.");

        accessoriesPage.clickHighPriceToLow();
        Assert.assertTrue(accessoriesPage.isHighPriceToLowButtonIsVisible(),
                "High price to low button not visible.");
        Assert.assertTrue(accessoriesPage.isApplyButtonIsVisible(), "Apply button should be visible");


        HighPriceToLow highPriceToLow = accessoriesPage.clickApply();

        accessoriesPage.closePopUp();
        List<WebElement> highPriceResult = highPriceToLow.getHighPriceResult();
    }

    @Test
    public void CheckTopSellersPage() {
        AccessoriesPage accessoriesPage = new AccessoriesPage(driver);
        Assert.assertTrue(accessoriesPage.isPageOpened(), "Page not found.");

        accessoriesPage.clickFilterButton();
        Assert.assertTrue(accessoriesPage.isFilterButtonIsVisible(), "Filter button is not visible.");

        accessoriesPage.clickTopSellersButton();
        Assert.assertTrue(accessoriesPage.isTopSellersButtonIsVisible(),
                "Top sellers button not visible.");
        Assert.assertTrue(accessoriesPage.isApplyButtonIsVisible(), "Apply button should be visible");

        TopSellers topSellers = accessoriesPage.applyButton();

        accessoriesPage.closePopUp();
        List<WebElement> topSellersResult = topSellers.getTopSellersResult();
    }

    @AfterClass
    public void afterTest() {
        driver.quit();
    }
}