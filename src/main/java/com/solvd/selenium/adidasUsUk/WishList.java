package com.solvd.selenium.adidasUsUk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class WishList {

    private WebDriver driver;

    private static final String WISHLIST = "https://www.adidas.com/us/wishlists";

    @FindBy(xpath = "//div[@data-auto-id='my-wishlist-view-container']//div[@xpath='1']")
    private List<WebElement> wishListResult;

    public WishList(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get(driver.getCurrentUrl());
    }

    public List<String> getWishListResult() {
        return this.wishListResult.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public boolean isPageOpened() {
        return this.driver.getCurrentUrl().equals(WISHLIST);
    }
}
