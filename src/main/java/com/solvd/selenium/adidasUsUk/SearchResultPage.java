package com.solvd.selenium.adidasUsUk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage {

    public WebDriver driver;

    @FindBy(xpath = "//div[@class='count___1ZIhY gl-body--s']")
    private List<WebElement> productResult;

    public SearchResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get(driver.getCurrentUrl());
    }

    public List<WebElement> getProductResult() {
        return productResult;
    }

}