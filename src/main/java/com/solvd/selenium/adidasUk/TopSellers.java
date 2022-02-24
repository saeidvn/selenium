package com.solvd.selenium.adidasUk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TopSellers {

    public WebDriver driver;

    private static final String TOPSELLERS = "https://www.adidas.co.uk/y_3-accessories?sort=top-sellers";

    @FindBy(css = ".plp-container-with-masking")
    private List<WebElement> topSellersResult;

    public TopSellers(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get(TOPSELLERS);
    }

    public List<WebElement> getTopSellersResult() {
        return topSellersResult;
    }

    public boolean isPageOpened() {
        return driver.getCurrentUrl().equals(TOPSELLERS);
    }
}