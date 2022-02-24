package com.solvd.selenium.adidasUk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LowPriceToHigh {

    public WebDriver driver;

    private static final String LOWPRICE = "https://www.adidas.co.uk/y_3-accessories?sort=price-low-to-high";

    @FindBy(css = ".plp-container-with-masking")
    private List<WebElement> lowPriceResult;

    public LowPriceToHigh(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get(LOWPRICE);
    }

    public List<WebElement> getLowPriceResult() {
        return lowPriceResult;
    }

    public boolean isPageOpened() {
        return driver.getCurrentUrl().equals(LOWPRICE);
    }

}
