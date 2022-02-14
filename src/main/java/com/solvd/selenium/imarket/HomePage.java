package com.solvd.selenium.imarket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

    private WebDriver driver;

    //    @FindBy(xpath = "//input[@id='search_input']")
    @FindBy(css = "#search_input")
    private WebElement searchLineInput;

    //    @FindBy(xpath = "//button[@class='search-submit']")
    @FindBy(css = ".search-submit")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.driver.get("https://imarket.by/");
    }

    public void typeInSearchLine(String searchText) {
        searchLineInput.sendKeys(searchText);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

}