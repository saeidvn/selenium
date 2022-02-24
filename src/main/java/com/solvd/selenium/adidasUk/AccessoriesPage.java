package com.solvd.selenium.adidasUk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

import static java.time.Duration.ofSeconds;

public class AccessoriesPage {

    private WebDriver driver;

    private static final String URL = "https://www.adidas.co.uk/y_3-accessories";

    @FindBy(xpath = "//*[@class = 'plp-container-with-masking']")
    private List<WebElement> accessoriesResult;

    @FindBy(css = ".filter-panel-cta-btn___PnD1m")
    private WebElement filterButton;

    @FindBy(xpath = "//li[contains(@class,'sorting_option___3bTnn') and text()='Price (low - high)']")
    private WebElement lowPriceToHighButton;

    @FindBy(xpath = "//button[@class='gl-cta gl-cta--primary gl-cta--full-width']")
    private WebElement applyButton;

    @FindBy(xpath = "//li[contains(@class,'sorting_option___3bTnn') and text()='Price (high - low)']")
    private WebElement highPriceToLowButton;

    @FindBy(xpath = "//li[contains(@class,'sorting_option___3bTnn') and text()='Top Sellers']")
    private WebElement topSellersButton;

    public AccessoriesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get(URL);
    }

    public boolean isPageOpened() {
        return driver.getCurrentUrl().equals(URL);
    }

    public void clickFilterButton() {
        new WebDriverWait(driver, ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(filterButton));
        filterButton.click();
    }

    public void clickLowPriceToHigh() {
        new WebDriverWait(driver, ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(lowPriceToHighButton));
        lowPriceToHighButton.click();
    }

    public HighPriceToLow clickApply() {
        new WebDriverWait(driver, ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(applyButton));
        applyButton.click();
        return new HighPriceToLow(driver);
    }

    public void clickHighPriceToLow() {
        new WebDriverWait(driver, ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(highPriceToLowButton));
        highPriceToLowButton.click();
    }

    public LowPriceToHigh clickApplyButton() {
        new WebDriverWait(driver, ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(applyButton));
        applyButton.click();
        return new LowPriceToHigh(driver);
    }

    public TopSellers clickTopSellersButton() {
        new WebDriverWait(driver, ofSeconds(10)).until(ExpectedConditions.visibilityOf(topSellersButton));
        topSellersButton.click();
        return new TopSellers(driver);
    }

    public TopSellers applyButton() {
        new WebDriverWait(driver, ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(applyButton));
        applyButton.click();
        return new TopSellers(driver);
    }

    public void closePopUp() {
        driver.switchTo().activeElement().findElement(By.xpath("//button[@class='gl-modal__close']")).click();
    }

    public Boolean isFilterButtonIsVisible() {
        return filterButton.isDisplayed();
    }

    public Boolean isLowPriceToHighButtonIsVisible() {
        return lowPriceToHighButton.isDisplayed();
    }

    public Boolean isHighPriceToLowButtonIsVisible() {
        return highPriceToLowButton.isDisplayed();
    }

    public Boolean isTopSellersButtonIsVisible() {
        return topSellersButton.isDisplayed();
    }

    public Boolean isApplyButtonIsVisible() {
        return applyButton.isDisplayed();
    }

    public List<String> getAccessoriesResult() {
        return accessoriesResult.stream().map(o -> o.getText()).collect(Collectors.toList());
    }

}
