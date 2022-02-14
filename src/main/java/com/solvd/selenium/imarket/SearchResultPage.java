package com.solvd.selenium.imarket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SearchResultPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchResultPage.class);

    private WebDriver driver;

    //    @FindBy(xpath = "//p[@class='search-text-result']")
    @FindBy(css = ".search-text-result")
    private List<WebElement> productResults;

    //    @FindBy(xpath = "//a[@class='item-title']")
    @FindBy(css = ".item-title")
    private List<WebElement> productTitles;

    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get(driver.getCurrentUrl());
    }

    public List<WebElement> getProductResults() {
        return productResults;
    }

    public List<WebElement> getProductTitles() {
        return productTitles;
    }
}