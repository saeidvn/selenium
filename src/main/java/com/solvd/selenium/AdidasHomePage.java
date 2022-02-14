package com.solvd.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdidasHomePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdidasHomePage.class);

    private WebDriver driver;

    @FindBy(xpath = "//input[@class='searchinput___zXLAR']")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@action='/us/search']")
    private WebElement searchButton;

    public AdidasHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get("https://www.adidas.com/us");
    }

    public void typeInSearchInput(String productName){
        searchInput.sendKeys(productName);
    }

    public void submitSearchButton(){
        searchButton.submit();
    }

    public WebElement getSearchInput() {
        return searchInput;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }
}
