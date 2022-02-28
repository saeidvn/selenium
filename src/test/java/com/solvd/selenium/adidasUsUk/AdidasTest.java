package com.solvd.selenium.adidasUsUk;

import com.solvd.selenium.adidasUk.AccessoriesPage;
import com.solvd.selenium.adidasUk.HighPriceToLow;
import com.solvd.selenium.adidasUk.LowPriceToHigh;
import com.solvd.selenium.adidasUk.TopSellers;
import org.openqa.selenium.JavascriptExecutor;
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

    /**
     * -Can't find help button!!!-
     *
     * @Test(description = "Open help page.")
     * public void checkHelpButton() {
     * AdidasHomePage adidasHomePage = new AdidasHomePage(driver);
     * //        adidasHomePage.clickHelpButton();
     * <p>
     * //        driver.navigate().to("https://www.adidas.com/us/help");
     * //        String pageTitle = driver.getTitle();
     * //        Boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Help page");
     * //        assertFalse(verifyTitle);
     * //
     * //        HelpPage helpPage = new HelpPage(driver);
     * //        WebElement helpResult = helpPage.getHelpResult();
     * //
     * //        Assert.assertTrue(helpResult.equals("https://www.adidas.com/us/help"), "Page not opened.");
     * <p>
     * }
     */


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

    }

    @Test(description = "Show wishlist.")
    public void checkWishList() {
        AdidasHomePage adidasHomePage = new AdidasHomePage(driver);
        Assert.assertTrue(adidasHomePage.isPageOpened(), "Adidas home page not found.");

        Assert.assertTrue(adidasHomePage.wishListButton.isDisplayed(), "WishList button not visible.");
        adidasHomePage.clickWishListButton();

        WishList wishList = new WishList(driver);
        Assert.assertTrue(wishList.isPageOpened(), "WishList not found.");

        List<String> wishListResult = wishList.getWishListResult();
        Assert.assertTrue(wishListResult.isEmpty(), "Wishlist is empty.");

    }

    @Test(description = "Check to use low price filter.")
    public void CheckAccessoriesPage() throws InterruptedException {
        Integer firstUnSort, firstSort;
        Integer secondUnSort, secondSort;
        Integer thirdUnSort, thirdSort;
        Integer fourthUnSort, fourthSort;

        AccessoriesPage accessoriesPage = new AccessoriesPage(driver);
        Assert.assertTrue(accessoriesPage.isPageOpened(), "Page not found.");

        ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(500,1000)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(1000,1500)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(1500,2000)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(2000,2500)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(2500,3000)");
        Thread.sleep(1000);

        firstUnSort = accessoriesPage.getProductPricesAsNumbers().get(0);
        secondUnSort = accessoriesPage.getProductPricesAsNumbers().get(3);
        thirdUnSort = accessoriesPage.getProductPricesAsNumbers().get(5);
        fourthUnSort = accessoriesPage.getProductPricesAsNumbers().get(7);

        accessoriesPage.clickFilterButton();
        Assert.assertTrue(accessoriesPage.isFilterButtonIsVisible(), "Filter button is not visible.");

        accessoriesPage.clickLowPriceToHigh();
        Assert.assertTrue(accessoriesPage.isLowPriceToHighButtonIsVisible(),
                "Low price to high button is not visible.");
        Assert.assertTrue(accessoriesPage.isApplyButtonIsVisible(), "Apply button should be visible");

        LowPriceToHigh lowPriceToHigh = accessoriesPage.clickApplyButton();
        accessoriesPage.closePopUp();

        ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(500,1000)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(1000,1500)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(1500,2000)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(2000,2500)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(2500,3000)");
        Thread.sleep(1000);

        firstSort = lowPriceToHigh.getProductPricesAsNumbers().get(0);
        Assert.assertNotEquals(firstUnSort, firstSort, "Products are equals.");

        secondSort = lowPriceToHigh.getProductPricesAsNumbers().get(3);
        Assert.assertNotEquals(secondUnSort, secondSort, "Products are equals.");

        thirdSort = lowPriceToHigh.getProductPricesAsNumbers().get(5);
        Assert.assertNotEquals(thirdUnSort, thirdSort, "Products are equals.");

        fourthSort = lowPriceToHigh.getProductPricesAsNumbers().get(7);
        Assert.assertNotEquals(fourthUnSort, fourthSort, "Products are equals.");
    }

    @Test(description = "Check to use high price filter.")
    public void CheckHighToLowPage() throws InterruptedException {
        Integer firstUnSort, firstSort;
        Integer secondUnSort, secondSort;
        Integer thirdUnSort, thirdSort;
        Integer fourthUnSort, fourthSort;

        AccessoriesPage accessoriesPage = new AccessoriesPage(driver);
        Assert.assertTrue(accessoriesPage.isPageOpened(), "Page not found.");

        ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(500,1000)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(1000,1500)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(1500,2000)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(2000,2500)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(2500,3000)");
        Thread.sleep(1000);

        firstUnSort = accessoriesPage.getProductPricesAsNumbers().get(0);
        secondUnSort = accessoriesPage.getProductPricesAsNumbers().get(3);
        thirdUnSort = accessoriesPage.getProductPricesAsNumbers().get(5);
        fourthUnSort = accessoriesPage.getProductPricesAsNumbers().get(7);

        accessoriesPage.clickFilterButton();
        Assert.assertTrue(accessoriesPage.isFilterButtonIsVisible(), "Filter button is not visible.");

        accessoriesPage.clickHighPriceToLow();
        Assert.assertTrue(accessoriesPage.isHighPriceToLowButtonIsVisible(),
                "High price to low button is not visible.");
        Assert.assertTrue(accessoriesPage.isApplyButtonIsVisible(), "Apply button should be visible");

        HighPriceToLow highPriceToLow = accessoriesPage.clickApply();
        accessoriesPage.closePopUp();

        ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(500,1000)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(1000,1500)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(1500,2000)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(2000,2500)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(2500,3000)");
        Thread.sleep(1000);

        firstSort = highPriceToLow.getProductPricesAsNumbers().get(0);
        Assert.assertNotEquals(firstUnSort, firstSort, "Products are equals.");

        secondSort = highPriceToLow.getProductPricesAsNumbers().get(3);
        Assert.assertNotEquals(secondUnSort, secondSort, "Products are equals.");

        thirdSort = highPriceToLow.getProductPricesAsNumbers().get(5);
        Assert.assertNotEquals(thirdUnSort, thirdSort, "Products are equals.");

        fourthSort = highPriceToLow.getProductPricesAsNumbers().get(7);
        Assert.assertNotEquals(fourthUnSort, fourthSort, "Products are equals.");
    }

    @Test(description = "Check to use Top Sellers filter.")
    public void CheckTopSellersPage() throws InterruptedException {
        Integer firstUnSort, firstSort;
        Integer secondUnSort, secondSort;
        Integer thirdUnSort, thirdSort;
        Integer fourthUnSort, fourthSort;

        AccessoriesPage accessoriesPage = new AccessoriesPage(driver);
        Assert.assertTrue(accessoriesPage.isPageOpened(), "Page not found.");

        ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(500,1000)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(1000,1500)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(1500,2000)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(2000,2500)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(2500,3000)");
        Thread.sleep(1000);

        firstUnSort = accessoriesPage.getProductPricesAsNumbers().get(0);
        secondUnSort = accessoriesPage.getProductPricesAsNumbers().get(3);
        thirdUnSort = accessoriesPage.getProductPricesAsNumbers().get(5);
        fourthUnSort = accessoriesPage.getProductPricesAsNumbers().get(7);

        accessoriesPage.clickFilterButton();
        Assert.assertTrue(accessoriesPage.isFilterButtonIsVisible(), "Filter button is not visible.");

        accessoriesPage.clickTopSellersButton();
        Assert.assertTrue(accessoriesPage.isTopSellersButtonIsVisible(),
                "Top sellers button is not visible.");
        Assert.assertTrue(accessoriesPage.isApplyButtonIsVisible(), "Apply button should be visible");

        TopSellers topSellers = accessoriesPage.applyButton();
        accessoriesPage.closePopUp();

        ((JavascriptExecutor) driver).executeScript("scroll(0,500)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(500,1000)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(1000,1500)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(1500,2000)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(2000,2500)");
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("scroll(2500,3000)");
        Thread.sleep(1000);

        firstSort = topSellers.getProductPricesAsNumbers().get(0);
        Assert.assertNotEquals(firstUnSort, firstSort, "Products are equals.");

        secondSort = topSellers.getProductPricesAsNumbers().get(3);
        Assert.assertNotEquals(secondUnSort, secondSort, "Products are equals.");

        thirdSort = topSellers.getProductPricesAsNumbers().get(5);
        Assert.assertNotEquals(thirdUnSort, thirdSort, "Products are equals.");

        fourthSort = topSellers.getProductPricesAsNumbers().get(7);
        Assert.assertNotEquals(fourthUnSort, fourthSort, "Products are equals.");
    }

    @AfterClass
    public void afterTest() {
        driver.quit();
    }
}