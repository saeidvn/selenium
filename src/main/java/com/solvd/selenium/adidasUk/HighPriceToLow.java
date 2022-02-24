package com.solvd.selenium.adidasUk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HighPriceToLow {

    public WebDriver driver;

    private static final String HIGHPRICE = "https://www.adidas.co.uk/y_3-accessories?sort=price-high-to-low";

    @FindBy(css = ".plp-container-with-masking")
    private List<WebElement> highPriceResult;

    public HighPriceToLow(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get(HIGHPRICE);
    }

    public List<WebElement> getHighPriceResult() {
        return highPriceResult;
    }

    public boolean isPageOpened() {
        return driver.getCurrentUrl().equals(HIGHPRICE);
    }
}