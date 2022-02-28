package com.solvd.selenium.adidasUk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LowPriceToHigh {

    private final WebDriver driver;

    private static final String LOWPRICE = "https://www.adidas.co.uk/y_3-accessories?sort=price-low-to-high";

    @FindBy(xpath = "//div[@class = 'badge-container___DVUWN']/div/div")
    private List<WebElement> productPrices;

    public LowPriceToHigh(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get(LOWPRICE);
    }

    public List<String> getProductPricesAsStrings() {
        return this.productPrices.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<Integer> getProductPricesAsNumbers() {
        return this.getProductPricesAsStrings().stream()
                .map(price -> price.replaceAll("[^0-9]", ""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public boolean isPageOpened() {
        return driver.getCurrentUrl().equals(LOWPRICE);
    }

}