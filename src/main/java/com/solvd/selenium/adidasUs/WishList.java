package com.solvd.selenium.adidasUs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WishList {

    private WebDriver driver;

    @FindBy(xpath = "//div[@data-auto-id='my-wishlist-view-container']//div[@xpath='1']")
    private List<WebElement> wishListResult;

    @FindBy(xpath = "//div[contains(@class, 'gl-vspace-bpall-small') and contains(@xpath, '1')]")
    private List<WebElement> wishListTitle;

    public WishList(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get(driver.getCurrentUrl());
    }

    public List<WebElement> getWishListResult() {
        return wishListResult;
    }

    public List<WebElement> getWishListTitle() {
        return wishListTitle;
    }
}
